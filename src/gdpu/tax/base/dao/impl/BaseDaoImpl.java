package gdpu.tax.base.dao.impl;
import java.io.Serializable;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;


import gdpu.tax.base.dao.BaseDao;

public class BaseDaoImpl<T> implements BaseDao<T> {

	private Class<T>clazz;
	public BaseDaoImpl() {
		// TODO Auto-generated constructor stub
		//����T
		Type type=this.getClass().getGenericSuperclass();
		////��ȡType�Ĳ�������
		ParameterizedType pt=(ParameterizedType)type;
		//��ȡT��ʵ�ʴ��������
		Type[]types=pt.getActualTypeArguments();
		clazz=(Class<T>)types[0];
		System.out.println("����T�����ʵ�����ͣ�"+clazz);
		System.out.println(clazz.getSimpleName());
	}
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public List<T> findObjects(String hql) {
		//��ȡsession
		Session session = getSession();
		//��ȡ��ѯ����
		Query query = session.createQuery(hql);
		//ִ�в�ѯ
		List list = query.list();
		return list;
	}

	@Override
	public T findObjectById(Serializable id) {
		return getSession().get(clazz, id);
	}

	@Override
	public void save(T entity) {
		getSession().save(entity);
	}

	@Override
	public void update(T entity) {
		getSession().update(entity);
		
	}

	@Override
	public void delete(T entity) {
		getSession().delete(entity);
		
	}

	@Override
	public void deleteAll(Serializable[] ids) {
		Query query = getSession().createQuery("delete "+ clazz.getSimpleName() +" where id in :ids");
		//������:idsռλ����ֵ
		query.setParameterList("ids", ids);
		//����ָ��ִ��
		query.executeUpdate();
	}
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<T> searchObjects(String attr, String val) {
		List list=getSession().createCriteria(clazz.getClass()).add(Restrictions.eq(attr, val)).list();
		System.out.println(attr+"="+val);
		return list;
		
	}

	@Override
	public List<T> findObjects(String hql, Integer pageNo, Integer pageSize) {
		Session session = getSession();
		//��ȡ��ѯ����
		Query query = session.createQuery(hql);
		//ִ�в�ѯ
		query.setFirstResult((pageNo-1)*pageSize);
		query.setMaxResults(pageSize);
		List list = query.list();
		return list;
	}

	@Override
	public Long findTotalCount() {
		Query query=getSession().createQuery("select count(1) from "+clazz.getSimpleName());
		Long count=(Long)query.uniqueResult();
		return count;
		
	}

	@Override
	public List<T> findObjects(String hql, List<Object> conditions, Integer pageNo, Integer pageSize) {
		//��ȡsession
				Session session = getSession();
				//��ȡ��ѯ����
				Query query = session.createQuery(hql);
				
				//���ò�ѯ������ֵ
				if(conditions!=null && conditions.size()>0){
					for(int i=0 ;i < conditions.size() ;i++){
						query.setParameter(i, conditions.get(i));
					}
				}
				
				//���÷�ҳ����
				//select * from info limit ��ʼ�к� ��Ҫ��ѯ�ļ�¼��
				
				query.setFirstResult( (pageNo-1)*pageSize ) ;  //��ʼ�к�
				query.setMaxResults(pageSize);  //Ҫ��ѯ�ļ�¼��
				
				//ִ�в�ѯ
				List list = query.list();
				return list;
	}

	@Override
	public Long findTotalCount(String hql, List<Object> conditions) {
Query query = getSession().createQuery("select count(1) " + hql);
		
		//���ò�ѯ������ֵ
		if(conditions!=null && conditions.size()>0){
			for(int i=0 ;i < conditions.size() ;i++){
				query.setParameter(i, conditions.get(i));
			}
		}
		
		return (Long) query.uniqueResult();
	}

	

	

}

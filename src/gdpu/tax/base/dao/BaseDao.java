package gdpu.tax.base.dao;
import java.io.Serializable;
import java.util.List;
public interface BaseDao<T> {
	//��ѯ����
		public List<T> findObjects(String hql);
		
		//����id��ѯһ������
		public T findObjectById(Serializable id);
		
		//����
		public void save(T entity);
		
		//����
		public void update(T entity);
		
		//ɾ��һ��
		public void delete(T entity);
		
		
		//����idɾ������
		public void deleteAll(Serializable[] ids);
		
		//����
		public List<T> searchObjects(String attr, String val);
		//��ҳ
		
		public List<T> findObjects(String hql,Integer pageNo, Integer pageSize);
		
		public List<T> findObjects(String hql, List<Object>conditions,Integer pageNo, Integer pageSize);
		//��ѯ�ܼ�¼�� ����������������
		public Long findTotalCount(String hql, List<Object>conditions);
		
		public Long findTotalCount();
}

package gdpu.tax.base.service;

import java.io.Serializable;
import java.util.List;

import gdpu.tax.entity.Info;
import gdpu.tax.entity.PageResult;
import gdpu.tax.entity.User;

public interface Service<T> {
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
	
	public List<T> searchObjects(String attr, String val);
	
	public PageResult findObjects(String hql, Integer pageNo, Integer pageSize);

	public PageResult findObjects(String hql, List<Object> conditions, Integer pageNo, Integer pageSize);

}

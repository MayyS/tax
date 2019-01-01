package gdpu.tax.base.service;

import java.io.Serializable;
import java.util.List;

import gdpu.tax.entity.Info;
import gdpu.tax.entity.PageResult;
import gdpu.tax.entity.User;

public interface Service<T> {
	public List<T> findObjects(String hql);
	
	//根据id查询一行数据
	public T findObjectById(Serializable id);
	
	//保存
	public void save(T entity);
	
	//更新
	public void update(T entity);
	
	//删除一行
	public void delete(T entity);
	
	
	//根据id删除多行
	public void deleteAll(Serializable[] ids);
	
	public List<T> searchObjects(String attr, String val);
	
	public PageResult findObjects(String hql, Integer pageNo, Integer pageSize);

	public PageResult findObjects(String hql, List<Object> conditions, Integer pageNo, Integer pageSize);

}

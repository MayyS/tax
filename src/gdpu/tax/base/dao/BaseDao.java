package gdpu.tax.base.dao;
import java.io.Serializable;
import java.util.List;
public interface BaseDao<T> {
	//查询所有
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
		
		//搜索
		public List<T> searchObjects(String attr, String val);
		//分页
		
		public List<T> findObjects(String hql,Integer pageNo, Integer pageSize);
		
		public List<T> findObjects(String hql, List<Object>conditions,Integer pageNo, Integer pageSize);
		//查询总记录数 按条件／不按条件
		public Long findTotalCount(String hql, List<Object>conditions);
		
		public Long findTotalCount();
}

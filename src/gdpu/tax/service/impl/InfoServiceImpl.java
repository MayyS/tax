package gdpu.tax.service.impl;

import java.io.Serializable;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gdpu.tax.dao.InfoDao;
import gdpu.tax.entity.Info;
import gdpu.tax.entity.PageResult;
import gdpu.tax.service.InfoService;

@Service
@Transactional

public class InfoServiceImpl implements InfoService {
	@Autowired
	private InfoDao infoDao;

	@Override
	public List<Info> findObjects(String hql) {
		return infoDao.findObjects(hql);
	}

	@Override
	public Info findObjectById(Serializable id) {
		return infoDao.findObjectById(id);
	}

	@Override
	public void save(Info entity) {
		infoDao.save(entity);
	}

	@Override
	public void update(Info entity) {
		infoDao.update(entity);
	}

	@Override
	public void delete(Info entity) {
		infoDao.delete(entity);
	}

	@Override
	public void deleteAll(Serializable[] ids) {
		infoDao.deleteAll(ids);
	}

	@Override
	public PageResult findObjects(String hql, Integer pageNo, Integer pageSize) {
		List<Info> items =infoDao.findObjects(hql, pageNo, pageSize);
		
		Long totalCount=infoDao.findTotalCount();
		PageResult page=new PageResult(totalCount, pageNo, pageSize, items);
		return page;
	}

	@Override
	public List<Info> searchObjects(String attr, String val) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageResult findObjects(String hql, List<Object> conditions, Integer pageNo, Integer pageSize) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}

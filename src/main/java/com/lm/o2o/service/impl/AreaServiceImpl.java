package com.lm.o2o.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lm.o2o.dao.AreaDao;
import com.lm.o2o.entity.Area;
import com.lm.o2o.service.AreaService;
/**
 * 区域服务serviceImpl
 * @author LuoMan
 */
@Service
public class AreaServiceImpl implements AreaService{
	private final AreaDao areaDao;

	@Autowired
	public AreaServiceImpl(AreaDao areaDao) {
		this.areaDao = areaDao;
	}

	@Override
	public List<Area> getAreaList() {
		return areaDao.queryArea();
	}
	
}

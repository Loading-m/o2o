package com.lm.o2o.service;

import java.util.List;

import com.lm.o2o.entity.Area;

/**
 * 区域service
 * @author LuoMan
 */
public interface AreaService {
	/**
	 * 获取所有区域列表
	 * @return List
	 */
	List<Area> getAreaList();
}

package com.lm.o2o.dao;

import com.lm.o2o.entity.Shop;

public interface ShopDao {
    /**
     * 用于插入商铺数据
     * @param shop shop实体
     * @return 插入的条数
     */
	int insertShop(Shop shop);
}

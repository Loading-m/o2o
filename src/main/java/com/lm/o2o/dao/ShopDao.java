package com.lm.o2o.dao;

import com.lm.o2o.entity.Shop;
import org.springframework.stereotype.Component;

/**
 * @author LuoMan
 */
@Component
public interface ShopDao {
    /**
     * 用于插入商铺数据
     * @param shop shop实体
     * @return 插入的条数
     */
	int insertShop(Shop shop);

    /**
     * 更新店铺信息
     * @param shop shop实体
     * @return 插入的条数
     */
	int updateShop(Shop shop);
}

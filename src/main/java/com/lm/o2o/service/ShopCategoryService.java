package com.lm.o2o.service;

import com.lm.o2o.entity.ShopCategory;

import java.util.List;

/**
 * @author LuoMan
 */
public interface ShopCategoryService {
    /**
     * 获取分类列表
     * @param shopCategoryCondition
     * @return
     */
    List<ShopCategory> getShopCategoryList(ShopCategory shopCategoryCondition);
}

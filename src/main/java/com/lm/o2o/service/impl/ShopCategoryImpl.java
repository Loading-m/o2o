package com.lm.o2o.service.impl;

import com.lm.o2o.dao.ShopCategoryDao;
import com.lm.o2o.entity.ShopCategory;
import com.lm.o2o.service.ShopCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LuoMan
 */
@Service
public class ShopCategoryImpl implements ShopCategoryService {
    private final ShopCategoryDao shopCategoryDao;

    @Autowired
    public ShopCategoryImpl(ShopCategoryDao shopCategoryDao) {
        this.shopCategoryDao = shopCategoryDao;
    }

    @Override
    public List<ShopCategory> getShopCategoryList(ShopCategory shopCategoryCondition) {
        return shopCategoryDao.queryShopCategory(shopCategoryCondition);
    }
}

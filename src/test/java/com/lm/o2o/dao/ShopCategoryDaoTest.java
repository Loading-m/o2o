package com.lm.o2o.dao;

import com.lm.o2o.BaseTest;
import com.lm.o2o.entity.ShopCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ShopCategoryDaoTest extends BaseTest {
    @Autowired
    private ShopCategoryDao shopCategoryDao;
    @Test
    public void testQueryShopCategory(){
        List<ShopCategory> shopCategoryList = shopCategoryDao.queryShopCategory(new ShopCategory());
        assertEquals(18,shopCategoryList.size());
        ShopCategory shopCategory = new ShopCategory();
        shopCategory.setShopCategoryId(10L);
        shopCategory.setParent(shopCategory);
        List<ShopCategory> shopCategoryList1 = shopCategoryDao.queryShopCategory(shopCategory);
        assertEquals(2,shopCategoryList1.size());
    }
}

package com.lm.o2o.service;

import com.lm.o2o.BaseTest;
import com.lm.o2o.dto.ShopExecution;
import com.lm.o2o.entity.Area;
import com.lm.o2o.entity.PersonInfo;
import com.lm.o2o.entity.Shop;
import com.lm.o2o.entity.ShopCategory;
import com.lm.o2o.enums.ShopStateEnum;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class ShopServiceTest extends BaseTest {
    @Autowired
    private ShopService shopService;

    @Test
    public void testAddShop() {
        Shop shop = new Shop();
        PersonInfo owner = new PersonInfo();
        owner.setUserId(8L);
        Area area = new Area();
        area.setAreaId(3L);
        ShopCategory shopCategory = new ShopCategory();
        shopCategory.setShopCategoryId(22L);
        shop.setOwner(owner);
        shop.setArea(area);
        shop.setShopCategory(shopCategory);
        shop.setShopName("测试的店铺1");
        shop.setShopDesc("test1");
        shop.setShopAddr("test1");
        shop.setPhone("test1");
        shop.setCreateTime(new Date());
        shop.setEnableStatus(ShopStateEnum.CHECK.getState());
        shop.setAdvice("审核中");
        File shopImg = new File("3.png");
//        ShopExecution se = shopService.addShop(shop);
//        assertEquals(ShopStateEnum.CHECK.getState(), se.getState());
    }
}

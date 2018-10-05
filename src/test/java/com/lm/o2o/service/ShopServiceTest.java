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
    public void testAddShop() throws FileNotFoundException {
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
        shop.setShopName("测试的店铺3");
        shop.setShopDesc("test3");
        shop.setShopAddr("test3");
        shop.setPhone("test3");
        shop.setCreateTime(new Date());
        shop.setEnableStatus(ShopStateEnum.CHECK.getState());
        shop.setAdvice("审核中");
        File shopImg = new File("E:/3.png");
        System.out.println(shopImg.getPath());
        InputStream is = new FileInputStream(shopImg);
        ShopExecution se = shopService.addShop(shop, is, shopImg.getName());
        assertEquals(ShopStateEnum.CHECK.getState(), se.getState());
    }
}

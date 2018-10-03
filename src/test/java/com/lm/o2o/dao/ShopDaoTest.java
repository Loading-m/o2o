package com.lm.o2o.dao;

import com.lm.o2o.BaseTest;
import com.lm.o2o.entity.Area;
import com.lm.o2o.entity.PersonInfo;
import com.lm.o2o.entity.Shop;
import com.lm.o2o.entity.ShopCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.Assert.assertEquals;


public class ShopDaoTest extends BaseTest{
	@Autowired
	private ShopDao shopDao;
	@Test
	public void testInsertShop() {
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
		shop.setShopName("测试的店铺");
		shop.setShopDesc("test");
		shop.setShopAddr("test");
		shop.setPhone("test");
		shop.setShopImg("test");
		shop.setCreateTime(new Date());
		shop.setEnableStatus(1);
		shop.setAdvice("审核中");
		int effectedNum = shopDao.insertShop(shop);
		assertEquals(1,effectedNum);
	}
}

package com.lm.o2o.service;

import com.lm.o2o.BaseTest;
import com.lm.o2o.dto.ShopExecution;
import com.lm.o2o.entity.Area;
import com.lm.o2o.entity.PersonInfo;
import com.lm.o2o.entity.Shop;
import com.lm.o2o.entity.ShopCategory;
import com.lm.o2o.enums.ShopStateEnum;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemHeaders;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

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
        FileItem fi = new FileItem() {
            @Override
            public FileItemHeaders getHeaders() {
                return null;
            }

            @Override
            public void setHeaders(FileItemHeaders fileItemHeaders) {

            }

            @Override
            public InputStream getInputStream() throws IOException {
                FileInputStream fis = new FileInputStream(shopImg);
                int l;
                while ((l = fis.read()) != -1) {
                    System.out.println((char) l);
                }
                fis.close();
                return fis;
            }

            @Override
            public String getContentType() {
                return null;
            }

            @Override
            public String getName() {
                return null;
            }

            @Override
            public boolean isInMemory() {
                return false;
            }

            @Override
            public long getSize() {
                return 0;
            }

            @Override
            public byte[] get() {
                return new byte[0];
            }

            @Override
            public String getString(String s) throws UnsupportedEncodingException {
                return null;
            }

            @Override
            public String getString() {
                return null;
            }

            @Override
            public void write(File file) throws Exception {

            }

            @Override
            public void delete() {

            }

            @Override
            public String getFieldName() {
                return null;
            }

            @Override
            public void setFieldName(String s) {

            }

            @Override
            public boolean isFormField() {
                return false;
            }

            @Override
            public void setFormField(boolean b) {

            }

            @Override
            public OutputStream getOutputStream() throws IOException {
                return null;
            }
        };
        CommonsMultipartFile cmf = new CommonsMultipartFile(fi);
        ShopExecution se = shopService.addShop(shop, cmf);
        assertEquals(ShopStateEnum.CHECK.getState(), se.getState());
    }
}

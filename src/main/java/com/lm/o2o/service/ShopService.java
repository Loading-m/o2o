package com.lm.o2o.service;

import com.lm.o2o.dto.ShopExecution;
import com.lm.o2o.entity.Shop;
import org.springframework.web.multipart.commons.CommonsMultipartFile;


/**
 * @author LuoMan
 */
public interface ShopService {
    /**
     * 添加店铺
     * @param shop
     * @param shopImg
     * @return
     */
    ShopExecution addShop(Shop shop, CommonsMultipartFile shopImg);
}

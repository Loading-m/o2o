package com.lm.o2o;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 配置Spring和junit整合 启动时加载springIOC容器
 * @author LuoMan
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junitSpring配置文件在哪
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
public class BaseTest {
	
}

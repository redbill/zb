package cn.com.hugedata.web.fsm.config;
import javax.annotation.Resource;  

import org.junit.Before;  
import org.junit.Test;  
import org.junit.runner.RunWith;  
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;  
import org.springframework.context.support.ClassPathXmlApplicationContext;  
import org.springframework.test.context.ContextConfiguration;  
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;  
  



import cn.com.hugedata.web.fsm.user.service.UserService;

import com.alibaba.fastjson.JSON;  
  
@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类  
@ContextConfiguration(locations = {"classpath:config/spring-mybatis.xml"}) 

public class MyBatisTest {
	
	private static Logger logger = LoggerFactory
			.getLogger(MyBatisTest.class);  
//  private ApplicationContext ac = null;  
    @Resource  
    private UserService userService = null;  
  
//  @Before  
//  public void before() {  
//      ac = new ClassPathXmlApplicationContext("applicationContext.xml");  
//      userService = (IUserService) ac.getBean("userService");  
//  }  
  
    @Test  
    public void test1() {  
        cn.com.hugedata.web.fsm.user.model.UserInfo user = userService.getUserById(1);  
        // System.out.println(user.getUserName());  
        // logger.info("值："+user.getUserName());  
        logger.info(JSON.toJSONString(user));  
     //   System.out.println(user.getUserName());
    }  

}

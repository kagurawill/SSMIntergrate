package com.wzy;

import com.alibaba.fastjson.JSON;
import com.wzy.domain.User;
import com.wzy.service.UserService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)//加这些注解junit就可以帮助注入bean
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class TestMybatis {
    private static Logger log = Logger.getLogger(TestMybatis.class);
    @Autowired
    private UserService userService;
    @Test
    public void testSpringWithMybatis(){
        /*
        Invalid bound statement (not found): com.wzy.dao.UserMapper.selectByPrimaryKey
        war包里面缺少Mapper对应的xml文件，也就是没有把xml文件打包进去。解决办法是，
        在pom.xml文件中的build标签中添加如下代码，显示的强制将xml文件打到war包中：也可尝试将mapper接口和mapper.xml文件放到同一目录

        */
        User user = userService.getUserById(2);
        log.info(JSON.toJSONString(user));
    }

}

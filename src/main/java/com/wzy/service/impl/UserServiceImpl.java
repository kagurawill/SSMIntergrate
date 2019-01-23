package com.wzy.service.impl;

import com.wzy.dao.UserMapper;
import com.wzy.domain.User;
import com.wzy.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource//和@Autowired的作用一样，只不过Resource默认是按照名字注入，而AutoWired是按照类型注入
    private UserMapper userMapper;
    @Override
    public User getUserById(int userId){
        return userMapper.selectByPrimaryKey(userId);
    }

}

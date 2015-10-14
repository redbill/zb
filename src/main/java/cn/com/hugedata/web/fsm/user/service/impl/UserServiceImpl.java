package cn.com.hugedata.web.fsm.user.service.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.hugedata.web.fsm.user.dao.UserInfoMapper;
import cn.com.hugedata.web.fsm.user.model.UserInfo;
import cn.com.hugedata.web.fsm.user.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {  
	@Resource
    private UserInfoMapper userMapper;  
    
    public UserInfo getUserById(int userId) {  
        // TODO Auto-generated method stub  
        return this.userMapper.selectByPrimaryKey(userId);  
    } 
}

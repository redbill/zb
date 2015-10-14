package cn.com.hugedata.web.fsm.common.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.com.hugedata.web.fsm.common.service.LoginService;
import cn.com.hugedata.web.fsm.user.dao.UserInfoMapper;
import cn.com.hugedata.web.fsm.user.model.UserInfo;

@Service("loginService")
public class LoginServiceImpl implements LoginService {
	
	private UserInfoMapper userInfoMapper;
	
	public void setUserInfoMapper(UserInfoMapper userInfoMapper) {
		this.userInfoMapper = userInfoMapper;
	}



	public List<UserInfo> signin(UserInfo model) {
		 List<UserInfo> dataList = userInfoMapper.signin(model);
	        return dataList;
	}

}

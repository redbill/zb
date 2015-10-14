package cn.com.hugedata.web.fsm.common.service;

import java.util.List;

import cn.com.hugedata.web.fsm.user.model.UserInfo;

public interface LoginService {
	
	public List<UserInfo> signin(UserInfo model);
}

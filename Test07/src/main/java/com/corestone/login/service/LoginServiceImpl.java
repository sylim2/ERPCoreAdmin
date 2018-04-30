package com.corestone.login.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.corestone.login.dao.LoginDAO;

@Service
public class LoginServiceImpl extends SqlSessionDaoSupport implements LoginService{

	@Autowired
	LoginDAO logDAO;

	@Override
	public int loginCheck(HashMap<String, String> map){

		// TODO Auto-generated method stub
		//int identify = logDAO.loginIdentify(map);
		//return identify;
		return (Integer) getSqlSession().selectOne("loginService.loginCheck", map);
	}


	
	//@Override
	//public int getLoginResult(Map<String, String> map) {
	//	return (Integer) getSqlSession().selectOne("userDao.getLoginResult",map);
	//}

}


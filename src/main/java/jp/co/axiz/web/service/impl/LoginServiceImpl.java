package jp.co.axiz.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.axiz.web.dao.impl.User_infoDaoImpl;
import jp.co.axiz.web.entity.User_info;
import jp.co.axiz.web.service.LoginS;

@Service
public class LoginServiceImpl implements LoginS {

	@Autowired
	User_infoDaoImpl userDao;

	@Override
	public User_info findByIdPass(String id, String pass) {
		return userDao.findbyIdPass(id, pass);
	}

}

package jp.co.axiz.web.service;

import jp.co.axiz.web.entity.User_info;

public interface LoginS {

	User_info findByIdPass(String id, String pass);

}

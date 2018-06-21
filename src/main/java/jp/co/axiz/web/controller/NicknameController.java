package jp.co.axiz.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.axiz.web.dao.impl.User_infoDaoImpl;
import jp.co.axiz.web.entity.User_info;
import jp.co.axiz.web.form.Form;

@Controller
public class NicknameController {

	@Autowired
	HttpSession session;

	@Autowired
	User_infoDaoImpl userDao;

	//ニックネーム編集画面へ
	@RequestMapping("/nickname")
	public String nick (@ModelAttribute("form") Form form, Model model) {

		User_info user = (User_info) session.getAttribute("User");

		form.setNickname(user.getNickname());
		model.addAttribute("form", form);
		return "nick";
	}

	//ニックネーム編集
	@RequestMapping(value="/nickname", method=RequestMethod.POST)
	public String editNick (@ModelAttribute("form") Form form, Model model) {

		User_info user = (User_info) session.getAttribute("User");

		//ニックネーム編集処理
		userDao.updateNick(user.getUser_id(), form.getNickname());

		//セッションのユーザー情報更新
		user.setNickname(form.getNickname());
		session.setAttribute("User", user);

		return "nickResult";
	}

}

package jp.co.axiz.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.axiz.web.form.Form;

@Controller
public class NicknameController {

	//ニックネーム編集画面へ
	@RequestMapping("/nickname")
	public String nick (@ModelAttribute("form") Form form, Model model) {
		return "nick";
	}

	//ニックネーム編集
	@RequestMapping(value="/nickname", method=RequestMethod.POST)
	public String editNick (@ModelAttribute("form") Form form, Model model) {

		//ニックネーム編集処理
		return "nickResult";
	}

}

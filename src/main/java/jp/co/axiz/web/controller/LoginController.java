package jp.co.axiz.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.axiz.web.form.Login;

@Controller
public class LoginController {

	@RequestMapping("/index")
	public String login (@ModelAttribute("form") Login login, Model model) {
		return "index";
	}

}

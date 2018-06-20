package jp.co.axiz.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.axiz.web.form.Form;
import jp.co.axiz.web.form.Login;

@Controller
public class LoginController {

	@RequestMapping("/index")
	public String login (@ModelAttribute("form") Login login, Model model) {
		return "index";
	}

	//ログインフォームからマイページ（投稿記事一覧）へ
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String user (@ModelAttribute("form") Login login, Model model) {

		//ログインチェック


		//自分の記事全件表示


		return "user";
	}

	//メニューから投稿記事一覧リンクに飛んだ場合
	@RequestMapping("/user")
	public String myAll (@ModelAttribute("form") Form form, Model model) {


		//自分の記事全件表示
		return "user";
	}


	//メニューからログアウト
	@RequestMapping("/logout")
	public String logout (@ModelAttribute("form") Form form, Model model) {


		//ログアウト処理
		return "logout";
	}


}

package jp.co.axiz.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.axiz.web.entity.Art;
import jp.co.axiz.web.entity.User_info;
import jp.co.axiz.web.form.Form;
import jp.co.axiz.web.form.Login;
import jp.co.axiz.web.service.LoginS;
import jp.co.axiz.web.service.impl.ArtServiceImpl;

@Controller
public class LoginController {

	@Autowired
	private HttpSession session;

	@Autowired
	private LoginS loginS;

	@Autowired
	private ArtServiceImpl artS;

	@RequestMapping("/index")
	public String login (@ModelAttribute("form") Login login, Model model) {
		return "index";
	}

	//ログインフォームからマイページ（投稿記事一覧）へ
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String user (@Validated @ModelAttribute("form") Login login,
			BindingResult bindingResult, Model model) {

		//空欄チェック
		if (bindingResult.hasErrors()) {
			return "index";
		}

		//ID、PASSを元に検索
		User_info loginUser = loginS.findByIdPass(login.getId(), login.getPass());

		//ログインチェック
		if(loginUser == null) {
			model.addAttribute("msg", "IDかPASSWORDが間違っています");
			return "index";
		}

		//表示名（ニックネーム）のセット
		session.setAttribute("User", loginUser);

		//自分の記事全件表示
		//投稿した記事を一覧表示select
		List<Art> list = artS.selectMyAll(loginUser.getUser_id());

		model.addAttribute("list", list);

		return "user";
	}

	//メニューから投稿記事一覧リンクに飛んだ場合
	@RequestMapping("/user")
	public String myAll (@ModelAttribute("form") Form form, Model model) {
		User_info user = (User_info)session.getAttribute("User");

		//自分の記事全件表示
		//投稿した記事を一覧表示select
		List<Art> list = artS.selectMyAll(user.getUser_id());

		model.addAttribute("list", list);
		//自分の記事全件表示
		return "user";
	}


	//メニューからログアウト
	@RequestMapping("/logout")
	public String logout (@ModelAttribute("form") Form form, Model model) {
		//ログアウト処理
		session.invalidate();

		return "logout";
	}


}

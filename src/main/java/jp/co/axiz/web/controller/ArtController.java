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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jp.co.axiz.web.entity.Art;
import jp.co.axiz.web.entity.User_info;
import jp.co.axiz.web.form.ArtForm;
import jp.co.axiz.web.service.impl.ArtServiceImpl;
import jp.co.axiz.web.service.impl.CommentService;

@Controller
@SessionAttributes("artform")
public class ArtController {

	@Autowired
	HttpSession session;

	@Autowired
	ArtServiceImpl artS;

	@Autowired
	CommentService comS;

	//メニューから投稿画面へ
	@RequestMapping("/postArt")
	public String postArt (@ModelAttribute("form") ArtForm artform, Model model) {
		return "postArt";
	}

	//投稿画面から確認画面へ
	@RequestMapping(value="/postArtConfirm", method = RequestMethod.POST)
	public String postArtConfirm (@Validated @ModelAttribute("form") ArtForm artform,
			BindingResult bindingResult, Model model) {

		//空欄チェック
		if (bindingResult.hasErrors()) {
			return "postArt";
		}

		artform.setContent(artS.replace(artform.getContent()));

		//値を持ち越し
		model.addAttribute("postArt", artform);

		return "postArtConfirm";
	}

	@RequestMapping(value="/postArtResult", params="return", method = RequestMethod.POST)
	public String postArtReturn (@ModelAttribute("form") ArtForm artform, Model model) {
		if (artform.getContent() != null) {
			artform.setContent(artS.replaceR(artform.getContent()));
		}
	return "postArt";
	}

	@RequestMapping(value="/postArtResult", method = RequestMethod.POST)
	public String postArtResult (@ModelAttribute("form") ArtForm artform, Model model) {

		User_info user = (User_info) session.getAttribute("User");

		//記事投稿処理（DB）insert
		artS.insert(artform.getTitle(), artform.getContent(), user.getUser_id());

		//投稿した記事のidセット
		model.addAttribute("art_id", artS.lastId());

		return "postArtResult";
	}



	//メニューから編集記事選択画面へ
	@RequestMapping("/editArt")
	public String editArtAll (@ModelAttribute("form") ArtForm artform, Model model) {

		User_info user = (User_info) session.getAttribute("User");
		//投稿した記事を一覧表示select
		List<Art> list = artS.selectMyAll(user.getUser_id());

		model.addAttribute("list", list);
		return "editArtAll";
	}

	//選択画面から編集画面へ
	@RequestMapping("/editArtConfirm")
	public String editArt (@ModelAttribute("form") ArtForm artform, @RequestParam("art_id") Integer art_id, Model model) {
		//選択した記事の情報を表示する
		Art art = artS.selectArt(art_id);
		model.addAttribute("form", art);
		session.setAttribute("before", art);

		return "editArt";
	}

	//編集画面から完了画面へ
	@RequestMapping(value="/editArtResult", method = RequestMethod.POST)
	public String editArtResult (@Validated @ModelAttribute("form") ArtForm artform,
			BindingResult bindingResult, Model model) {
		//空欄チェック
		if (bindingResult.hasErrors()) {
			return "editArt";
		}

		Art before = (Art)session.getAttribute("before");

		//変更確認
		if (artS.change(before, artform)) {

			artform.setArt_id(before.getArt_id());

			//記事を編集するupdate
			artS.update(artform.getArt_id(), artform.getTitle(), artform.getContent());
			model.addAttribute("art_id", artform.getArt_id());
			return "editArtResult";

		} else {
			model.addAttribute("msg", "記事を変更してください");
			return "editArt";
		}
	}


	//メニューから削除記事選択画面へ
	@RequestMapping("/deleteArt")
	public String deleteArtAll (@ModelAttribute("form") ArtForm artform, Model model) {

		User_info user = (User_info) session.getAttribute("User");
		//投稿した記事を一覧表示select
		List<Art> list = artS.selectMyAll(user.getUser_id());

		model.addAttribute("list", list);
		return "deleteArtAll";
	}

	//選択画面から編集画面へ
	@RequestMapping("/deleteArtConfirm")
	public String deleteArt (@ModelAttribute("form") ArtForm artform, @RequestParam("art_id") Integer art_id, Model model) {
		//選択した記事の情報を表示する
		Art art = artS.selectArt(art_id);
		session.setAttribute("delete", art);

		return "deleteArtConfirm";
	}

	//編集画面から完了画面へ
	@RequestMapping(value="/deleteArtResult", method = RequestMethod.POST)
	public String deleteArtResult (@ModelAttribute("form") ArtForm artform, Model model) {
		//記事を削除するdelete
		Art art = (Art)session.getAttribute("delete");

		artS.delete(art.getArt_id());

		return "deleteArtResult";
	}



	//記事画面へ
	@RequestMapping("/art")
	public String art (@ModelAttribute("form") ArtForm artform, @RequestParam("art_id") Integer art_id, Model model) {

		//art_idを元に記事情報検索
		Art art = artS.selectArt(art_id);

		//改行処理
		art.setContent(artS.replace(art.getContent()));

		//記事ページに情報渡す
		model.addAttribute("art", art);

		//コメント欄にart_id情報を渡す（hidden）
		artform.setArt_id(art_id);
		model.addAttribute("form", artform);

		//コメント表示
		model.addAttribute("comment", comS.CommentByArt(art_id));

		return "art";
	}


	//新着記事一覧表示
	@RequestMapping("/newAll")
	public String newAll (@ModelAttribute("form") ArtForm artform, Model model) {

		//新着順に記事を一覧表示

		return "newAll";
	}

}

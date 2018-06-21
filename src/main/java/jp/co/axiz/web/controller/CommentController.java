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

import jp.co.axiz.web.entity.Art;
import jp.co.axiz.web.entity.Com_User_info;
import jp.co.axiz.web.entity.User_info;
import jp.co.axiz.web.form.CommentForm;
import jp.co.axiz.web.service.impl.ArtServiceImpl;
import jp.co.axiz.web.service.impl.CommentService;

@Controller
public class CommentController {

	@Autowired
	HttpSession session;

	@Autowired
	ArtServiceImpl artS;

	@Autowired
	CommentService comS;

	//コメントの投稿
	@RequestMapping(value="/postComment", method = RequestMethod.POST)
	public String postComment (@ModelAttribute("form") CommentForm comForm, Model model) {

		//記事id、ユーザー情報、コメント内容
		User_info user = (User_info)session.getAttribute("User");
		//コメント投稿処理
		comS.insert(comForm.getComment(), user.getUser_id(), comForm.getArt_id());

		//記事に戻る（コメント投稿した記事を表示させる）

		//art_idを元に記事情報検索
		Art art = artS.selectArt(comForm.getArt_id());
		//改行処理
		art.setContent(artS.replace(art.getContent()));
		//記事ページに情報渡す
		model.addAttribute("art", art);

		//コメント欄にart_id情報を渡す（hidden）*コメント内容削除
		List<Com_User_info> list = comS.CommentByArt(comForm.getArt_id());

		comForm.setComment("");
		model.addAttribute("form", comForm);

		//記事IDを元にコメントを渡す（list）
		model.addAttribute("comment", list);
		return "art";
	}

	//編集コメントの表示
	@RequestMapping(value="/editC", method = RequestMethod.POST)
	public String editC (@ModelAttribute("form") CommentForm comForm,
			@RequestParam(name = "comment_id", required = false) Integer comment_id,
			@RequestParam(name = "comment", required = false) String comment, Model model) {

		//記事id、コメントidをコメントフォームにセット
		comForm.setComment_id(comment_id);
		comForm.setComment(comment);
		return "commentEdit";
	}

	//コメントの編集
	@RequestMapping(value="/editComment", method = RequestMethod.POST)
	public String editComment (@Validated @ModelAttribute("form") CommentForm comForm,
			BindingResult bindingResult, Model model) {

		//空欄チェック
		if (bindingResult.hasErrors()) {
			return "postArt";
		}

		//コメント編集処理
		comS.update(comForm.getComment(), comForm.getComment_id());

		//記事に戻る（コメント投稿した記事を表示させる）

		//art_idを元に記事情報検索
		Art art = artS.selectArt(comForm.getArt_id());
		//改行処理
		art.setContent(artS.replace(art.getContent()));
		//記事ページに情報渡す
		model.addAttribute("art", art);

		//コメント欄にart_id情報を渡す（hidden）*コメント内容削除
		List<Com_User_info> list = comS.CommentByArt(comForm.getArt_id());

		comForm.setComment("");
		model.addAttribute("form", comForm);

		//記事IDを元にコメントを渡す（list）
		model.addAttribute("comment", list);

		return "art";
	}

	//削除コメントの表示
	@RequestMapping(value="/deleteC", method = RequestMethod.POST)
	public String deleteC (@ModelAttribute("form") CommentForm comForm,
			@RequestParam(name = "comment_id", required = false) Integer comment_id,
			@RequestParam(name = "comment", required = false) String comment,Model model) {


		comForm.setComment_id(comment_id);
		comForm.setComment(comment);

		//記事id、コメントidを元にコメント内容表示
		model.addAttribute("form", comForm);
		return "commentDelete";
	}

	//コメントの削除
	@RequestMapping(value="/deleteComment", method = RequestMethod.POST)
	public String deleteComment (@ModelAttribute("form") CommentForm comForm, Model model) {

		//コメント削除処理
		comS.delete(comForm.getComment_id());

		//記事に戻る（コメント投稿した記事を表示させる）

		//art_idを元に記事情報検索
		Art art = artS.selectArt(comForm.getArt_id());
		//改行処理
		art.setContent(artS.replace(art.getContent()));
		//記事ページに情報渡す
		model.addAttribute("art", art);

		//コメント欄にart_id情報を渡す（hidden）*コメント内容削除
		List<Com_User_info> list = comS.CommentByArt(comForm.getArt_id());

		comForm.setComment("");
		model.addAttribute("form", comForm);

		//記事IDを元にコメントを渡す（list）
		model.addAttribute("comment", list);

		return "art";
	}

}

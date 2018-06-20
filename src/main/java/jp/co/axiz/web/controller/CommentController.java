package jp.co.axiz.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.axiz.web.form.CommentForm;

@Controller
public class CommentController {

	//コメントの投稿
	@RequestMapping(value="/postComment", method = RequestMethod.POST)
	public String postComment (@ModelAttribute("form") CommentForm comForm, Model model) {

		//記事id、ユーザー情報、コメント内容
		//コメント投稿処理
		//記事に戻る（コメント投稿した記事を表示させる）

		return "art";
	}

	//編集コメントの表示
	@RequestMapping(value="/editC", method = RequestMethod.POST)
	public String editC (@ModelAttribute("form") CommentForm comForm, Model model) {

		//記事id、コメントidを元にコメント内容表示

		return "commentEdit";
	}

	//コメントの編集
	@RequestMapping(value="/editComment", method = RequestMethod.POST)
	public String editComment (@ModelAttribute("form") CommentForm comForm, Model model) {

		//コメント編集処理
		//記事に戻る（コメント投稿した記事を表示させる）

		return "art";
	}

	//削除コメントの表示
	@RequestMapping(value="/deleteC", method = RequestMethod.POST)
	public String deleteC (@ModelAttribute("form") CommentForm comForm, Model model) {

		//記事id、コメントidを元にコメント内容表示

		return "commentDelete";
	}

	//コメントの削除
	@RequestMapping(value="/deleteComment", method = RequestMethod.POST)
	public String deleteComment (@ModelAttribute("form") CommentForm comForm, Model model) {

		//記事id、コメントid
		//コメント削除処理
		//記事に戻る（コメント投稿した記事を表示させる）

		return "art";
	}

}

package jp.co.axiz.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jp.co.axiz.web.form.ArtForm;

@Controller
public class ArtController {

	//メニューから投稿画面へ
	@RequestMapping("/postArt")
	public String postArt (@ModelAttribute("form") ArtForm artform, Model model) {
		return "postArt";
	}

	//投稿画面から確認画面へ
	@RequestMapping(value="/postArtConfirm", method = RequestMethod.POST)
	public String postArtConfirm (@ModelAttribute("form") ArtForm artform, Model model) {

		//空欄チェック
		//値を持ち越し

		return "postArtConfirm";
	}

	@RequestMapping(value="/postArtResult", method = RequestMethod.POST)
	public String postArtResult (@ModelAttribute("form") ArtForm artform, Model model) {

		//記事投稿処理（DB）insert

		return "postArtResult";
	}



	//メニューから編集記事選択画面へ
	@RequestMapping("/editArt")
	public String editArtAll (@ModelAttribute("form") ArtForm artform, Model model) {
		//投稿した記事を一覧表示select
		return "editArtAll";
	}

	//選択画面から編集画面へ
	@RequestMapping("/editArtConfirm")
	public String editArt (@ModelAttribute("form") ArtForm artform, @RequestParam("art_id") Integer art_id, Model model) {

		//選択した記事の情報を表示するselect
		return "editArt";
	}

	//編集画面から完了画面へ
	@RequestMapping(value="/editArtResult", method = RequestMethod.POST)
	public String editArtResult (@ModelAttribute("form") ArtForm artform, Model model) {
		//記事を編集するupdate

		return "editArtResult";
	}


	//メニューから削除記事選択画面へ
	@RequestMapping("/deleteArt")
	public String deleteArtAll (@ModelAttribute("form") ArtForm artform, Model model) {
		//投稿した記事を一覧表示select
		return "deleteArtAll";
	}

	//選択画面から編集画面へ
	@RequestMapping("/deleteArtConfirm")
	public String deleteArt (@ModelAttribute("form") ArtForm artform, @RequestParam("art_id") Integer art_id, Model model) {

		//選択した記事の情報を表示するselect
		return "deleteArtConfirm";
	}

	//編集画面から完了画面へ
	@RequestMapping(value="/deleteArtResult", method = RequestMethod.POST)
	public String deleteArtResult (@ModelAttribute("form") ArtForm artform, Model model) {
		//記事を削除するdelete

		return "deleteArtResult";
	}



	//記事画面へ
	@RequestMapping("/art")
	public String art (@ModelAttribute("form") ArtForm artform, @RequestParam("art_id") Integer art_id, Model model) {

		return "art";
	}


	//新着記事一覧表示
	@RequestMapping("/newAll")
	public String newAll (@ModelAttribute("form") ArtForm artform, Model model) {

		//新着順に記事を一覧表示

		return "newAll";
	}

}

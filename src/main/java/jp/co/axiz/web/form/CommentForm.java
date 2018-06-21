package jp.co.axiz.web.form;

import javax.validation.constraints.NotBlank;

public class CommentForm {

	private Integer art_id;

	@NotBlank
	private String comment;

	private Integer comment_id;



	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Integer getArt_id() {
		return art_id;
	}

	public void setArt_id(Integer art_id) {
		this.art_id = art_id;
	}

	public Integer getComment_id() {
		return comment_id;
	}

	public void setComment_id(Integer comment_id) {
		this.comment_id = comment_id;
	}

	@Override
	public String toString() {
		return "CommentForm [art_id=" + art_id + ", comment=" + comment + ", comment_id=" + comment_id + "]";
	}

}

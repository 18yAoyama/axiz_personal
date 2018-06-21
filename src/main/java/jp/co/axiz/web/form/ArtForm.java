package jp.co.axiz.web.form;

import javax.validation.constraints.NotBlank;

public class ArtForm {

	private Integer art_id;

	@NotBlank
	private String title;

	@NotBlank
	private String content;

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getArt_id() {
		return art_id;
	}
	public void setArt_id(Integer art_id) {
		this.art_id = art_id;
	}
}

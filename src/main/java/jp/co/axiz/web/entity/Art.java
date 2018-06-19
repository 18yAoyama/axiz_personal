package jp.co.axiz.web.entity;

public class Art {

	//user_infoテーブルから取得した値を格納するだけ
	//カラム名と同じ名前
	private Integer art_id;
	private String title;
	private String content;
	private String user_id;

	public Integer getArt_id() {
		return art_id;
	}
	public void setArt_id(Integer art_id) {
		this.art_id = art_id;
	}
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
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
}

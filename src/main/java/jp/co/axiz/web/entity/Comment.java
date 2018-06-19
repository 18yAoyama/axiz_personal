package jp.co.axiz.web.entity;

public class Comment {
	//user_infoテーブルから取得した値を格納するだけ
	//カラム名と同じ名前
	private Integer comment_id;
	private String comment;
	private String user_id;
	private Integer art_id;

	public Integer getComment_id() {
		return comment_id;
	}
	public void setComment_id(Integer comment_id) {
		this.comment_id = comment_id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public Integer getArt_id() {
		return art_id;
	}
	public void setArt_id(Integer art_id) {
		this.art_id = art_id;
	}
}

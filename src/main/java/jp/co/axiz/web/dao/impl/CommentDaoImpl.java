package jp.co.axiz.web.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CommentDaoImpl{

	@Autowired
    private JdbcTemplate jT;

	public void insert(String comment, String user_id, Integer art_id) {
		jT.update("INSERT INTO com (comment, user_id, art_id) VALUES (?, ?, ?)", comment, user_id, art_id);

	}

	public void update(String comment, Integer comment_id) {
		jT.update("UPDATE com SET comment = ? WHERE comment_id = ?", comment, comment_id);
	}

	public void delete(Integer comment_id) {
		jT.update("DELETE FROM com WHERE comment_id = ?", comment_id);
	}

}

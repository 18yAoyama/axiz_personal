package jp.co.axiz.web.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jp.co.axiz.web.entity.Art;

@Repository
public class ArtDaoImpl{

	@Autowired
    private JdbcTemplate jT;

	@Transactional
	public void insert(String title, String content, String user_id) {
		jT.update("INSERT INTO art (title, content, user_id) VALUES (?, ?, ?)", title , content, user_id);
	}

	@Transactional
	public void update(Integer art_id, String title, String content) {
		jT.update("UPDATE art SET title = ?, content = ? WHERE art_id = ?", title, content, art_id);

	}

	@Transactional
	public void delete(Integer art_id) {
		jT.update("DELETE FROM art WHERE art_id = ?", art_id);
	}

	@Transactional
	public List<Art> selectMyAll(String user_id) {
		return jT.query("SELECT art_id, title, content, user_id FROM art WHERE user_id = ? ORDER BY art_id DESC", new BeanPropertyRowMapper<Art>(Art.class), user_id);
	}

	@Transactional
	public List<Art> selectNewAll() {
		return jT.query("SELECT art_id, title, content, user_id FROM art ORDER BY art_id DESC", new BeanPropertyRowMapper<Art>(Art.class));
	}

	@Transactional
	public List<Art> selectArt(Integer art_id) {
		return jT.query("SELECT art_id, title, content, user_id FROM art WHERE art_id = ?", new BeanPropertyRowMapper<Art>(Art.class), art_id);
	}

	@Transactional
	public Integer lastId() {
		return jT.queryForObject("SELECT MAX(art_id) FROM art", Integer.class);
	}

}

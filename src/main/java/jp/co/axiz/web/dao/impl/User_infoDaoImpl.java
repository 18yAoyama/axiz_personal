package jp.co.axiz.web.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.axiz.web.dao.Dao;
import jp.co.axiz.web.entity.User_info;

@Repository
public class User_infoDaoImpl implements Dao {
	//SQL文
	private static final String SQL_SELECT_ID_AND_PASS = "SELECT user_id, user_name, company, nickname, password FROM user_info WHERE user_id = ? AND password = ?";

	@Autowired
    private JdbcTemplate jdbcTemplate;

	public User_info findbyIdPass(String id, String pass) {
		//IDとPASSを基にuser_infoテーブルに該当するレコードを返す

		List<User_info> list = jdbcTemplate.query(SQL_SELECT_ID_AND_PASS, new BeanPropertyRowMapper<User_info>(User_info.class), id, pass);

		if (list.size() == 0) {
			return null;
		}

		return list.get(0);
	}

	@Override
	public void insert() {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void update() {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void delete() {
		// TODO 自動生成されたメソッド・スタブ

	}

	public void updateNick(String user_id, String nickname) {
		jdbcTemplate.update("UPDATE user_info SET nickname = ? WHERE user_id = ?", nickname, user_id);
	}

}

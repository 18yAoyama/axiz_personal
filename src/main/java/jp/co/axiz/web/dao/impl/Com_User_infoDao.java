package jp.co.axiz.web.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.axiz.web.entity.Com_User_info;

@Repository
public class Com_User_infoDao {

	@Autowired
    private JdbcTemplate jT;

	public List<Com_User_info> CommentByArt(Integer art_id){

		return jT.query("SELECT comment, com.user_id, art_id, comment_id, nickname FROM com JOIN user_info ON com.user_id=user_info.user_id WHERE art_id = ? ORDER BY comment_id", new BeanPropertyRowMapper<Com_User_info>(Com_User_info.class), art_id);

	}

}

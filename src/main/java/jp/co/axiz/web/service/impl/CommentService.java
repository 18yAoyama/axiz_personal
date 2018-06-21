package jp.co.axiz.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.axiz.web.dao.impl.Com_User_infoDao;
import jp.co.axiz.web.dao.impl.CommentDaoImpl;
import jp.co.axiz.web.entity.Com_User_info;

@Service
public class CommentService {

	@Autowired
	CommentDaoImpl comDao;

	@Autowired
	Com_User_infoDao cuDao;

	public void insert(String comment, String user_id, Integer art_id) {
		comDao.insert(comment, user_id, art_id);
	}

	public void update(String comment, Integer comment_id) {
		comDao.update(comment, comment_id);
	}

	public void delete(Integer comment_id) {
		comDao.delete(comment_id);
	}

	public List<Com_User_info> CommentByArt(Integer art_id){
		return cuDao.CommentByArt(art_id);
	}

}

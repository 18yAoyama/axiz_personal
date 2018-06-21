package jp.co.axiz.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.axiz.web.dao.impl.ArtDaoImpl;
import jp.co.axiz.web.entity.Art;
import jp.co.axiz.web.form.ArtForm;

@Service
public class ArtServiceImpl {

	@Autowired
	ArtDaoImpl artDao;

	public void insert(String title, String content, String user_id) {
		artDao.insert(title, content, user_id);
	}

	public void update(Integer art_id, String title, String content) {
		artDao.update(art_id, title, content);
	}

	public void delete(Integer art_id) {
		artDao.delete(art_id);
	}

	public List<Art> selectMyAll(String user_id) {
		return artDao.selectMyAll(user_id);
	}

	public List<Art> selectNewAll(){
		return artDao.selectNewAll();
	}

	public Art selectArt(Integer art_id) {
		List<Art> list = artDao.selectArt(art_id);
		if(list.size() == 0) {
			return null;
		}
		return list.get(0);
	}

	public Integer lastId() {
		return artDao.lastId();
	}

	public String replace(String content) {
		return content.replaceAll("\n","<BR>");
	}

	public String replaceR(String content) {
		return content.replaceAll("<BR>", "");
	}

	public boolean change(Art before, ArtForm after) {
		if(before.getTitle().equals(after.getTitle()) && before.getContent().equals(after.getContent())) {
			return false;
		} else {
			return true;
		}
	}


}

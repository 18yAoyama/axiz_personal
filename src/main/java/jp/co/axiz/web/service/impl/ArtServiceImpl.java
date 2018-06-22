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
		List<Art> list = artDao.selectMyAll(user_id);

		for (Art art : list) {
			String pare;
			String expr = art.getContent();
			int codeStart = expr.lastIndexOf("<");
			int codeClose = expr.indexOf(">", codeStart) + 1;

			while (codeStart != -1) {

				pare = expr.substring(codeStart, codeClose);
				expr = expr.replace(pare, "");

				codeStart = expr.lastIndexOf("<");
				codeClose = expr.indexOf(">", codeStart) + 1;

			}
			if(expr.length() > 50) {
				expr = expr.substring(0,50);
			}
			art.setContent(expr);

		}

		return list;
	}

	public List<Art> selectNewAll(){
		List<Art> list = artDao.selectNewAll();

		for (Art art : list) {
			String pare;
			String expr = art.getContent();
			int codeStart = expr.lastIndexOf("<");
			int codeClose = expr.indexOf(">", codeStart) + 1;

			while (codeStart != -1) {

				pare = expr.substring(codeStart, codeClose);
				expr = expr.replace(pare, "");

				codeStart = expr.lastIndexOf("<");
				codeClose = expr.indexOf(">", codeStart) + 1;

			}
			if(expr.length() > 50) {
				expr = expr.substring(0,50);
			}
			art.setContent(expr);

		}


		return list;
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
		String raw = content;

		//preタグのみ例外
		int last = content.length()-1;

		int codeStart = content.lastIndexOf("<pre");
		int codeClose = content.indexOf("</pre>", codeStart) + 5;

		while (codeStart != -1 && codeClose != 5) {
			if(codeClose != last) {
				String moto = content.substring(codeClose, last);
				String newC = moto.replaceAll("\n","<BR>");
				content = content.replace(moto, newC);

			}

			raw = content.substring(0, codeStart);
			last = codeStart;

			codeStart = raw.lastIndexOf("<pre");
			codeClose = raw.indexOf("</pre>", codeStart) + 5;
		}

		if (raw.length() != 0) {
			String newC = raw.replaceAll("\n","<BR>");
			content = content.replace(raw, newC);
		}

		return content;
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

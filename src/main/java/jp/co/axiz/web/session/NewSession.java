package jp.co.axiz.web.session;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jp.co.axiz.web.entity.Art;

@Component
@Scope("session")
public class NewSession implements Serializable {

	    private static final long serialVersionUID = 1L;

	    private Art art;

		public Art getArt() {
	        if (art == null) {
	            art = new Art();
	        }

			return art;
		}

		public void setArt(Art art) {
			this.art = art;
		}



		public void invalid() {
			art = null;
		}
}

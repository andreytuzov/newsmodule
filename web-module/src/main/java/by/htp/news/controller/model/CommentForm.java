package by.htp.news.controller.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CommentForm {

	@NotNull
	@Size(min = 10, max = 300)
	private String text;

	private int articleId;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getArticleId() {
		return articleId;
	}

	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}

}

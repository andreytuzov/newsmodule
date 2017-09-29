package by.htp.news.controller.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Модель для взаимодействия с формой
 *
 */
public class ArticleForm {
	private int id;

	@NotNull
	@Size(max = 100)
	private String title;

	@NotNull
	@Size(max = 500)
	private String brief;
	
	@NotNull
	@Size(max = 2048)
	private String content;
	
	@NotNull
	@Pattern(regexp = "^(0[1-9]|1[012])/(0[1-9]|[12][0-9]|3[01])/(19|20)\\d\\d$")
	private String date;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", brief=" + brief + ", content=" + content + ", date=" + date
				+ "]";
	}

}

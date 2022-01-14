package org.ex.domain;

public class Board3DTO {
	// 글쓰기 제목
	private String title;
	// 굴쓰기 내용
	private String content;
	// 글쓴이
	private String writer;
	// 날짜
	private String redate;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getRedate() {
		return redate;
	}
	public void setRedate(String redate) {
		this.redate = redate;
	}
	@Override
	public String toString() {
		return "Board3DTO [title=" + title + ", content=" + content + ", writer=" + writer + ", redate=" + redate + "]";
	}
	
	
}

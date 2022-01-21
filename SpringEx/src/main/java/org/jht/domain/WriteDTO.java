package org.jht.domain;

public class WriteDTO {
	// 제목
	private String title;
	// 내용
	private String content;
	// 번호
	private int bno;
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
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	@Override
	public String toString() {
		return "WriteDTO [title=" + title + ", content=" + content + ", bno=" + bno + "]";
	}
	
	
	
}

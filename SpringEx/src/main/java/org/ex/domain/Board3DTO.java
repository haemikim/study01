package org.ex.domain;

public class Board3DTO {
	// 글 번호
	private int bno;
	// 글쓰기 제목
	private String title;
	// 굴쓰기 내용
	private String content;
	// 글쓴이
	private String writer;
	// 날짜
	private String redate;
	// 조회수
	private int count;
	
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
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
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "Board3DTO [bno=" + bno + ", title=" + title + ", content=" + content + ", writer=" + writer
				+ ", redate=" + redate + ", count=" + count + "]";
	}
	
	
	
}

package org.jht.domain;

import java.util.ArrayList;
// db에 에있는 정보를 캡슐화해서 보관(private과 같은 데이터 접근자 /getter,setter를 통해 데이터 접근 )
public class BoardDTO {
	private int bno;
	private String title;
	private String content;
	private String writer;
	private String regdate;
	private int cnt;
	private int good;
	
	private ArrayList<AttachFileDTO> attachList; // 하나의 게시물에 여러 파일을 띄우게 할수 있도록 배열로 만든다

	public ArrayList<AttachFileDTO> getAttachList() {
		return attachList;
	}
	
	public void setAttachList(ArrayList<AttachFileDTO> attachList) {
		this.attachList = attachList;
	}
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
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public int getGood() {
		return good;
	}
	public void setGood(int good) {
		this.good = good;
	}
	
	@Override
	public String toString() {
		return "BoardDTO [bno=" + bno + ", title=" + title + ", content=" + content + ", writer=" + writer
				+ ", regdate=" + regdate + ", cnt=" + cnt + ", good=" + good + ", attachList=" + attachList + "]";
	}

	
}

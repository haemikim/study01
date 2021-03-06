package org.jht.domain;

import org.jht.domain.Criteria;

public class Criteria {
	// 페이지 번호
	private int pageNum;
	// 한 페이지당 게시물갯수
	private int amount;
	// 검색종류
	private String search;
	// 검색 키워드
	private String keyword;
	
	// 기본생성자(기본값이 각 10개씩 묶어서 첫번째 페이지 나오게 하기)
	Criteria(){
		this(1,10); //한페이지에 10개 (this가 밑에 int를 뜻함)
	}// 정해진 숫자에 따라 다르게 나오게 하기
	Criteria(int pageNum, int amount){ // 위의 기본생성자에 정해놓은 번위를 pageNum, amount으로 적용시킨것(위의 기본생성자가 없을 시, pageNum, amount 범위를 작성해야한다)
		this.pageNum=pageNum;
		this.amount=amount;
	}
	
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}	
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	@Override
	public String toString() {
		return "Criteria [pageNum=" + pageNum + ", amount=" + amount + ", search=" + search + ", keyword=" + keyword
				+ "]";
	}
	
	
}

package org.jht.domain;

public class pageDTO {
	// 시작페이지번호
	private int startPage;
	// 끝페이지 번호
	private int endPage;
	// 이전  페이지 번호
	private boolean prev;
	// 다음 페이지 번호
	private boolean next;
	// board테이블의 총 데이터 건수(어디까지 나오게 해야하는지 알아야하니깐)
	private int total;
	// endPage를 계산하기 위한 pageNum가 필요하므로 Criteria클래스를 포함
	private Criteria cri;
	
	
	pageDTO(Criteria cri){
		this.cri=cri;
		this.total=total;
		// (int)(Math.ceil(현재 페이지 번호/10.0))*10
		this.endPage=(int)(Math.ceil(cri.getPageNum()/10))*10;
	}
	

	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public Criteria getCri() {
		return cri;
	}
	public void setCri(Criteria cri) {
		this.cri = cri;
	}
	
	@Override
	public String toString() {
		return "pageDTO [startPage=" + startPage + ", endPage=" + endPage + ", prev=" + prev + ", next=" + next
				+ ", total=" + total + ", cri=" + cri + "]";
	}
}

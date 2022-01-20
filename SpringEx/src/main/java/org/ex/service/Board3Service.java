package org.ex.service;

import org.ex.domain.Board3DTO;
import org.ex.domain.Criteria;

public interface Board3Service {
	// 게시판 글쓰기 
	public void write(Board3DTO dto); // 제어자는 public을 사용해야지 controller에 전달할수있다
	// 게시판 목록리스트 
	public void list(Criteria cri);
	// 게시판 페이징수 데이터
	// 게시판 삭제
	// 게시판 수정
	// 게시판 제목누르면 들어가기
	
}

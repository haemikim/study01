package org.jht.mapper;

import java.util.ArrayList;

import org.jht.domain.BoardDTO;

public interface BoardMapper {
	//게시판 글쓰기와 관련이 되어 있는 DB작업에 설계
	public void write(BoardDTO board);
	//게시판 목록리스트와 관련이 되어 있는 DB작업에 설계
	public ArrayList<BoardDTO> list();
	// 게시판 목록리스트에서 제목을 클릭했을 때 내용이 나오는 상세페이지와 관련 되어 있는 DB작업 설계
	public BoardDTO detail(BoardDTO board);
	//게시판 글수정과 관련이 되어 있는 DB작업에 설계
	public void modify(BoardDTO board);
	//게시판 글삭제과 관련이 되어 있는 DB작업에 설계
	public void remove(BoardDTO board);
}

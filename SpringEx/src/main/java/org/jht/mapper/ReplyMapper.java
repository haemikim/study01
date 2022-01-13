package org.jht.mapper;

import java.util.ArrayList;
import org.jht.domain.ReplyDTO;

public interface ReplyMapper {
	// 댓글쓰기 설계
	// insert 성공시 ReplyMapper.xml로 부터1
	// insert 성공시 ReplyMapper.xml로 부터0
	// 값을 리턴받는다
	public int write(ReplyDTO rdto);
	public ArrayList<ReplyDTO> list(int bno); 
	// 댓글 수정을 하기위해 댓글내용가져오기
	public ReplyDTO detail(int rno);
}

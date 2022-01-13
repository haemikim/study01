package org.jht.service;

import java.util.ArrayList;
import org.jht.domain.ReplyDTO;
import org.jht.mapper.ReplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplyServiceIml  implements ReplyService{
	@Autowired
	private ReplyMapper rmapper;
	// 게시판 글쓰기 설계된것을 구현
		public int write(ReplyDTO rdto) {
			// insert 성공시 ReplyMapper.xml로 부터1
			// insert 성공시 ReplyMapper.xml로 부터0
			// 값을 리턴받는다
			return rmapper.write(rdto);
		}
	// 댓글 목록리스트 설계
		public ArrayList<ReplyDTO> list(int bno) {
			return rmapper.list(bno);
		}
	// 댓글 수정을 하기위해 댓글내용가져오기
		public ReplyDTO detail(int rno) {
			return rmapper.detail(rno);
		}
}

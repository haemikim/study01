package org.jht.service;


import org.jht.domain.ReplyDTO;
import org.jht.mapper.ReplyMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class ReplyServiceIml  implements ReplyService{
	@Autowired
	private ReplyMapper rmapper;
	// 게시판 글쓰기 설계된것을 구현
		public void write(ReplyDTO rdto) {
			rmapper.write(rdto);
		}
}

package org.jht.service;

import org.jht.domain.ReplyDTO;
import org.jht.mapper.ReplyMapper;
import org.springframework.beans.factory.annotation.Autowired;

public interface ReplyService {
	// 댓글 쓰기 설계
		public void write(ReplyDTO rdto);
	
}

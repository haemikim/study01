package org.ex.service;

import org.ex.domain.Board3DTO;
import org.ex.domain.Criteria;
import org.jht.mapper.Board3Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class Board3ServiceImpl implements Board3Service{

	@Autowired
	private Board3Mapper b3mapper; // mapper랑 연결
	
	// 게시판 글쓰기
	public void write(Board3DTO dto) {
		b3mapper.write(dto); // mapper의 dto값을 넣은 write를 구현	
	}
	// 게시판 목록 리스트
//	public ArrayList
//	}

	@Override
	public void list(Criteria cri) {
		// TODO Auto-generated method stub
		
	}

}

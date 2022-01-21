package org.jht.service;

import java.util.ArrayList;

import org.jht.domain.Criteria;
import org.jht.domain.WriteDTO;
import org.jht.domain.AttachFileDTO;
import org.jht.domain.BoardDTO;
import org.jht.mapper.AttachMapper;
import org.jht.mapper.BoardMapper;
import org.jht.mapper.WriteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardMapper bmapper;
	@Autowired
	private AttachMapper amapper;
	@Autowired
	private WriteMapper wmapper;
	
	// 게시판 글쓰기 설계된것을 구현
	@Transactional
	public void write(BoardDTO board) {
		// 제목과 내용을 board태이블에 insert
		bmapper.insertSelectKey(board);
//		
//		board.getAttachList().forEach(main->{
//			main.setBno();
//		    wmapper.content(main)
//		});
//			

		
		// 파일명, 파일 경로, 파일 타입, uuid값을 attach테이블에 insert
		//BoardList에 있는 AttachList()를 가져와서 반복문으로 실행하여 attach변수에 저장 
		// (AttachList가 배열이라 반복문을 사용하여 전체를 들고올 수 있게 해준다)
		board.getAttachList().forEach(attach->{
			// BoardDTO의 bno값을 가져와서(board.getBno()) AttachFileDTO에 bno를 저장(attach.setBno())
			attach.setBno(board.getBno());
			amapper.insert(attach); 
			// 그냥 board를 할경우엔 amapper이 AttachFileDTO를
			// 들고오는 걸로되어있어 타입이 맞지않아  위와 같이 board에 연결된 
			// AttachList를 들고와서 사용한다
		}); 
		
	}
	// 게시판 목록리스트 설계된것을 구현
	public ArrayList<BoardDTO> list(Criteria cri) {
		return bmapper.list(cri);
	}
	// 게시판 목록리스트에서 제목을 클릭했을 때 내용이 나오는 상세페이지 설계된것을 구현
	@Transactional
	public BoardDTO detail(BoardDTO board) {
		// board테이블에 조회수 속성에 +
		bmapper.cntupdate(board);
		//     상세페이지 select
		return bmapper.detail(board);
	}
	// 게시판 글수정 설계된것을 구현
	public void modify(BoardDTO board) {
		bmapper.modify(board);
	}
	// 게시판 글삭제 설계된것을 구현
	public void remove(BoardDTO board) {
		bmapper.remove(board);
	}
	// 게시판 페이징에 쓰일 데이터 건수
	public int getTotalCount(Criteria cri) {
		return bmapper.getTotalCount(cri);
	}
	// 게시판 상세페이지에 파일 업로드된 이미지 출력
	public ArrayList<AttachFileDTO> fileList(int bno){
		return amapper.fileList(bno);
	}
}

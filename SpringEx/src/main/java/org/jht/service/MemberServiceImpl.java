package org.jht.service;

import org.jht.domain.MemberDTO;
import org.jht.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberMapper mmapper;
	// 회원가입하기 설계된것을 구현
	public void insert(MemberDTO mdto) {
		mmapper.insert(mdto); // 사용자가 insert에 작성한거 들고오기
	}
	// 로그인 설계된것을 구현
	public MemberDTO login(MemberDTO mdto) {
		return mmapper.login(mdto);
	}
}

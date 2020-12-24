package com.min.edu.model;


import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.min.edu.dto.MemberDTO;


@Repository
public class MemberDaoImpl implements MemberIDao {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	PasswordEncoder pwEncoder;

	@Override
	public MemberDTO login(Map<String, Object> map) {
		logger.info("MemberDaoImpl Login");
		MemberDTO dto = null;
		String enPw = pwEncoder.encode((String) map.get("pw"));
		String dbPw = sqlSession.selectOne("member.selStringPw", map.get("id"));
		
		if (pwEncoder.matches((String) map.get("pw"), dbPw)) {
			dto = sqlSession.selectOne("member.enLogin", map);
		}
		
		return dto;
	}
//		return sqlSession.selectOne("member.loginMember", map);

	@Override
	public boolean signup(MemberDTO dto) {
		logger.info("MemberDaoImpl signup");
		String enPw= pwEncoder.encode(dto.getPw());
		dto.setPw(enPw);
		int cnt = sqlSession.insert("member.signUpMember", dto);
		return (cnt>0)?true:false;
	}

	@Override
	public boolean idDuplicateCheck(String id) {
		int cnt = sqlSession.selectOne("member.idDuplicateCheck", id);
		return (cnt>0)?true:false;
	}
	

}

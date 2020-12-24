package com.min.edu.model;


import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.edu.dto.MemberDTO;


@Service
public class MemberServiceImpl implements MemberIService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private MemberIDao iDao;
	@Override
	public MemberDTO login(Map<String, Object> map) {
		logger.info("로그인 login  : ", map);
		return iDao.login(map);
	}
	@Override
	public boolean signup(MemberDTO dto) {
		logger.info("회원가입 signup : ",dto);
		return iDao.signup(dto);
	}
	@Override
	public boolean idDuplicateCheck(String id) {
		logger.info("아이디 중복체크 idDuplicateCheck : ", id);
		return iDao.idDuplicateCheck(id);
	}
	

}

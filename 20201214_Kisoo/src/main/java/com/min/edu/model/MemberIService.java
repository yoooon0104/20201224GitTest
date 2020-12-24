package com.min.edu.model;

import java.util.Map;

import com.min.edu.dto.MemberDTO;

public interface MemberIService {
	
	public MemberDTO login(Map<String, Object> map);
	public boolean signup(MemberDTO dto);
	public boolean idDuplicateCheck(String id);
	

}

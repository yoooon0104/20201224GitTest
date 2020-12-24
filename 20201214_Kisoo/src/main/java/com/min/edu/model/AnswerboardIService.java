package com.min.edu.model;

import java.util.List;
import java.util.Map;

import com.min.edu.dto.AnswerboardDTO;

public interface AnswerboardIService {

	// 글목록
	public List<AnswerboardDTO> boardList();

	// seq있으면 seq로 dto 가져오고, 없으면 전체 가져오기
	public List<AnswerboardDTO> selectDynamic(Map<String, String> map);

	// 댓글달기 - insert+update
	public boolean reply(AnswerboardDTO dto);

	// 내용수정
	public boolean modifyBoard(Map<String, String> map);

	// 글입력
	public boolean insertBoard(AnswerboardDTO dto);

	// 글삭제
	public boolean multiDelete(String seq);

	// 글 다중삭제
	public boolean multiDelete2(Map<String, String[]> map);

}

package com.min.edu.model;

import java.util.List;
import java.util.Map;

import com.min.edu.dto.AnswerboardDTO;

public interface AnswerboardIDao {

	// 전체 글목록
	public List<AnswerboardDTO> boardList();

	// 셀렉트다이나믹
	public List<AnswerboardDTO> selectDynamic(Map<String, String> map);

	// 댓글달기 - insert
	public boolean replyInsert(AnswerboardDTO dto);

	// 댓글달기 - update
	public boolean replyUpdate(AnswerboardDTO dto);

	// 내용수정
	public boolean modifyBoard(Map<String, String> map);

	// 글입력
	public boolean insertBoard(AnswerboardDTO dto);

	// 글삭제
	public boolean multiDelete(String seq);

	// 글 다중삭제
	public boolean multiDelete2(Map<String, String[]> map);
}

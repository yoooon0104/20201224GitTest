package com.min.edu.model;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.edu.dto.AnswerboardDTO;

@Repository
public class AnswerboardDaoImpl implements AnswerboardIDao {

	@Autowired
	private SqlSessionTemplate session;

	@Override
	public List<AnswerboardDTO> boardList() {
		List<AnswerboardDTO> list = null;
		list = session.selectList("answerboard.boardList", list);
		return list;
	}

	@Override
	public List<AnswerboardDTO> selectDynamic(Map<String, String> map) {
		return session.selectList("answerboard.selectDynamic", map);
	}

	@Override
	public boolean replyInsert(AnswerboardDTO dto) {
		return session.insert("answerboard.replyInsert", dto) > 0 ? true : false;
	}

	@Override
	public boolean replyUpdate(AnswerboardDTO dto) {
		return session.update("answerboard.replyUpdate", dto) > 0 ? true : false;
	}

	@Override
	public boolean modifyBoard(Map<String, String> map) {
		return session.update("answerboard.modifyBoard", map) > 0 ? true : false;
	}

	@Override
	public boolean insertBoard(AnswerboardDTO dto) {
		return session.insert("answerboard.insertBoard", dto) > 0 ? true : false;
	}

	@Override
	public boolean multiDelete(String seq) {
		return session.update("answerboard.multiDelete", seq) > 0 ? true : false;
	}

	@Override
	public boolean multiDelete2(Map<String, String[]> map) {
		return session.update("answerboard.multiDelete2", map) > 0 ? true : false;
	}

}

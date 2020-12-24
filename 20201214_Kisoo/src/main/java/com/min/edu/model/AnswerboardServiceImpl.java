package com.min.edu.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.min.edu.dto.AnswerboardDTO;

@Service
public class AnswerboardServiceImpl implements AnswerboardIService {

	@Autowired
	private AnswerboardIDao iDao;

	@Override
	public List<AnswerboardDTO> boardList() {
		return iDao.boardList();
	}

	@Override
	public List<AnswerboardDTO> selectDynamic(Map<String, String> map) {
		return iDao.selectDynamic(map);
	}

	@Transactional
	@Override
	public boolean reply(AnswerboardDTO dto) {
		boolean isc1 = iDao.replyUpdate(dto);
		boolean isc2 = iDao.replyInsert(dto);
		return (isc1 || isc2) ? true : false;
	}

	@Transactional
	@Override
	public boolean modifyBoard(Map<String, String> map) {
		return iDao.modifyBoard(map);
	}

	@Transactional
	@Override
	public boolean insertBoard(AnswerboardDTO dto) {
		return iDao.insertBoard(dto);
	}

	@Override
	public boolean multiDelete(String seq) {
		return iDao.multiDelete(seq);
	}

	@Override
	public boolean multiDelete2(Map<String, String[]> map) {
		return iDao.multiDelete2(map);
	}

}

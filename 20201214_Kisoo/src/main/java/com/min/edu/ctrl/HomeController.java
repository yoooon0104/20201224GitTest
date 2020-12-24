package com.min.edu.ctrl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.min.edu.dto.AnswerboardDTO;
import com.min.edu.model.AnswerboardIService;

@Controller
public class HomeController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private AnswerboardIService iService;

	// 테스트용
	@RequestMapping(value = "/home.do", method = RequestMethod.POST)
	public String test() {
		System.out.println("HomeController home.do");
		return "test";
	}

	/////////////////////////////////////////// 화면 이동
	@RequestMapping(value = "/goInsert.do", method = RequestMethod.GET)
	public String goInsert() {
		logger.info("HomeController goInsert.do");
		return "insertPage";
	}

	//////////////////// 수정하기
	@RequestMapping(value = "/goUpdateBoard.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String goUpdateBoard(AnswerboardDTO dto, Model model) {
		logger.info("HomeController goUpdateBoard.do");
		model.addAttribute("dto", dto);
		return "update";
	}

	// 답글달기
	@RequestMapping(value = "/goReply.do", method = RequestMethod.GET)
	public String goReply(String seq, Model model) {
		logger.info("HomeController goReply.do");
		model.addAttribute("seq",seq);
		return "reply";
	}
	// 글 목록

	@RequestMapping(value = "/boardList.do", method = RequestMethod.GET)
	public String boardList(Model model) {
		logger.info("HomeController boardList.do");
		List<AnswerboardDTO> list = iService.boardList();
		model.addAttribute("list", list);
		return "boardList";

	}

	@RequestMapping(value = "/insertBoard.do", method = RequestMethod.POST)
	public String insertBoard(AnswerboardDTO dto) {
		boolean isc = iService.insertBoard(dto);
		logger.info("입력 된 dto : " + dto);
		return "redirect:/selectOne.do";
	}

	@RequestMapping(value = "/selectOne.do")
	public String selectOne(Model model, String seq) {
		Map<String, String> map = new HashMap<String, String>();
		logger.info("HomeController selectOne.do");
		map.put("seq", seq);
		List<AnswerboardDTO> list = iService.selectDynamic(map);
		model.addAttribute("dto", list);
		logger.info(list.toString());
		return "detail";
	}

	@RequestMapping(value = "/reply.do", method = RequestMethod.POST)
	public String reply(AnswerboardDTO dto) {
		logger.info("HomeController reply.do");
		boolean isc = iService.reply(dto);
		return isc ? "redirect:/boardList.do":"selectOne.do?seq="+dto.getSeq();
	}

	@RequestMapping(value = "/modifyBoard.do")
	public String modifyBoard(String content, String seq) {
		Map<String, String> map = new HashMap<String, String>();
		logger.info("HomeController modifyBoard.do");
		map.put("content", content);
		map.put("seq", seq);
		System.out.println(iService.modifyBoard(map));
		return "redirect:/selectOne.do?seq=" + seq;
	}

	@RequestMapping(value = "/multiDelete.do")
	public String multiDelete(String seq) {
		logger.info("HomeController multiDelete.do 삭제 할 " + seq);
		System.out.println(iService.multiDelete(seq));
		return "redirect:/boardList.do";
	}

	@RequestMapping(value = "/multiDelete2.do", method = RequestMethod.POST)
	public String multiDelete2(String[] chk) {
		logger.info("multiDelete2.do 삭제할 seqs는: " + chk);
		Map<String, String[]> map = new HashMap<String, String[]>();
		map.put("seqs", chk);
		boolean isc = iService.multiDelete2(map);
//		System.out.println(isc);
		return "redirect:/boardList.do";

	}

}

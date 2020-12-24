package com.min.edu.ctrl;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.min.edu.dto.MemberDTO;
import com.min.edu.model.MemberIService;



@Controller
public class MemberController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private MemberIService iService;
	
	@RequestMapping(value = "/loginForm.do", method = RequestMethod.GET)
	String loginForm() {
		logger.info("MemberController loginForm.do");
		return "loginForm";
		
	}
	
	@RequestMapping(value = "/signUpForm.do", method = RequestMethod.GET)
	public String signUpform() {
		logger.info("MemberController signUpForm.do");
		return "signUpForm";
	}
	   
	   @RequestMapping(value="/login.do",method=RequestMethod.POST)
	   public String login(@RequestParam Map<String,Object> map,HttpSession session) {
		   System.out.println(map.toString());
	      MemberDTO dto = iService.login(map);
	      logger.info("MemberController signUpForm.do : " +dto);
	      session.setAttribute("mem", dto);
	      return (dto != null) ? "redirect:/boardList.do" : "redirect:/signUpForm.do";
	   }
	   
	   @RequestMapping(value="/logout.do",method=RequestMethod.GET)
	   public String logout(HttpSession session) {
	      MemberDTO mDto = (MemberDTO)session.getAttribute("mem");
	      if(mDto != null) {
	         session.removeAttribute("mem");
	      }
	      return "redirect:/loginForm.do";
	   }
	   
	   @RequestMapping(value = "/signUp.do", method = RequestMethod.POST)
	   public String signUp(MemberDTO dto, @RequestParam("pw") String pw) {
		  dto.setPw(pw);
		  logger.info("welcome signUp.do : \t {}", dto);
		  boolean isc = iService.signup(dto);
		  logger.info("signUp.do : ", isc);  
		   return isc ? "redirect:/loginForm.do" : "redirect:/signUpForm.do";
	   }
	   
	   @RequestMapping(value = "/idCheck.do", method = RequestMethod.POST)
	   @ResponseBody
	   public String idCheck(String id){
		System.out.println(id);
		   String isc = "";
		   boolean isc2 = iService.idDuplicateCheck(id);
		   isc = isc2+"";
		   return isc;
	   }
	   
}

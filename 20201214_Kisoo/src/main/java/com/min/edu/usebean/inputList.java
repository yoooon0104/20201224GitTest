package com.min.edu.usebean;

import java.util.List;

import com.min.edu.dto.AnswerboardDTO;

public class inputList {

	private List<AnswerboardDTO> lists;
	
	public void setLists(List<AnswerboardDTO> lists) {
		this.lists = lists;
	}

	// 리스트 가져오기
	public String getListForm() {
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<lists.size();i++) {
			sb.append(listForm(lists.get(i)));
		}
		return sb.toString();
	}
	
	private String titleFormat(String Fomat) {
//		System.out.println(Fomat);
		StringBuffer sb = new StringBuffer();
		int depth = Integer.valueOf(Fomat);
//		int depth =0;
//		try {
//			depth = Integer.valueOf(Fomat);
//		} catch (NumberFormatException e) {
//			e.printStackTrace();
//		}
//		System.out.println(depth);
		for(int i = 0; i < depth; i++) {
			sb.append("&nbsp;&nbsp;&nbsp;&nbsp;");
		}
		if(depth != 0) {
			sb.append("▶");
		}
		return sb.toString();
	}

	//리스트 출력 폼
	public String listForm(AnswerboardDTO dto) {
		StringBuffer sb = new StringBuffer();

		int n = 5;
		sb.append("   <tr>                                                                               ");
		sb.append("   <td><input type='checkbox' name='chk' value='"+dto.getSeq()+"'></td>");
		sb.append("   <td>"+dto.getSeq()+"</td> ");
		sb.append("   <td>"+dto.getId()+"</td> ");
		sb.append("   <td>                                                                               ");
		sb.append("         <a href='./selectOne.do?seq="+dto.getSeq()+"'>"+titleFormat(dto.getDepth())+dto.getTitle()+"</a> ");
		sb.append("   </td>");
		sb.append("   <td>"+dto.getRegdate()+"</td>                                     ");
		sb.append("   <td>"+dto.getDelflag()+"</td>                                     ");
		sb.append("</tr>                                                       ");
		return sb.toString();
	}



}


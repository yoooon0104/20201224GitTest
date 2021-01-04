package com.min.edu.usebean;

public class PtBean {
	
	private int depth;

	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	public String getPic() {
		String result="";
		String blank="&nbsp;&nbsp;&nbsp;&nbsp;";
		String replyImg = "./img/reply.png";
		for (int i = 0; i < depth; i++) {
			result += blank;
		}
		
		return depth>0?result+replyImg : result;
	}

}

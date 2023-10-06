package com.kh.okkh.member.model.vo;

public class Member {
	
	private String memToken;
	private String memId;
	private String memPwd;
	
	public Member() {}
	
	

	public Member(String memToken, String memId, String memPwd) {
		super();
		this.memToken = memToken;
		this.memId = memId;
		this.memPwd = memPwd;
	}



	public String getMemToken() {
		return memToken;
	}

	public void setMemToken(String memToken) {
		this.memToken = memToken;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getMemPwd() {
		return memPwd;
	}

	public void setMemPwd(String memPwd) {
		this.memPwd = memPwd;
	}

	@Override
	public String toString() {
		return "Member [memToken=" + memToken + ", memId=" + memId + ", memPwd=" + memPwd + "]";
	}
	
	

}

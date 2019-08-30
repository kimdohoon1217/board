package kr.or.ddit.board.model;

import java.util.Date;

public class Board {
	private int boardNo;
	private String boardNm;
	private String useStatus;
	private String userId;
	private Date reg_dt;
	
	public Board(int boardNo, String boardNm, String useStatus, String userId, Date reg_dt) {
		this.boardNo = boardNo;
		this.boardNm = boardNm;
		this.useStatus = useStatus;
		this.userId = userId;
		this.reg_dt = reg_dt;
	}
	public Board() {
		
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getBoardNm() {
		return boardNm;
	}
	public void setBoardNm(String boardNm) {
		this.boardNm = boardNm;
	}
	public String getUseStatus() {
		return useStatus;
	}
	public void setUseStatus(String useStatus) {
		this.useStatus = useStatus;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getReg_dt() {
		return reg_dt;
	}
	public void setReg_dt(Date reg_dt) {
		this.reg_dt = reg_dt;
	}
	
	
	
	

}

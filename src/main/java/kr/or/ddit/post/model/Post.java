package kr.or.ddit.post.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Post {
	private int bullNo;
	private int boardNo;
	private String bullTitle;
	private String bullCont;
	private String userId;
	private Date reg_dt;
	private String delStatus;
	private int parentNo;
	private int gn;
	
	public int getGn() {
		return gn;
	}
	public void setGn(int gn) {
		this.gn = gn;
	}
	private int level;


	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
	public Post() {
		
	}
	public Post(int bullNo, int boardNo, String bullTitle, String bullCont, String userId, Date reg_dt,
			String delStatus, int parentNo) {
		super();
		this.bullNo = bullNo;
		this.boardNo = boardNo;
		this.bullTitle = bullTitle;
		this.bullCont = bullCont;
		this.userId = userId;
		this.reg_dt = reg_dt;
		this.delStatus = delStatus;
		this.parentNo = parentNo;
	}
	public int getBullNo() {
		return bullNo;
	}
	
	public String getReg_dt_fmt() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(reg_dt);
	}
	
	public void setBullNo(int bullNo) {
		this.bullNo = bullNo;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getBullTitle() {
		return bullTitle;
	}
	public void setBullTitle(String bullTitle) {
		this.bullTitle = bullTitle;
	}
	public String getBullCont() {
		return bullCont;
	}
	public void setBullCont(String bullCont) {
		this.bullCont = bullCont;
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
	public String getDelStatus() {
		return delStatus;
	}
	public void setDelStatus(String delStatus) {
		this.delStatus = delStatus;
	}
	public int getParentNo() {
		return parentNo;
	}
	public void setParentNo(int parentNo) {
		this.parentNo = parentNo;
	}
	
	
	
	
	

}

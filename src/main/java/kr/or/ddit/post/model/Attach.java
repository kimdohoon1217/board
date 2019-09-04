package kr.or.ddit.post.model;

public class Attach {
	private int filNo;
	private String filePath;
	private String uploadFile;
	private int bullNo;
	
	
	
	public Attach() {
		super();
	}
	public Attach(int filNo, String filePath, String uploadFile, int bullNo) {
		super();
		this.filNo = filNo;
		this.filePath = filePath;
		this.uploadFile = uploadFile;
		this.bullNo = bullNo;
	}
	public int getFilNo() {
		return filNo;
	}
	public void setFilNo(int filNo) {
		this.filNo = filNo;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(String uploadFile) {
		this.uploadFile = uploadFile;
	}
	public int getBullNo() {
		return bullNo;
	}
	public void setBullNo(int bullNo) {
		this.bullNo = bullNo;
	}
	
	
	

}

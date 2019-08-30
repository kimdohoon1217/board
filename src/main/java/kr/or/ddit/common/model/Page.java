package kr.or.ddit.common.model;

public class Page {
	private int page;
	private int pagesize;
	private int boardSeq;
	
	public int getBoardSeq() {
		return boardSeq;
	}
	public void setBoardSeq(int boardSeq) {
		this.boardSeq = boardSeq;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public Page(int page, int pagesize, int boardSeq) {
		super();
		this.page = page;
		this.pagesize = pagesize;
		this.boardSeq = boardSeq;
	}
	public Page() {
		super();
	}
	

}

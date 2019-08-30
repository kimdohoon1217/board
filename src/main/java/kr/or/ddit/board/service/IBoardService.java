package kr.or.ddit.board.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.model.Board;

public interface IBoardService {
	/**
	 * Method : selectAll
	 * 작성자 : PC-18
	 * 변경이력 :
	 * @param sqlSession
	 * @return
	 * Method 설명 : 전체 게시판 출력
	 */
	List<Board> selectAll();
	
	/**
	 * Method : boardInsert
	 * 작성자 : PC-18
	 * 변경이력 :
	 * @param sqlSession
	 * @param vo
	 * @return
	 * Method 설명 : 게시판 생성
	 */
	int insertBoard(Board vo);
	
	/**
	 * Method : getBoard
	 * 작성자 : PC-18
	 * 변경이력 :
	 * @param sqlSession
	 * @param seq
	 * @return
	 * Method 설명 : seq로 해당게시판 가져오기
	 */
	Board getBoard(int seq);
	
	int modifyBoard(Board board);

}

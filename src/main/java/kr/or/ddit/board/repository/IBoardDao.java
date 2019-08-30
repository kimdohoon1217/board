package kr.or.ddit.board.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.model.Board;

public interface IBoardDao {
	/**
	 * Method : selectAll
	 * 작성자 : PC-18
	 * 변경이력 :
	 * @param sqlSession
	 * @return
	 * Method 설명 : 전체 게시판 출력
	 */
	List<Board> selectAll(SqlSession sqlSession);
	
	/**
	 * Method : boardInsert
	 * 작성자 : PC-18
	 * 변경이력 :
	 * @param sqlSession
	 * @param vo
	 * @return
	 * Method 설명 : 게시판 생성
	 */
	int insertBoard(SqlSession sqlSession, Board vo);
	
	/**
	 * Method : getBoard
	 * 작성자 : PC-18
	 * 변경이력 :
	 * @param sqlSession
	 * @param seq
	 * @return
	 * Method 설명 : seq로 해당게시판 가져오기
	 */
	Board getBoard(SqlSession sqlSession, int seq);
	
	/**
	 * Method : modifyBoard
	 * 작성자 : PC-18
	 * 변경이력 :
	 * @param sqlSession
	 * @param seq
	 * @return
	 * Method 설명 : board로 해당게시판 수정
	 */
	int modifyBoard(SqlSession sqlSession, Board board);
	

	
	
}

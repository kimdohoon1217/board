package kr.or.ddit.board.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.model.Board;

public class BoardDao implements IBoardDao{

	@Override
	public List<Board> selectAll(SqlSession sqlSession) {
		return sqlSession.selectList("board.selectAll");
	}

	@Override
	public int insertBoard(SqlSession sqlSession, Board vo) {
		return sqlSession.insert("board.insertBoard", vo);
	}

	@Override
	public Board getBoard(SqlSession sqlSession, int seq) {
		return sqlSession.selectOne("board.getBoard", seq);
	}

	@Override
	public int modifyBoard(SqlSession sqlSession, Board board) {
		return sqlSession.update("board.modifyBoard", board);
	}

}

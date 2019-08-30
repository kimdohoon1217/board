package kr.or.ddit.board.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.model.Board;
import kr.or.ddit.board.repository.BoardDao;
import kr.or.ddit.board.repository.IBoardDao;
import kr.or.ddit.util.MybatisUtil;

public class BoardService implements IBoardService {

	private IBoardDao boardDao;
	
	public BoardService() {
		boardDao = new BoardDao();
	}
	
	@Override
	public List<Board> selectAll() {
		SqlSession sqlSession = MybatisUtil.getSession();
		List<Board> list = boardDao.selectAll(sqlSession);
		sqlSession.close();
		return list;
	}

	@Override
	public int insertBoard(Board vo) {
		SqlSession sqlSession = MybatisUtil.getSession();
		int res = boardDao.insertBoard(sqlSession, vo);
		sqlSession.commit();
		sqlSession.close();
		return res;
	}

	@Override
	public Board getBoard(int seq) {
		SqlSession sqlSession = MybatisUtil.getSession();
		Board board = boardDao.getBoard(sqlSession, seq);
		sqlSession.close();
		return board;
	}

	@Override
	public int modifyBoard(Board board) {
		SqlSession sqlSession = MybatisUtil.getSession();
		int res = boardDao.modifyBoard(sqlSession, board);
		sqlSession.commit();
		sqlSession.close();
		return res;
	}

}

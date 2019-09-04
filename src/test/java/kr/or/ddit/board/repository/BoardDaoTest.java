package kr.or.ddit.board.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.model.Board;
import kr.or.ddit.user.repository.UserDao;
import kr.or.ddit.user.repository.UserDaoTest;
import kr.or.ddit.util.MybatisUtil;

public class BoardDaoTest {
	private static final Logger logger = LoggerFactory.getLogger(UserDaoTest.class);
	
	private IBoardDao boardDao;
	private SqlSession sqlSession;
	
	@Before
	public void setup() {
		logger.debug("before");
		boardDao = new BoardDao();
		sqlSession = MybatisUtil.getSession();
		
	}
	
	@After
	public void tearDown() {
		logger.debug("after");
		sqlSession.close();
	}
	
	@Test
	public void boardSelectAll() {
		/***Given***/
		
		/***When***/
		List<Board> list = boardDao.selectAll(sqlSession);
		/***Then***/
		assertEquals(3, list.size());
	}
	
	@Test
	public void insertBoardTest() {
		/***Given***/
		Board board = new Board();
		board.setBoardNm("연습연습용");
		board.setUserId("cony");
		board.setUseStatus("사용");
		
		/***When***/
		int res = boardDao.insertBoard(sqlSession, board);

		/***Then***/
		assertEquals(1, res);
	}
	
	
	@Test
	public void getBoardTest() {
		/***Given***/
		int seq = 53;
		
		/***When***/
		Board board = boardDao.getBoard(sqlSession, seq);

		/***Then***/
		assertEquals("cony", board.getUserId());
	}
	
	@Test
	public void ModifyBoardTest() {
		/***Given***/
		Board board = new Board();
		board.setBoardNm("수정연습");
		board.setUseStatus("미사용");
		board.setBoardNo(53);
		
		
		/***When***/
		int reboard = boardDao.modifyBoard(sqlSession, board);
		sqlSession.commit();

		/***Then***/
		assertEquals(1, reboard);
	}
	
	


}

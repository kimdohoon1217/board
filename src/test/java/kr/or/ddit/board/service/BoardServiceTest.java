package kr.or.ddit.board.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.model.Board;
import kr.or.ddit.user.service.UserServiceTest;
import kr.or.ddit.util.MybatisUtil;

public class BoardServiceTest {

	private static final Logger logger = LoggerFactory.getLogger(UserServiceTest.class);
	
	private IBoardService boardService;
	private SqlSession sqlSession;
	private int cnt;
	@Before
	public void setup() {
		logger.debug("before");
		boardService = new BoardService();
		sqlSession = MybatisUtil.getSession();
		
	}
	
	@After
	public void tearDown() {
		logger.debug("after");
		sqlSession.close();
	}
	
	
	
	@Test
	public void boardList() {
		//한개의메서드만 실행하고싶으면 클래스위에서 ctrl + F11을 한다
		/***Given***/
		
		/***When***/
		List<Board> list = boardService.selectAll();
		
		/***Then***/
		assertEquals(4, list.size());
		
	}
	
	@Test
	public void inserBoard() {
		/***Given***/
		Board board = new Board();
		board.setBoardNm("연습연습용");
		board.setUserId("cony");
		board.setUseStatus("사용");
		
		/***When***/
		int res = boardService.insertBoard(board);
		if(res>0) {
			cnt++;
		}
		

		/***Then***/
		assertEquals(1, res);
	}
	
	@Test
	public void getBoardTest() {
		/***Given***/
		int seq = 53;
		
		/***When***/
		Board board = boardService.getBoard(seq);

		/***Then***/
		assertEquals("cony", board.getUserId());
	}
	
	
	@Test
	public void ModifyBoardTest() {
		/***Given***/
		Board board = new Board();
		board.setBoardNm("수정연습");
		board.setUseStatus("미사용");
		board.setBoardNo(1);
		
		
		/***When***/
		int reboard = boardService.modifyBoard(board);
		sqlSession.commit();

		/***Then***/
		assertEquals(1, reboard);
	}

}

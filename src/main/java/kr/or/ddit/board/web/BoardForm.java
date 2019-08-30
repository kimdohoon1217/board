package kr.or.ddit.board.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.model.Board;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.IBoardService;


@WebServlet("/boardForm")
public class BoardForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	private static final Logger logger = LoggerFactory.getLogger(BoardCreate.class);
	
	private IBoardService boardService;
	
	@Override
	public void init() throws ServletException {
		boardService = new BoardService();
	}
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String optionVal = request.getParameter("opt");
		String userId = request.getParameter("userId");
		logger.debug("optionVal : {}", optionVal);
		logger.debug("userId - {}", userId);
		
		Board vo = new Board();
		vo.setBoardNm(name);
		
		//option value값을 가져온다
		vo.setUseStatus(optionVal);
		
		//session, cookie값을 가져온다
		vo.setUserId(userId);
		boardService.insertBoard(vo);
		
		
		request.getRequestDispatcher("/boardCreate").forward(request, response);
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("nameVal");
		logger.debug("name - {}", name);
		
		String use = request.getParameter("opVal");
		logger.debug("use - {}", use);
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		logger.debug("idx - {}", idx);
		
		
		Board vo = new Board();
		vo.setBoardNm(name);
		vo.setUseStatus(use);
		vo.setBoardNo(idx);
		
		int res = boardService.modifyBoard(vo);
		request.setAttribute("res", res);
		request.getRequestDispatcher("/boardCreate").forward(request, response);
		
		
	}

}

package kr.or.ddit.post.web;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.post.model.Post;
import kr.or.ddit.post.service.IPostService;
import kr.or.ddit.post.service.PostService;
import kr.or.ddit.user.model.User;


@WebServlet("/freeBoard")
public class FreeBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(FreeBoard.class);
	
	private IPostService postService;
	
	@Override
	public void init() throws ServletException {
		postService = new PostService();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//board.seq 를 받아서 해당 board를 구별해내서 리스트를 뽑고 paginingnation해야한다
		// page , pagesize 파라미터 받기
		String pageStr = request.getParameter("page");
		String pagesizeStr = request.getParameter("pagesize");
		int boardNo = Integer.parseInt(request.getParameter("boardSeq"));
		
		int page = pageStr == null ? 1 : Integer.parseInt(pageStr);
		int pagesize = pagesizeStr == null ? 10 : Integer.parseInt(pagesizeStr);
		
		
		Page p = new Page(page, pagesize, boardNo);
		request.setAttribute("pageVo", p);
		
		
		
		// userService객체를  이용하여 getUserPagingList를 호출
		// 반환된 사용자 리스트를 request객체에 setAttribute로 저장
		Map<String, Object> resultMap = postService.getPostPagingList(p);
		List<Post> postList = (List<Post>)resultMap.get("postList");
		int paginationSize = (Integer)resultMap.get("paginationSize");
		request.setAttribute("postList", postList);
		logger.debug("postList - {}", postList.size());
		request.setAttribute("paginationSize", paginationSize);
		logger.debug("paginationSize - {}", paginationSize);
		
//		List<Post> levelList = postService.getPostLevel();
//		request.setAttribute("level", levelList);
		request.setAttribute("boardSeq", boardNo);
		
		
		//조회된 사용자 리스트 정보를 html로 만들어줄 jsp로 요청을 위임 시킨다.
		//webapp/user/userPagingList.jsp(userList.jsp 복사)
		request.getRequestDispatcher("/board/freeBoard.jsp").forward(request, response);
	
	}


}

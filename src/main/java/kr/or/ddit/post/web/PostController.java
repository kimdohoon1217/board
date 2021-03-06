package kr.or.ddit.post.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.post.model.Attach;
import kr.or.ddit.post.model.Post;
import kr.or.ddit.post.service.IPostService;
import kr.or.ddit.post.service.PostService;

/**
 * Servlet implementation class PostController
 */
@WebServlet("/post")
public class PostController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static final Logger logger = LoggerFactory.getLogger(PostController.class);
  
	private IPostService postService;
	
	@Override
	public void init() throws ServletException {
		postService = new PostService();
	}
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int postNo = Integer.parseInt(request.getParameter("postNo"));
		logger.debug("postNo - {}", postNo);
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		logger.debug("boardNo - {}", boardNo);
		
		Post post  = new Post();
		post.setBullNo(postNo);
		post.setBoardNo(boardNo);
		

		List<Attach> fileList = postService.getFile(postNo);
		Post vo = postService.getPost(post);
		
		List<Map> map = postService.selectCom(postNo);
		
		
		
		logger.debug("vo - {} {} {}", vo.getBullNo(), vo.getBullTitle(), vo.getUserId());
		request.setAttribute("vo", vo);
		request.setAttribute("fileList", fileList);
		request.setAttribute("com", map);
		logger.debug("fileList - {}", fileList.size());
		request.getRequestDispatcher("/board/detailPost.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

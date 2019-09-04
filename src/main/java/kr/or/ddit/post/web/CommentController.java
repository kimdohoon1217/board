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
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.post.service.IPostService;
import kr.or.ddit.post.service.PostService;
import kr.or.ddit.user.model.User;


@WebServlet("/comment")
public class CommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(CommentController.class);
	
	
       
	private IPostService postService;
	
	@Override
	public void init() throws ServletException {
		postService = new PostService();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("S_USERVO");
		
		String cont = request.getParameter("cont");
		logger.debug("comcont - {}", cont);
		
		int res = Integer.parseInt(request.getParameter("postNo"));
		int seq = Integer.parseInt(request.getParameter("boardNo"));
		
		Map map = new HashMap();
		map.put("replyCont", cont);
		map.put("bullNo", res);
		map.put("userId", user.getUserId());
		map.put("delStatus", "X");
		
		postService.insertCom(map);
		
		List<Map> com = postService.selectCom(res);
		logger.debug("com.comsize - {}", com.size());
		logger.debug("com.comsize - {}", com.get(0).get("REPLYCONT"));
		request.setAttribute("com", com);
		request.getRequestDispatcher("/post").forward(request, response);
		//response.sendRedirect(request.getContextPath() + "/post?boardNo=" + seq + "&postNo=" + res);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package kr.or.ddit.servlet;

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

import kr.or.ddit.user.model.User;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.UserService;


@WebServlet( urlPatterns = {"/login"}, loadOnStartup = 5)
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	
	private IUserService userService;	//IUserService
	
	@Override
	public void init() throws ServletException {
		//싱글톤 대체 init은 한번만 실행되기때문에
		userService = new UserService();
	}


	/**
	 * Method : doGet
	 * 작성자 : PC-18
	 * 변경이력 :
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * Method 설명 : 로그인 화면 요청 처리(forward)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/login/login.jsp").forward(request, response);
	}

	
	/**
	 * Method : doPost
	 * 작성자 : PC-18
	 * 변경이력 :
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * Method 설명 : 로그인 요청 처리
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("login controller doPost()");

		//userId, password 파라미터 logger 출력
		String userId = request.getParameter("userId");
		String pass = request.getParameter("pass");
		
		
		manageUserIdCookie(response, userId);

		logger.debug("userId : {}", userId);
		logger.debug("password : {}", pass);
		
		//사용자가 입력한 계정정보와 db에있는 값이랑 비교
		
		//db에서 조회해온 사용자 정보 (가정)
		User user = userService.getUser(userId);
		
		
		//사용자가 입력한 파라미터 정보와 db에서 조회해온 값이 동일 할 경우 --> webapp/main.jsp
		//사용자가 입력한 파라미터 정보와 db에서 조회해온 값이 다를 경우 --> webapp/login/login.jsp
		
		//db에 존재하지 않는 사용자 체크 --> 로그인 화면으로 이동
		if(user == null)
			doGet(request, response);
		
		
		else if(user.checkLoginValidate(userId, pass)) {
			
			HttpSession session = request.getSession();
			logger.debug("session.getId() : {}", session.getId());
			
			session.setAttribute("S_USERVO", user);
			session.setAttribute("elTest", "elTestValue");
			
			request.getRequestDispatcher("/main.jsp").forward(request, response);
			
		}else {
			//forword의 경우 request, reponse객체를 공유
			//request method도 같이 공유
			//doPost()
//			request.getRequestDispatcher("/login/login.jsp").forward(request, response);
//			request.setAttribute("userId", userId);
			
			doGet(request, response);
		}
		
	}


	private void manageUserIdCookie(HttpServletResponse response, String userId) {
		Cookie cookie =new Cookie("userId", userId);
		if(userId != null) {
			//날짜도 메서드 파라미터로 변경하는게좋다(유동성)
			cookie.setMaxAge(60*60*24*30); //30일
		}
		else {
			cookie.setMaxAge(0);
		}
		
		response.addCookie(cookie);
	}

}

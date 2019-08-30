package kr.or.ddit.user.service;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.user.model.User;
import kr.or.ddit.user.repository.IUserDao;
import kr.or.ddit.util.MybatisUtil;

public class UserServiceTest {

	private static final Logger logger = LoggerFactory.getLogger(UserServiceTest.class);
	
	private IUserService userService;
	private SqlSession sqlSession;
	
	@Before
	public void setup() {
		logger.debug("before");
		userService = new UserService();
		sqlSession = MybatisUtil.getSession();
		
	}
	
	@After
	public void tearDown() {
		logger.debug("after");
		sqlSession.close();
	}
	
	@Test
	public void getUserTest() {
		//한개의메서드만 실행하고싶으면 클래스위에서 ctrl + F11을 한다
		/***Given***/
		String userId = "brown";
		
		/***When***/
		User userVo = userService.getUser(userId);
		sqlSession.close();

		/***Then***/
		assertEquals("브라운", userVo.getUserNm());
		
	}
}

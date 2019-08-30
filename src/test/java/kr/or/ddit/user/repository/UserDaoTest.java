package kr.or.ddit.user.repository;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.user.model.User;
import kr.or.ddit.util.MybatisUtil;

public class UserDaoTest {
	private static final Logger logger = LoggerFactory.getLogger(UserDaoTest.class);
	
	private IUserDao userDao; 
	private SqlSession sqlSession;
	
	
	@Before
	public void setup() {
		logger.debug("before");
		userDao = new UserDao();
		sqlSession = MybatisUtil.getSession();
		
	}
	
	@After
	public void tearDown() {
		logger.debug("after");
		sqlSession.close();
	}
	
	
	
	/**
	 * Method : getUserTest
	 * 작성자 : PC-18
	 * 변경이력 :
	 * Method 설명 : 사용자 정보 조회 테스트
	 */
	@Test
	public void getUserTest() {
		//한개의메서드만 실행하고싶으면 클래스위에서 ctrl + F11을 한다
		/***Given***/
		String userId = "brown";
		
		/***When***/
		User userVo = userDao.getUser(sqlSession, userId);
		sqlSession.close();

		/***Then***/
		assertEquals("브라운", userVo.getUserNm());
		//assertEquals("brown1234", userVo.getPass());
		
		
		
	}
	
	

}

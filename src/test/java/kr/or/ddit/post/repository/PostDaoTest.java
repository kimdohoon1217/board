package kr.or.ddit.post.repository;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.post.model.Post;
import kr.or.ddit.user.repository.UserDaoTest;
import kr.or.ddit.util.MybatisUtil;

public class PostDaoTest {
private static final Logger logger = LoggerFactory.getLogger(UserDaoTest.class);
	
	private IPostDao postDao; 
	private SqlSession sqlSession;
	private String userId = "cony";
	
	@Before
	public void setup() {
		logger.debug("before");
		postDao = new PostDao();
		sqlSession = MybatisUtil.getSession();
		
	}
	
	//테스트에 공톡적으로 사용한 자원을 해제
	@After
	public void tearDown() {
		logger.debug("after");
		sqlSession.close();
	}

	/**
	 * Method : getUserListTest
	 * 작성자 : PC-18
	 * 변경이력 :
	 * Method 설명 : getUserList 테스트
	 */
	@Test
	public void getPostList() {
		/***Given***/
		
		/***When***/
		List<Post> list = postDao.selectAll(sqlSession);
		
		/***Then***/
		assertEquals(11, list.size());
		
	}
	
	
	
	/**
	 * Method : getUserTest
	 * 작성자 : PC-18
	 * 변경이력 :
	 * Method 설명 : 사용자 정보 조회 테스트
	 */
	@Test
	public void getPostTest() {
		//한개의메서드만 실행하고싶으면 클래스위에서 ctrl + F11을 한다
		/***Given***/
		Post post = new Post();
		post.setBoardNo(53);
		post.setBullNo(4);
		
		/***When***/
		Post post1 = postDao.getPost(sqlSession, post);
		sqlSession.close();

		/***Then***/
		assertEquals("cony", post1.getUserId());
		
		
	}
	
	/**
	 * Method : getUserPagingList
	 * 작성자 : PC-18
	 * 변경이력 :
	 * Method 설명 : 사용자 페이징 리스트 조회 테스트
	 */
	@Test
	public void getPostPagingList() {
		/***Given***/
		Page page = new Page();
		page.setPage(1);
		page.setPagesize(10);
		page.setBoardSeq(53);

		/***When***/
		List<Post> pageList = postDao.getPostPagingList(sqlSession, page);
		

		/***Then***/
		assertEquals(10, pageList.size());
		assertEquals("cony", pageList.get(0).getUserId());
		
	}
	
	/**
	 * Method : getUserTotalCnt
	 * 작성자 : PC-18
	 * 변경이력 :
	 * Method 설명 : 전체 사용자 건수 조회
	 */
	@Test
	public void getPostTotalCnt() {
		
		/***Given***/
		

		/***When***/
		int totalCnt = postDao.getPostTotalCnt(sqlSession);

		/***Then***/
		assertEquals(11, totalCnt);
		
	}
	
//	/**
//	 * Method : insertUserTest
//	 * 작성자 : PC-18
//	 * 변경이력 :
//	 * Method 설명 : 사용자 등록 테스트
//	 * @throws ParseException 
//	 */
//	@Test
//	public void insertUserTest() throws ParseException {
//		//P_SEQ.nextval, #{boardNo}, #{bullTitle, jdbcType=VARCHAR}, #{bullCont, jdbcType=VARCHAR}, #{userId}, sysdate, #{delStatus}, #{parentNo, jdbcType=VARCHAR}
//		/***Given***/
//		Post post = new Post();
//		post.setBoardNo(53);
//		post.setBullTitle("연습dsa");
//		post.setBullCont("연습습dsa");
//		post.setUserId(userId);
//		post.setDelStatus("X");
//		//insert parentNo 고쳐야함
//		
//		
//		
//		/***When***/
//		int insertCnt = postDao.insertPost(sqlSession, post);
//		sqlSession.commit();
//		
//		/***Then***/
//		assertEquals(1, insertCnt);
//		
//		
//	}
	
	//수정해야함

	

}

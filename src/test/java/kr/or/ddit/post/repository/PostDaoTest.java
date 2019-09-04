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
import kr.or.ddit.post.model.Attach;
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
		assertEquals(67, list.size());
		
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
		post.setBoardNo(73);
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
		int seq = 53;

		/***When***/
		int totalCnt = postDao.getPostTotalCnt(sqlSession, seq);

		/***Then***/
		assertEquals(34, totalCnt);
		
	}
	
	/**
	 * Method : getPostLevel
	 * 작성자 : PC-18
	 * 변경이력 :
	 * Method 설명 : level 사이즈
	 */
	@Test
	public void getPostLevel() {
		
		/***Given***/
		
		/***When***/
		List<Post> list = postDao.getPostLevel(sqlSession);
		/***Then***/
		assertEquals(10, list.size());
		
	}
	
	
	/**
	 * Method : insertUserTest
	 * 작성자 : PC-18
	 * 변경이력 :
	 * Method 설명 : 사용자 등록 테스트
	 * @throws ParseException 
	 */
	@Test
	public void insertPostTest() {
		//insert into BULLETIN 
		//values(P_SEQ.nextval, #{boardNo}, 
		//#{bullTitle, jdbcType=VARCHAR}, #{bullCont, jdbcType=VARCHAR}, #{userId}, sysdate, #{delStatus}, #{parentNo, jdbcType=VARCHAR}, #{gn, jdbcType=VARCHAR})
		/***Given***/
		Post post = new Post();
		post.setBoardNo(53);
		post.setBullTitle("연습dsadasdasdasdadsa");
		post.setBullCont("dsadasdadadadasd");
		post.setUserId(userId);
		post.setDelStatus("X");
		
		
		/***When***/
		int insertCnt = postDao.insertPost(sqlSession, post);
		sqlSession.commit();
		
		/***Then***/
		assertEquals(1, insertCnt);
		
	}
	
	@Test
	public void insertFileTest() {
		//insert into BULLETIN 
		//values(P_SEQ.nextval, #{boardNo}, 
		//#{bullTitle, jdbcType=VARCHAR}, #{bullCont, jdbcType=VARCHAR}, #{userId}, sysdate, #{delStatus}, #{parentNo, jdbcType=VARCHAR}, #{gn, jdbcType=VARCHAR})
		/***Given***/
		Attach attach = new Attach();
		attach.setUploadFile("brown.jpg");
		attach.setFilePath("sadasdqwdsadwqd");
		attach.setBullNo(4);
		
		/***When***/
		int insertCnt = postDao.insertFile(sqlSession, attach);
		sqlSession.commit();
		
		/***Then***/
		assertEquals(1, insertCnt);
		
	}
	
	
	@Test
	public void getFileTest() {
		/***Given***/
		int seq = 4;
		/***When***/
		List<Attach> fileList = postDao.getFile(sqlSession, seq);
		/***Then***/
		assertEquals("brown.jpg", fileList.get(2).getUploadFile());
		
	}
	
	@Test
	public void updateDelTest() {
		
		/***Given***/
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bullNo", 55);
		map.put("delStatus", "Y");
		
		/***When***/
		int res = postDao.updateDel(sqlSession, map);
		sqlSession.commit();

		/***Then***/
		assertEquals(1, res);
		
	}
	
	@Test
	public void selectCom() {
		
		/***Given***/
		int seq = 85;
		/***When***/
		List<Map> list = postDao.selectCom(sqlSession, seq);

		/***Then***/
		assertEquals(6, list.size());
	}
	
	
	
	
	
	
	//수정해야함

	

}

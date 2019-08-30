package kr.or.ddit.post.service;

import static org.junit.Assert.assertEquals;

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
import kr.or.ddit.user.model.User;
import kr.or.ddit.util.MybatisUtil;

public class PostServiceTest {
	private static final Logger logger = LoggerFactory.getLogger(PostServiceTest.class);
	
	private IPostService postService; 
	private SqlSession sqlSession;
	private String userId = "cony";
	
	@Before
	public void setup() {
		logger.debug("before");
		postService = new PostService();
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
		List<Post> list = postService.selectAll();
		
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
		Post vo = new Post();
		vo.setBoardNo(53);
		vo.setBullNo(5);
		
		/***When***/
		Post post = postService.getPost(vo);
		sqlSession.close();

		/***Then***/
		assertEquals("cony", post.getUserId());
		
		
	}
	
	@Test
	public void getPostPagingList() {
		/***Given***/
		Page page = new Page();
		page.setPage(1);
		page.setPagesize(10);

		/***When***/
		Map<String, Object> resultMap = postService.getPostPagingList(page);
		List<Post> postList = (List<Post>)resultMap.get("postList");
		int paginationSize = (Integer)resultMap.get("paginationSize");

		/***Then***/
		assertEquals(10, postList.size());
		assertEquals("cony", postList.get(0).getUserId());
		assertEquals(2, paginationSize);
		
	}
	

	



}

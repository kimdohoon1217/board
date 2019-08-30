package kr.or.ddit.post.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.post.model.Post;

public interface IPostDao {
	List<Post> selectAll(SqlSession sqlSession);
	
	Post getPost(SqlSession sqlSession, Post post);
	
	List<Post> getPostPagingList(SqlSession sqlSession, Page page);
	
	int getPostTotalCnt(SqlSession sqlSession);
	
	List<Post> getPostLevel(SqlSession sqlSession);
	
	
	//int insertPost(SqlSession sqlSession, Post post);
	
	//int deletePost(SqlSession sqlSession, Map map);
	
	//int modifyPost(SqlSession sqlSession, Post post);
	
}

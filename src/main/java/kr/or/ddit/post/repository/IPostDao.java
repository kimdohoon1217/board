package kr.or.ddit.post.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.post.model.Attach;
import kr.or.ddit.post.model.Post;

public interface IPostDao {
	List<Post> selectAll(SqlSession sqlSession);
	
	Post getPost(SqlSession sqlSession, Post post);
	
	List<Attach> getFile (SqlSession sqlSession, int seq);
	
	List<Post> getPostPagingList(SqlSession sqlSession, Page page);
	
	int getPostTotalCnt(SqlSession sqlSession, int seq);
	
	List<Post> getPostLevel(SqlSession sqlSession);

	int insertPost(SqlSession sqlSession, Post post);
	
	int insertFile(SqlSession sqlSession, Attach attach);
	
	int updateDel(SqlSession sqlSession, Map map);
	
	int updatePost(SqlSession sqlSession, Post post);
	
	int updateFile(SqlSession sqlSession, Attach attach);
	
	int deleteFile(SqlSession sqlSession, int seq);
	
	int insertReply(SqlSession sqlSession, Post post);
	
	int insertCom(SqlSession sqlSession, Map map);
	
	List<Map> selectCom(SqlSession sqlSession, int seq);
	
	int updateCom(SqlSession sqlSession, Map map);
	
	Attach getFile2(SqlSession sqlSession, int seq);
	
	
	
}

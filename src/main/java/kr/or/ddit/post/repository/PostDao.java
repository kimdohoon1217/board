package kr.or.ddit.post.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.post.model.Post;

public class PostDao implements IPostDao {

	@Override
	public List<Post> selectAll(SqlSession sqlSession) {
		return sqlSession.selectList("post.selectAll");
	}

	@Override
	public Post getPost(SqlSession sqlSession, Post post) {
		
		return sqlSession.selectOne("post.getPost", post);
	}

	@Override
	public List<Post> getPostPagingList(SqlSession sqlSession, Page page) {
		return sqlSession.selectList("post.getPostPagingList", page);
	}

	@Override
	public int getPostTotalCnt(SqlSession sqlSession) {
		return sqlSession.selectOne("post.getPostTotalCnt");
	}

	@Override
	public List<Post> getPostLevel(SqlSession sqlSession) {
		
		return sqlSession.selectList("post.getPostLevel");
	}

//	@Override
//	public int insertPost(SqlSession sqlSession, Post post) {
//	
//		return sqlSession.insert("post.insertPost", post);
//	}
//
//	@Override
//	public int deletePost(SqlSession sqlSession, Map map) {
//
//		return sqlSession.delete("post.deletePost", map);
//	}
//
//	@Override
//	public int modifyPost(SqlSession sqlSession, Post post) {
//		return sqlSession.update("post.modifyPost", post);
//	}

}

package kr.or.ddit.post.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.post.model.Attach;
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
	public int getPostTotalCnt(SqlSession sqlSession, int seq) {
		return sqlSession.selectOne("post.getPostTotalCnt", seq);
	}

	@Override
	public List<Post> getPostLevel(SqlSession sqlSession) {
		
		return sqlSession.selectList("post.getPostLevel");
	}

	@Override
	public int insertPost(SqlSession sqlSession, Post post) {
	
		return sqlSession.insert("post.insertPost", post);
	}

	@Override
	public int insertFile(SqlSession sqlSession, Attach attach) {
		return sqlSession.insert("post.insertFile", attach);
	}

	@Override
	public List<Attach> getFile(SqlSession sqlSession, int seq) {
		return sqlSession.selectList("post.getFile", seq);
	}

	@Override
	public int updateDel(SqlSession sqlSession, Map map) {
		return sqlSession.update("post.updateDel", map);
	}

	@Override
	public int updatePost(SqlSession sqlSession, Post post) {
		return sqlSession.update("post.updatePost", post);
	}

	@Override
	public int updateFile(SqlSession sqlSession, Attach attach) {
		return sqlSession.update("post.updateFile", attach);
	}

	@Override
	public int deleteFile(SqlSession sqlSession, int seq) {
		return sqlSession.delete("post.deleteFile", seq);
	}

	@Override
	public int insertReply(SqlSession sqlSession, Post post) {
		return sqlSession.insert("post.insertReply", post);
	}

	@Override
	public int insertCom(SqlSession sqlSession, Map map) {
		return sqlSession.insert("post.insertCom", map);
	}

	@Override
	public List<Map> selectCom(SqlSession sqlSession, int seq) {
		return sqlSession.selectList("post.selectCom", seq);
	}

	@Override
	public int updateCom(SqlSession sqlSession, Map map) {
		
		return sqlSession.update("post.updateCom", map);
	}

	@Override
	public Attach getFile2(SqlSession sqlSession, int seq) {
		return sqlSession.selectOne("post.getFile2", seq);
	}
	
	
	
	



//
//	@Override
//	public int modifyPost(SqlSession sqlSession, Post post) {
//		return sqlSession.update("post.modifyPost", post);
//	}

}

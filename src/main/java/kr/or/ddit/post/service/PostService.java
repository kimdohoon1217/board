package kr.or.ddit.post.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.post.model.Attach;
import kr.or.ddit.post.model.Post;
import kr.or.ddit.post.repository.IPostDao;
import kr.or.ddit.post.repository.PostDao;
import kr.or.ddit.util.MybatisUtil;

public class PostService implements IPostService {

	private IPostDao postDao;
	
	public PostService() {
		postDao = new PostDao();
	}
	
	@Override
	public List<Post> selectAll() {
		SqlSession sqlSession = MybatisUtil.getSession();
		List<Post> list = postDao.selectAll(sqlSession);
		sqlSession.close();
		return list;
	}

	@Override
	public Post getPost(Post post) {
		SqlSession sqlSession = MybatisUtil.getSession();
		Post vo = postDao.getPost(sqlSession, post);
		sqlSession.close();
		return vo;
	}

	@Override
	public Map<String, Object> getPostPagingList(Page page) {
		SqlSession sqlSession = MybatisUtil.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<Post> postList = postDao.getPostPagingList(sqlSession, page);
		int totalCnt = postDao.getPostTotalCnt(sqlSession, page.getBoardSeq());
		
		map.put("postList", postList);
		map.put("paginationSize", (int)Math.ceil((double)totalCnt / page.getPagesize()));
		sqlSession.close();
		return map;
	}

	@Override
	public List<Post> getPostLevel() {
		SqlSession sqlSession = MybatisUtil.getSession();
		List<Post> list = postDao.getPostLevel(sqlSession);
		sqlSession.close();
		return list;
	}

	@Override
	public int insertPost(Post post) {
		SqlSession sqlSession = MybatisUtil.getSession();
		int res = postDao.insertPost(sqlSession, post);
		sqlSession.commit();
		sqlSession.close();
		return res;
	}

	@Override
	public int insertFile(Attach attach) {
		SqlSession sqlSession = MybatisUtil.getSession();
		int res = postDao.insertFile(sqlSession, attach);
		sqlSession.commit();
		sqlSession.close();
		return res;
	}

	@Override
	public List<Attach> getFile(int seq) {
		SqlSession sqlSession = MybatisUtil.getSession();
		List<Attach> list = postDao.getFile(sqlSession, seq);
		sqlSession.close();
		return list;
	}

	@Override
	public int updateDel(Map map) {
		SqlSession sqlSession = MybatisUtil.getSession();
		int res = postDao.updateDel(sqlSession, map);
		sqlSession.commit();
		sqlSession.close();
		return res;
	}

	@Override
	public int updatePost(Post post) {
		SqlSession sqlSession = MybatisUtil.getSession();
		int res = postDao.updatePost(sqlSession, post);
		sqlSession.commit();
		sqlSession.close();
		return res;
	}

	@Override
	public int updateFile(Attach attach) {
		SqlSession sqlSession = MybatisUtil.getSession();
		int res = postDao.updateFile(sqlSession, attach);
		sqlSession.commit();
		sqlSession.close();
		return res;
	}

	@Override
	public int deleteFile(int seq) {
		SqlSession sqlSession = MybatisUtil.getSession();
		int del = postDao.deleteFile(sqlSession, seq);
		sqlSession.commit();
		sqlSession.close();
		return del;
	}

	@Override
	public int insertReply(Post post) {
		SqlSession sqlSession = MybatisUtil.getSession();
		int res = postDao.insertReply(sqlSession, post);
		sqlSession.commit();
		sqlSession.close();
		return res;
	}

	@Override
	public int insertCom(Map map) {
		SqlSession sqlSession = MybatisUtil.getSession();
		int res = postDao.insertCom(sqlSession, map);
		sqlSession.commit();
		sqlSession.close();
		return res;
	}

	@Override
	public List<Map> selectCom(int seq) {
		SqlSession sqlSession = MybatisUtil.getSession();
		List<Map> map = postDao.selectCom(sqlSession, seq);
		sqlSession.close();
		return map;
	}

	@Override
	public int updateCom(Map map) {
		SqlSession sqlSession = MybatisUtil.getSession();
		int res = postDao.updateCom(sqlSession, map);
		sqlSession.commit();
		sqlSession.close();
		return res;
	}

	@Override
	public Attach getFile2(int seq) {
		SqlSession sqlSession = MybatisUtil.getSession();
		Attach vo = postDao.getFile2(sqlSession, seq);
		sqlSession.close();
		return vo;
	}


}

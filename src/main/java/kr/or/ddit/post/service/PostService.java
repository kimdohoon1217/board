package kr.or.ddit.post.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.common.model.Page;
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
		int totalCnt = postDao.getPostTotalCnt(sqlSession);
		
		map.put("postList", postList);
		map.put("paginationSize", (int)Math.ceil((double)totalCnt / page.getPagesize()));
		return map;
	}

	@Override
	public List<Post> getPostLevel() {
		SqlSession sqlSession = MybatisUtil.getSession();
		List<Post> list = postDao.getPostLevel(sqlSession);
		sqlSession.close();
		return list;
	}


}

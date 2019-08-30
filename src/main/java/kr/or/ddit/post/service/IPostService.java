package kr.or.ddit.post.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.post.model.Post;

public interface IPostService {
	List<Post> selectAll();
	
	Post getPost(Post post);
	
	Map<String, Object> getPostPagingList(Page page);
	
	List<Post> getPostLevel();

}

package kr.or.ddit.post.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.post.model.Attach;
import kr.or.ddit.post.model.Post;

public interface IPostService {
	List<Post> selectAll();
	
	Post getPost(Post post);
	
	Map<String, Object> getPostPagingList(Page page);
	
	List<Post> getPostLevel();
	
	int insertPost(Post post);
	
	int insertFile(Attach attach);
	
	List<Attach> getFile (int seq);
	
	int updateDel(Map map);
	
	int updatePost(Post post);
	
	int updateFile(Attach attach);

	int deleteFile(int seq);
	
	int insertReply(Post post);
	
	int insertCom(Map map);
	
	List<Map> selectCom(int seq);
	
	int updateCom(Map map);
	
	Attach getFile2(int seq);
	
}

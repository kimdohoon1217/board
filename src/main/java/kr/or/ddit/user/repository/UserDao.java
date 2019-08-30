package kr.or.ddit.user.repository;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.user.model.User;

public class UserDao implements IUserDao {

	@Override
	public User getUser(SqlSession sqlSession, String userId) {
		return sqlSession.selectOne("user.getUser", userId);
		
	}

}

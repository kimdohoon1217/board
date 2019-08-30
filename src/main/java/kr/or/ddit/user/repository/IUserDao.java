package kr.or.ddit.user.repository;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.user.model.User;

public interface IUserDao {
	User getUser(SqlSession sqlSession, String userId);
}

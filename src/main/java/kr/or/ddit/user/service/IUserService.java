package kr.or.ddit.user.service;

import kr.or.ddit.user.model.User;

public interface IUserService {
	/**
	 * Method : getUser
	 * 작성자 : PC-18
	 * 변경이력 :
	 * @param userId
	 * @return
	 * Method 설명 : 사용자 아이디로 유저정보 검색
	 */
	public User getUser(String userId);
}

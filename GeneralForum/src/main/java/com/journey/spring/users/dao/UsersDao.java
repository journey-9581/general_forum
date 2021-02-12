package com.journey.spring.users.dao;

import com.journey.spring.users.dto.UsersDto;

public interface UsersDao {
	//회원정보를 저장
	public void insert(UsersDto dto);
	//가입정보를 리턴
	public UsersDto getData(String id);
	//가입정보를 삭제
	public void delete(String id);
	//회원 가입 정보를 수정 반영
	public void update(UsersDto dto);
	//비밀번호 수정
	public boolean updatePwd(UsersDto dto);
	//인자로 전달된 아이디에 해당하는 비밀번호를 리턴
	public String getPwd(String id);
	//아이디 존재 여부를 리턴
	public boolean isExist(String id);
	//프로필 이미지 경로를 수정
	public void updateProfile(UsersDto dto);
}

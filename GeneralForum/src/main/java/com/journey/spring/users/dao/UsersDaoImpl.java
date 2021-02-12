package com.journey.spring.users.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.journey.spring.users.dto.UsersDto;

@Repository
public class UsersDaoImpl implements UsersDao{

	//핵심 의존 객체
	@Autowired
	private SqlSession session;
	
	@Override
	public void insert(UsersDto dto) {
		session.insert("users.insert", dto);
	}

	@Override
	public UsersDto getData(String id) {
		UsersDto dto=session.selectOne("users.getData", id);
		return dto;
	}

	@Override
	public void delete(String id) {
		session.delete("users.delete", id);
	}

	@Override
	public void update(UsersDto dto) {
		session.update("users.update", dto);
	}

	@Override
	public boolean updatePwd(UsersDto dto) {
		int count=session.update("users.updatePwd", dto);
		if(count==0) {
			return false;
		}else {
			return true;
		}
	}

	@Override
	public String getPwd(String id) {
		String pwd=session.selectOne("users.getPwd", id);
		return pwd;
	}

	@Override
	public boolean isExist(String id) {
		UsersDto dto=session.selectOne("users.isExist", id);
		if(dto==null) {
			return false;
		}else {
			return true;
		}
	}

	@Override
	public void updateProfile(UsersDto dto) {
		session.update("users.updateProfile", dto);
	}

}

package com.binbin.storesystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.binbin.storesystem.mapper.UserMapper;
import com.binbin.storesystem.model.User;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
	
	public boolean addUser(User user) {
		int saveUser = userMapper.saveUser(user);
		if (saveUser>0) {
			return true;
		}
		return false;
	}

	public User login(User user) {
		User userFromDao = userMapper.selectUserByAccount(user.getAccount());
		if (user.getPassword().equals(userFromDao.getPassword())) {
			return userFromDao;
		}
		return null;
	}
	
	public User getUserInfoById(Integer userId) {
		User userFromDao=null;
		if (userId!=null) {
			userFromDao = userMapper.getUserById(userId);
		}
		return userFromDao;
	}

	public boolean updateUser(User user) {
		int updateUser = userMapper.updateUser(user);
		if (updateUser>0) {
			return true;
		}
		return false;
	}

}

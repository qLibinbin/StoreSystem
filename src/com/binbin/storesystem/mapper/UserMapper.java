package com.binbin.storesystem.mapper;

import java.util.List;

import com.binbin.storesystem.model.User;

public interface UserMapper {
	 public int saveUser(User user);
	 public User selectUserByAccount(String account);
	 public User getUserById(Integer userId);
	 public int updateUser(User user);
	 public List<User> getAllUser();
	 public int deleteUserById(Integer userId);
}

package com.binbin.storesystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.binbin.storesystem.mapper.AdminMapper;
import com.binbin.storesystem.mapper.BusinessMapper;
import com.binbin.storesystem.mapper.UserMapper;
import com.binbin.storesystem.model.Admin;
import com.binbin.storesystem.model.Business;
import com.binbin.storesystem.model.User;

@Service
public class AdminService {
	@Autowired 
	private AdminMapper adminMapper;

	@Autowired 
	private UserMapper userMapper;
	
	@Autowired 
	private BusinessMapper businessMapper;
	
	public Admin login(Admin admin) {
		Admin adminFromDao = adminMapper.selectAdminByAccount(admin.getAccount());
		if (adminFromDao.getPassword().equals(admin.getPassword())) {
			return adminFromDao;
		}
		return null;
	}

	public boolean addAdmin(Admin admin) {
		int saveAdmin = adminMapper.saveAdmin(admin);
		if (saveAdmin>0) {
			return true;
		}
		return false;
	}

	public List<User> getAllUser() {
		List<User> allUser = userMapper.getAllUser();
		return allUser;
	}

	public boolean haveAccount(String adminAccount) {
		Admin selectAdminByAccount = adminMapper.selectAdminByAccount(adminAccount);
		if (selectAdminByAccount!=null) {
			return true;
		}
		return false;
	}

	public List<Business> getAllBusiness() {
		List<Business> allBusiness = businessMapper.getAllBusiness();
		return allBusiness;
	}

	public boolean deleteBusinessById(Integer businessId) {
		int a= businessMapper.deleteBusinessById(businessId);
		if (a>0) {
			return true;
		}
		return false;
	}
	
	public boolean deleteUserById(Integer userId) {
		int a= userMapper.deleteUserById(userId);
		if (a>0) {
			return true;
		}
		return false;
	}
	
	
	
}

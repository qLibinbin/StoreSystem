package com.binbin.storesystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.binbin.storesystem.mapper.BusinessMapper;
import com.binbin.storesystem.model.Business;
import com.binbin.storesystem.model.User;

@Service
public class BusinessService {

	@Autowired
	private BusinessMapper businessMapper;
	
	public boolean saveBusiness(Business business) {
		int saveBusiness = businessMapper.saveBusiness(business);
		if (saveBusiness>0) {
			return true;
		}
		return false;
	}

	public Business login(Business business) {
		Business businessFromDao = businessMapper.selectBusinessByAccount(business.getAccount());
		if (businessFromDao.getPassword().equals(business.getPassword())) {
			business.setPassword(null);
			return businessFromDao;
		}
		return null;
	}
	
	public Business getBusinessInfoById(Integer businessId) {
		Business businessFromDao=null;
		if (businessId!=null) {
			businessFromDao = businessMapper.selectBusinessById(businessId);
		}
		return businessFromDao;
	}
	public boolean updateBusiness(Business business) {
		int updateBusiness = businessMapper.updateBusiness(business);
		if (updateBusiness>0) {
			return true;
		}
		
		return false;
	}
	
}

package com.binbin.storesystem.mapper;


import java.util.List;

import com.binbin.storesystem.model.Business;

public interface BusinessMapper {
	 public int saveBusiness(Business business);
	 public Business selectBusinessByAccount(String account);
	 public Business selectBusinessById(Integer businessId);
	 public int updateBusiness(Business business);
	 public List<Business> getAllBusiness();
	 public int deleteBusinessById(Integer businessId);
}

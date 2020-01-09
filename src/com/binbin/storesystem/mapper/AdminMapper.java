package com.binbin.storesystem.mapper;

import com.binbin.storesystem.model.Admin;

public interface AdminMapper {
	public int saveAdmin(Admin admin);
    public Admin selectAdminByAccount(String account);
}

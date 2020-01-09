package com.binbin.storesystem.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.binbin.storesystem.model.Admin;
import com.binbin.storesystem.model.Business;
import com.binbin.storesystem.model.User;
import com.binbin.storesystem.service.AdminService;
import com.google.gson.Gson;

@Controller
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@RequestMapping("/loginAdmin.action")
	public String loginAdmin(Admin admin,HttpServletRequest request) {
		if (admin==null || admin.getAccount()==null || admin.getPassword()==null) {
			return "redirect:loginAdmin.html";
		}
		if (admin.getAccount().equals("admin") && admin.getPassword().equals("admin")) {
			request.getSession().setAttribute("adminAccount", "admin");
			return "redirect:admin.html";
		}
		Admin loginAdmin = adminService.login(admin);
		if (loginAdmin!=null) {
			request.getSession().setAttribute("adminAccount", loginAdmin.getAccount());
			return "redirect:admin.html";
		}
		return "redirect:loginAdmin.html";
	}
	
	@RequestMapping(value="/registerAdmin.action",produces = "text/plain;charset=utf-8")
	public String registerAdmin(Admin admin) {
		if (admin==null || admin.getAccount()==null || admin.getPassword()==null) {
			return null;
		}
		boolean addAdmin = adminService.addAdmin(admin);
		if (addAdmin) {
			return "redirect:loginAdmin.html";
		}
		return "redirect:registerAdmin.html";
	}
	
	//getAllUser
	@RequestMapping(value="/getAllUser.action",produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String getAllUser(HttpServletRequest request) {
		
		String adminAccount = (String) request.getSession().getAttribute("adminAccount");
		
		boolean haveAccount =adminService.haveAccount(adminAccount);
		
		if (haveAccount || adminAccount.equals("admin")) {
			List<User> userList= adminService.getAllUser();
			Gson gson=new Gson();
			return gson.toJson(userList);
		}
		return null;
	}
	
	@RequestMapping(value="/getAllBusiness.action",produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String getAllBusiness(HttpServletRequest request) {
		
		String adminAccount = (String) request.getSession().getAttribute("adminAccount");
		
		boolean haveAccount =adminService.haveAccount(adminAccount);
		
		if (haveAccount || adminAccount.equals("admin")) {
			List<Business> businesseList= adminService.getAllBusiness();
			Gson gson=new Gson();
			return gson.toJson(businesseList);
		}
		return null;
	}
	
	@RequestMapping(value="/deleteBusiness.action",produces = "text/plain;charset=utf-8")
	public String deleteBusiness(Integer businessId,HttpServletRequest request) {
		
		String adminAccount = (String) request.getSession().getAttribute("adminAccount");
		
		boolean haveAccount =adminService.haveAccount(adminAccount);
		
		if ((haveAccount || adminAccount.equals("admin")) && businessId!=null) {
			if (adminService.deleteBusinessById(businessId)) {
				return "redirect:adminManageBusiness.html";
			}
			
		}
		return "redirect:loginAdmin.html";
	}
	
	@RequestMapping(value="/deleteUser.action",produces = "text/plain;charset=utf-8")
	public String deleteUser(Integer userId,HttpServletRequest request) {
		
		String adminAccount = (String) request.getSession().getAttribute("adminAccount");
		
		boolean haveAccount =adminService.haveAccount(adminAccount);
		
		if ((haveAccount || adminAccount.equals("admin")) && userId!=null) {
			if (adminService.deleteUserById(userId)) {
				return "redirect:adminManageUser.html";
			}
			
		}
		return "redirect:loginAdmin.html";
	}
	
	
	
}

package com.binbin.storesystem.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.binbin.storesystem.model.Business;
import com.binbin.storesystem.model.OrderItem;
import com.binbin.storesystem.model.Product;
import com.binbin.storesystem.model.User;
import com.binbin.storesystem.service.BusinessService;
import com.binbin.storesystem.service.OrderService;
import com.binbin.storesystem.service.ProductService;
import com.google.gson.Gson;


@Controller
public class BusinessController {
	
	@Autowired
	private BusinessService businessService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value="/registerBusiness.action",produces = "text/plain;charset=utf-8")
	public String register(Business business,String checkPassword) {
		if (business==null || business.getAccount()==null || business.getPassword()==null) {
			return "redirect:registerBusiness.html";
		}else if (!business.getPassword().equals(checkPassword)) {
			return "redirect:registerBusiness.html";
		}
		
		boolean saveBusiness = businessService.saveBusiness(business);
		if (saveBusiness) {
			return "redirect:loginBusiness.html";
		}
		return "redirect:registerBusiness.html";
	}
	
	@RequestMapping("/loginBusiness.action")
	public String login(Business business,HttpServletRequest request) {
		if (business.getAccount()==null || business.getPassword()==null) {
			return "redirect:loginBusiness.html";
		}
		Business businessFromDao = businessService.login(business);
		if (businessFromDao!=null) {
			request.getSession().setAttribute("businessId", businessFromDao.getBusinessId());
			
			return "redirect:business.html";
		}
		return "redirect:loginBusiness.html";
	}
	
	@RequestMapping(value="/getLoginBusinessInfo.action",produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String getLoginBusinessInfo(HttpServletRequest request) {

		Integer businessId = (Integer) request.getSession().getAttribute("businessId");
		if (businessId==null) {
			return null;
		}
		Business loginBusiness = businessService.getBusinessInfoById(businessId);
		if (loginBusiness==null) {
			return null;
		}
		loginBusiness.setPassword(null);

		Gson gson=new Gson();
		String json = gson.toJson(loginBusiness);
		return json;
	}
	//getBusinessInfoById
	@RequestMapping(value="/getBusinessInfoById.action",produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String getBusinessInfoById(Integer businessId,HttpServletRequest request) {

		if (businessId==null) {
			return null;
		}
		Business loginBusiness = businessService.getBusinessInfoById(businessId);
		if (loginBusiness==null) {
			return null;
		}
		loginBusiness.setPassword(null);

		Gson gson=new Gson();
		String json = gson.toJson(loginBusiness);
		return json;
	}
	@RequestMapping(value="/saveBusinessInfo.action",produces = "text/plain;charset=utf-8")
	public String saveBusinessInfo(Business business,HttpServletRequest request) {

		Integer businessId = (Integer) request.getSession().getAttribute("businessId");
		String adminAccount = (String) request.getSession().getAttribute("adminAccount");
		
		if (businessId!=business.getBusinessId() && adminAccount==null) {
			return "redirect:loginBusiness.html";
		}
		boolean updateBusiness = businessService.updateBusiness(business);
		if (updateBusiness) {
			if (adminAccount!=null) {
				return "redirect:adminManageBusiness.html";
			}
			return "redirect:business.html";
		}

		return "redirect:loginBusiness.html";
	}
	
	@RequestMapping(value="/businessAddProduct.action",produces = "text/plain;charset=utf-8")
	public String businessAddProduct(Product product,HttpServletRequest request) {

		Integer businessId = (Integer) request.getSession().getAttribute("businessId");
		if (businessId==null || product==null) {
			return "redirect:loginBusiness.html";
		}
		product.setBusinessId(businessId);
		boolean saveProduct=productService.saveProduct(product);
		
		if (saveProduct) {
			return "redirect:businessManageProduct.html";
		}

		return "redirect:loginBusiness.html";
	}
	
	@RequestMapping(value="/businessSaveProduct.action",produces = "text/plain;charset=utf-8")
	public String businessSaveProduct(Product product,HttpServletRequest request) {

		Integer businessId = (Integer) request.getSession().getAttribute("businessId");
		System.out.println(product);
		if (businessId==null || product==null || product.getProductId()==null) {
			return "redirect:loginBusiness.html";
		}
		product.setBusinessId(businessId);
		boolean updateProduct=productService.updateProduct(product);
		
		if (updateProduct) {
			return "redirect:businessManageProduct.html";
		}

		return "redirect:loginBusiness.html";
	}
	
	@RequestMapping(value="/getLoginBusinessProductList.action",produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String getLoginBusinessProductList(HttpServletRequest request) {

		Integer businessId = (Integer) request.getSession().getAttribute("businessId");
		if (businessId==null) {
			return null;
		}
		
		List<Product> productList=productService.selectProductByBusinessId(businessId);
		
		Gson gson=new Gson();
		String json = gson.toJson(productList);

		return json;
	}
	
	
	@RequestMapping(value="/getBusinessOrders.action",produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String getBusinessOrders(HttpServletRequest request) {
		Integer businessId = (Integer) request.getSession().getAttribute("businessId");
		if (businessId==null) {
			return null;
		}
		List<OrderItem> orderItems =orderService.getOrderItemByBusinessId(businessId);
		Gson gson=new Gson();
		String json = gson.toJson(orderItems);
		System.out.println(json);
		return json;
	}
	
}

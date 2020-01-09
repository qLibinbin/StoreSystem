package com.binbin.storesystem.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.binbin.storesystem.model.OrderItem;
import com.binbin.storesystem.model.Product;
import com.binbin.storesystem.model.User;
import com.binbin.storesystem.service.OrderService;
import com.binbin.storesystem.service.ProductService;
import com.binbin.storesystem.service.UserService;
import com.google.gson.Gson;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value="/registerUser.action",produces = "text/plain;charset=utf-8")
	public String register(User user) {
		System.out.println(user);
		if (user==null || user.getAccount()==null || user.getPassword()==null) {
			return "registerUser.html";
		}
		boolean addUser = userService.addUser(user);
		if (addUser) {
			//Gson gson=new Gson();
			return "login.html";
		}
		return "registerUser.html";
	}
	
	@RequestMapping("/loginUser.action")
	public String login(User user,HttpServletRequest request) {
		if (user.getAccount()==null || user.getPassword()==null) {
			return null;
		}
		User loginUser = userService.login(user);
		if (loginUser!=null) {
			request.getSession().setAttribute("userId", loginUser.getUserId());
			
			return "redirect:user.html";
		}
		return "redirect:login.html";
		
	}
	@RequestMapping(value="/getLoginUserInfo.action",produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String getLoginUserInfo(HttpServletRequest request) {

		Integer userId = (Integer) request.getSession().getAttribute("userId");
		if (userId==null) {
			return null;
		}
		User loginUser = userService.getUserInfoById(userId);
		if (loginUser==null) {
			return null;
		}
		loginUser.setPassword(null);

		Gson gson=new Gson();
		String json = gson.toJson(loginUser);
		return json;
	}
	
	@RequestMapping(value="/getUserInfoById.action",produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String getUserInfoById(Integer userId,HttpServletRequest request) {
		if (userId==null) {
			return null;
		}
		User loginUser = userService.getUserInfoById(userId);
		if (loginUser==null) {
			return null;
		}
		loginUser.setPassword(null);

		Gson gson=new Gson();
		String json = gson.toJson(loginUser);
		return json;
	}
	
	@RequestMapping(value="/saveUserInfo.action",produces = "text/plain;charset=utf-8")
	public String saveUserInfo(User user,HttpServletRequest request) {

		Integer userId = (Integer) request.getSession().getAttribute("userId");
		String adminAccount = (String) request.getSession().getAttribute("adminAccount");
		if (userId!=user.getUserId() && adminAccount==null) {
			return "redirect:login.html";
		}
		boolean updateUser = userService.updateUser(user);
		if (updateUser) {
			if (adminAccount!=null) {
				return "redirect:adminManageUser.html";
			}
			return "redirect:user.html";
		}

		return "redirect:login.html";
	}
	
	@RequestMapping(value="/getProductListByName.action",produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String getProductListByName(String productName,HttpServletRequest request) {
		
		Integer userId = (Integer) request.getSession().getAttribute("userId");
		if (userId==null) {
			return null;
		}
		if (productName==null) {
			productName="";
		}
		List<Product> products = productService.selectProductByProductName(productName);
		Gson gson=new Gson();
		String json = gson.toJson(products);
		
		return json;
	}
	
	@RequestMapping(value="/getProductById.action",produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String getProductById(Integer productId,HttpServletRequest request) {
		
		if (productId==null) {
			return null;
		}
		Product product = productService.selectProductById(productId);
		Gson gson=new Gson();
		String json = gson.toJson(product);
		
		return json;
	}
	
	@RequestMapping(value="/userBuyProduct.action",produces = "text/plain;charset=utf-8")
	public String userBuyProduct(Integer productId,Integer buyNumbers,HttpServletRequest request) {
		Integer userId = (Integer) request.getSession().getAttribute("userId");
		if (productId==null || buyNumbers==null || userId==null) {
			return "store.html";
		}
		boolean newOrder = orderService.newOrder(productId, userId, buyNumbers);
		if (newOrder) {
			return "myOrder.html";
		}
		return "store.html";
	}
	@RequestMapping(value="/getMyOrders.action",produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String getMyOrders(HttpServletRequest request) {
		Integer userId = (Integer) request.getSession().getAttribute("userId");
		if (userId==null) {
			return null;
		}
		List<OrderItem> orderItems =orderService.getOrderItemByUserId(userId);
		Gson gson=new Gson();
		String json = gson.toJson(orderItems);
		System.out.println(json);
		return json;
	}
	
}

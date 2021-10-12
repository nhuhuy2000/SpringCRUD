package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.domain.User;
import com.example.demo.model.Userdto;
import com.example.demo.service.UserService;

@Controller
@RequestMapping("admin/users")
public class UserController {
	@Autowired
	UserService userService;
	
	@Autowired
	User _userBean;
	@RequestMapping("add")
	public String add(ModelMap model) {
		User u = new User();
		
		model.addAttribute("USER", u);
		model.addAttribute("ACTION", "saveOrUpdate");
		return "admin/AddUsers";
	}
	@PostMapping("/saveOrUpdate")
	public String saveOrUpdate(ModelMap model, @ModelAttribute("USER") User user) {
		userService.save(user);
		return "admin/AddUsers";
	}
	@RequestMapping("list")
	public String list(ModelMap model, HttpSession session) {
		List<User> list = userService.findAll();
		if(session.getAttribute("USERNAME") != null) {
			model.addAttribute("USER", list);
			return "admin/ViewUsers";
		}
		return "admin/login";
	}
	@GetMapping("edit/{username}")
	public ModelAndView edit(ModelMap model,@PathVariable(name="username") String username) {
		Optional<User> opt = userService.findById(username);
		Userdto user = new Userdto();
		if(opt.isPresent()) {
			User userD = opt.get();
			model.addAttribute("USER", user);
			BeanUtils.copyProperties(userD, user);//Copy gia tri giua 2 class
			user.setIsEdit(true);
			return new ModelAndView("admin/users/add", model);
		}
		 model.addAttribute("message", "User is not existed");
			return new ModelAndView("forward:/admin/users/list", model);
	}
	@GetMapping("/delete/{username}")
	public ModelAndView delete(ModelMap model,@PathVariable(name="username") String username) {
		userService.deleteById(username);
		model.addAttribute("USERS", userService.findAll());
		return new ModelAndView("forward:/admin/users/list", model);
	}
	//Bat dau login
	@RequestMapping("login")
	public String showLogin() {
		return "admin/login";
	}
	@PostMapping("checkLogin")
	public String checkLogin(@RequestParam("username") String username,
			@RequestParam("password")String password,ModelMap model,HttpSession httpSession) {
		if(userService.checkLogin(username, password)) {
			System.out.println("Login thanh cong");
			List<User> list = userService.findAll();
			httpSession.setAttribute("USERNAME", username);
			model.addAttribute("USER", list);
			return "admin/ViewUsers";
		}else{
			System.out.println("Login that bai");
			model.addAttribute("ERROR", "Mat khau hoac tai khoan khong chinh xac");
		}
		return "admin/login";
	}
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.removeAttribute("USERNAME");
		return "redirect:/admin/login";
	}
}



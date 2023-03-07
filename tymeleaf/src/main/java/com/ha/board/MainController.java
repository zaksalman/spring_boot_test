package com.ha.board;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import lombok.Data;

@Controller
@RequestMapping("/")
public class MainController {

	@RequestMapping("/")
	public String main(Model model)
	{
		model.addAttribute("test","test 입니다.");
		model.addAttribute("test1","<b>test</b> 입니다.");
		System.out.println("test");
		return "test";
	}
	
	@RequestMapping("/test1")
	public String test1(Model model, HttpSession httpSession)
	{
		User userA = new User("userA", 10);
		User userB = new User("userB", 20);
		
		List<User> list = new ArrayList<>(Arrays.asList(userA,userB));
		
		Map<String, User> map = new HashMap<>();
		map.put("userA", userA);
		map.put("userB", userB);
		
		model.addAttribute("user", userA);
		model.addAttribute("users", list);
		model.addAttribute("userMap", map);
		
		
		httpSession.setAttribute("sessionData", "Http Session");
				
		return "test1";
	}
	
	@Data
	static class User
	{
		private String username;
		private int age;
		
		public User(String username, int age)
		{
			this.username = username;
			this.age = age;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}
	}
	
	@Component
	static class HelloBean
	{
		public String hello(String data)
		{
			return "Hello " + data;
		}
	}
	
}

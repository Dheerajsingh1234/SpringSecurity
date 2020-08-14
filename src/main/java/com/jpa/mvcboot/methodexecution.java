package com.jpa.mvcboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class methodexecution {

	@GetMapping("/")
	public String method()
	{
		return "index";
	}
	@GetMapping("/admin/index")
	public String method2()
	{
		return "admin/index";
	}
	
	@GetMapping("/profile/index")
	public String method3()
	{
		return "profile/index";
	}
	@GetMapping("/login")
	public String login()
	{
		return "login";
	}
	@GetMapping("/signin")
	public String signin()
	{
		return "login";
	}
	@ResponseBody
	@GetMapping("test1")
	public String test1()
	{
		return "<h1>test1</h1>";
	}
	@ResponseBody
	@GetMapping("test2")
	public String test2()
	{
		return "<h1>test2</h1>";
	}
	
}

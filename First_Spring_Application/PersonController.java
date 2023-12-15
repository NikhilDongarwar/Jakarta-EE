package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class PersonController {
	
	@GetMapping("/")
	public String on() {
		
		return "hyper";
		
	}
	
	@GetMapping("person")
	public String onSubmit() {
		
		return "person";
		
	}
	
	@PostMapping("View")
	public String afterSubmit(@RequestParam("name") String name,@RequestParam("address") String address,@RequestParam("age") int age,Model model) 
	{
		Person p1=new Person();
		p1.setName(name);
		p1.setAddress(address);
		
	     p1.setAge(age);
	     model.addAttribute("persons",p1);
	     
		return "View";
		
		
			}

}

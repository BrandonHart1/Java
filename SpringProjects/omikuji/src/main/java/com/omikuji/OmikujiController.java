package com.omikuji;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OmikujiController 
{
	@GetMapping("/")
	public String index()
	{
		return "index";
	}
	
	@PostMapping("/process")
	public String process
	(
		@RequestParam("number") Integer number,
		@RequestParam("city") String city,
		@RequestParam("person") String person,
		@RequestParam("hobby") String hobby,
		@RequestParam("thing") String thing,
		@RequestParam("message") String message,
		Model model,
		HttpSession session
		
	)
	
	{
		
		session.setAttribute("number", number);
		session.setAttribute("city", city);
		session.setAttribute("person", person);
		session.setAttribute("hobby", hobby);
		session.setAttribute("thing", thing);
		session.setAttribute("message", message);

		
		return "redirect:/show";
	}
	
	public String show(Model model, HttpSession session)
	{
		return "show";
	}
};

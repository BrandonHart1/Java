package com.daikichi.routes;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/daikichi") // ----- all of the following routes will start with /daikichi -----

public class Controller 
{
	@RequestMapping("/")
	public String welcome()
	{
		return "Welcome!";
	}
	
	@RequestMapping("/today")
	public String today()
	{
		return "Today you will find luck in all endeavors!";
				
	}
	
	@RequestMapping("/tomorrow")
	public String tomorrow()
	{
		return "Tomorrow, an opportunity will arise, so be sure to be open to new ideas!";
	}
	
	
}

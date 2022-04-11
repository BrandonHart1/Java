package com.daikichi.routes;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/daikichi") // ----- all of the following routes will start with /daikichi -----
public class Controller 
{
	@RequestMapping("")
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
	
	@RequestMapping("/travel/{city}")
	public String city(@PathVariable("city") String city)
	{
		return "Congratulations! You will soon travel to " + city + "!";
	}
	
	@RequestMapping("/lotto/{city}/{number}")
	public String destination(@PathVariable("city") String city, @PathVariable("number") Integer number)
	{
		if(number % 2 == 0)
			{
				return "You will take a grand journey in the near future but be werary of tempting offers.";
			}
			
			return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends";
		

	}
	
	
	
}

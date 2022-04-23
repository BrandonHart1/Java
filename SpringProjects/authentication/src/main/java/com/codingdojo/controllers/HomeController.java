package com.codingdojo.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.models.LoginUser;
import com.codingdojo.models.User;
import com.codingdojo.services.UserService;

@Controller
public class HomeController 
{
	@Autowired
	private UserService userService;
	 
	public HomeController(UserService userService)
	{
		this.userService=userService;
	}
    
    @GetMapping("/")
    public String index(Model model, HttpSession session)
    {
        // Bind empty User and LoginUser objects to the JSP
        // to capture the form input
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "login";
    }
    
    @GetMapping("/home")
    public String home(Model model, HttpSession session)
    {
    	if(!UserService.IsLoggedIn(session)) return "redirect:/";
    	return "home";
    }
    
    @RequestMapping("/logout")
	public String logout(HttpSession session)
	{
    	UserService.Logout(session);
    	return "redirect:/";
	}
    
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession session) {
        
        // TO-DO Later -- call a register method in the service 
        // to do some extra validations and create a new user!

    	
        if(result.hasErrors()) {
            // Be sure to send in the empty LoginUser before 
            // re-rendering the page.
            model.addAttribute("newLogin", new LoginUser());
            return "login";
        }
        System.out.println("Whatever I want");
        User user = userService.register(newUser, result);
        if(user==null)
        {
            model.addAttribute("newLogin", new LoginUser());
        	return "login";
        }
        // No errors! 
        // TO-DO Later: Store their ID from the DB in session, 
        // in other words, log them in.
    
        return "redirect:/home";
    }
    
    @PostMapping("/login")
    public String login
    (
    		@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, 
            Model model, HttpSession session
    ) 
    {
        
    
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "login";
        }
    
        User user = userService.login(newLogin, result);
        if(user==null)
        {
        	model.addAttribute("newUser", new User());
        	return "login";
        }
        // No errors! 
        // TO-DO Later: Store their ID from the DB in session, 
        // in other words, log them in.
        session.setAttribute("session_user", user);
        return "redirect:/home";
    }
};

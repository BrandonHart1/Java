package com.codingdojo.services;

import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.models.LoginUser;
import com.codingdojo.models.User;
import com.codingdojo.repositories.UserRepository;

@Service
public class UserService 
{
	@Autowired
    private UserRepository userRepo;
    
    public User register(User newUser, BindingResult result) 
    {
    	User existing_user=userRepo.findByEmail(newUser.getEmail());
    	int errors=0;
    	if(existing_user!=null)
    	{
        	result.rejectValue("email","email_invalid","Email is in use.");
        	errors++;
    	}
    	if(!newUser.getPassword().equals(newUser.getConfirm()))
    	{
    		result.rejectValue("password","password_mismatch","Password and Password Confirmation must match!");
    		errors++;
    	}
    	if(errors>0) return null;
    	String hashed_pw=BCrypt.hashpw(newUser.getPassword(),BCrypt.gensalt(8));
    	newUser.setPassword(hashed_pw);
    	userRepo.save(newUser);
        return newUser;
    }
    
    
    public User login
    (LoginUser newLoginObject, 
    		BindingResult result
    ) 
    {
    	User db_user=userRepo.findByEmail(newLoginObject.getEmail());
    	int errors=0;
    	if(db_user==null)
    	{
    		result.rejectValue("email","invalid_email","Email not found.");
    		errors++;
    	}
    	if(db_user!=null)
    	{
    		Boolean match=BCrypt.checkpw(newLoginObject.getPassword(),db_user.getPassword());
    		if(!match)
    		{
    			result.rejectValue("password","invalid_password","Invalid Password");
    			errors++;
    		}
    	}
    	if(errors>0) return null;
    	return db_user;
    }
    
    public static Boolean IsLoggedIn(HttpSession session)
	{
		return session.getAttribute("session_user")!=null;
	}
    
    public static void Logout(HttpSession session)
	{
		if(!IsLoggedIn(session)) return;
		session.removeAttribute("session_user");
	}
};

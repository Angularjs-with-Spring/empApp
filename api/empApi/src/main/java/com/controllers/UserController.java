package com.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.models.User;

import empRepo.UserRepository;

@Controller
@ComponentScan(basePackages = {"empRepo"})
@RequestMapping(value = "users")
public class UserController {

	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
    public  @ResponseBody Object getAllUsers( ModelMap model ) {
		
		//operationInf.msg("RITESH","SIGNH");
		/*int t = operationInf.m("RRRR");
		System.out.println(t);*/
		/*operationInf.k();*/
		
		User entity = new User();
		entity.setId(3);
		entity.setFirstName("RITESH SINGH");
		userRepository.save(entity);
		entity = new User();
		entity.setId(4);
		entity.setFirstName("SINGH");
		mongoTemplate.save(entity);
		
        String jsonData = "[{\"id\":\"3253123\",\"firstname\":\"Chris\",\"lastname\":\"Johnson\",\"address\":\"211, Geoffrey Drive\",\"city\":\"Newark\",\"phone\":\"999-888-6666\",\"email\":\"chrisj@yahoo.com\"},{\"id\":\"67643837\",\"firstname\":\"Bill\",\"lastname\":\"Derkson\",\"address\":\"201, Sleepy Hollow Drive\",\"city\":\"Newark\",\"phone\":\"999-777-2222\",\"email\":\"billd@gmail.com\"}]";
        return null;
    }
	
	@RequestMapping(value = "/auth", method = RequestMethod.GET)
    public  @ResponseBody String getAuth( ModelMap model ) {
		
		String response = "{\"status\":\"false\"}";
        return response;
    }
	
	@RequestMapping(value = "/users/new", method = RequestMethod.POST)
    public  @ResponseBody String createNewUser( @RequestBody User user )   {        
        //
        // Code processing the input parameters
        //    
         String response = "{\"message\":\"Created New User - firstname: " + user.getFirstName() + ", lastname: " + user.getLastName() + ", address: " + user.getAddress() + ", email: " + user.getEmail()+"\"}";
        return response;
    }
	
	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public  @ResponseBody String getUsersById( @PathVariable("id") long userId )   {        
        //
        // Code processing the input parameters
        //
        String response = "{\"id\":\""+ userId + "\",\"firstname\":\"FirstName\",\"lastname\":\"LastName\",\"address\":\"Some Address\",\"age\":\"SomeNo\",\"email\":\"sometext@gmail.com\"}";
        return response;

    }
	
	@RequestMapping(value = { "/template" }, method = RequestMethod.GET)
	public ModelAndView form() throws IOException {
		
		Map<String, Object> data = new HashMap<String, Object>();
		
		return new ModelAndView("user/newuser", "data", data);
	}
	
	@RequestMapping(value = { "/launchUser" }, method = RequestMethod.GET)
	public ModelAndView hostLaunch() throws IOException {
		Map<String, Object> data = new HashMap<String, Object>();
			
		return new ModelAndView("user/new", "data", data);
	}
	
	@RequestMapping(value = { "/launchEmployee" }, method = RequestMethod.GET)
	public ModelAndView hostLaunchE() throws IOException {
		Map<String, Object> data = new HashMap<String, Object>();
			
		return new ModelAndView("employee/newuser", "data", data);
	}
}

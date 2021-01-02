package org.polytec.vermeg.controller;

import java.util.List;


import org.polytec.vermeg.model.User;
import org.polytec.vermeg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/user")
public class userController {
	@Autowired
	UserService userService;
	@RequestMapping(value = "/Home", method = RequestMethod.GET, produces = "application/json")
    public String sayHello(){
        return "hello ";
    }
	
	@RequestMapping(value = "/getAllUsers", method = RequestMethod.GET, produces = "application/json")
	public List<User> getAllUsers() {
		
		List<User> listOfUsers = userService.getAllUsers();
		
		return listOfUsers;
	}
	
	
	@RequestMapping(value = "/getUser/{idUser}", method = RequestMethod.GET, headers = "Accept=application/json")
	public User getUserById(@PathVariable Long idUser) {
		return userService.getUserByID(idUser);
	}
	
	@RequestMapping(value = "/getUserByName/{username}", method = RequestMethod.GET, headers = "Accept=application/json")
	public User getUserByName(@PathVariable String username) {
		return userService.getUserByName(username);
	}
	@RequestMapping(value = "/SignUp", method = RequestMethod.POST, headers = "Accept=application/json")
	public String SignUp(@ModelAttribute("user")User user) {	
		if(user.getIdUser()==0)
		{
			userService.SignUp(user);
		}
		
		return "redirect:/getAllUsers";
	}

	@RequestMapping(value = "/updateuser",method = RequestMethod.POST, headers = "Accept=application/json")
	public void updateuser(@RequestBody User user) {
		userService.updateUser(user);
	        
	}

	@RequestMapping(value = "/deleteuser/{idUser}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public String deleteUser(@PathVariable("idUser") Long idUser) {
		userService.deleteUser(idUser);
		     return "redirect:/getAllUsers";

	}	
	@RequestMapping(value = "/SignIn", method = RequestMethod.POST, headers = "Accept=application/json")
	public String SignIn(@ModelAttribute("user")User user, Model model) {	
		List<User> UserList = userService.getAllUsers();
		for(int i=0;i<UserList.size();i++) {
			if(user.getUsername().equals(UserList.get(i).getUsername())&&(user.getPassword().equals(UserList.get(i).getPassword())) ) {
				System.out.println("Successfulyyyyyyyyyy");
				model.addAttribute("UserMsg", "Successfuly");
				
				return "redirect:/Home";
			}	
			if(!user.getUsername().equals(UserList.get(i).getUsername())&&(!user.getPassword().equals(UserList.get(i).getPassword())) ) {
				System.out.println("existe");
				model.addAttribute("UserMsg", "Successfuly");
				
				return "redirect:/SignUp";
			}	
		}
		
			return "redirect:/getAllUsers";
}
}

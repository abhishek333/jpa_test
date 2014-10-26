/**
 * 
 */
package asn.jpa_test.web.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import asn.jpa_test.core.entity.UserInfo;
import asn.jpa_test.core.services.IUserInfoServices;

/**
 * @author Abhishek
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired private IUserInfoServices userInfoServices;
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String addUserView(Model model){
		model.addAttribute("newUser", new UserInfo());
		return "thymeleaf/user";
	}

	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String processAddUser(Model model, @ModelAttribute("newUser")UserInfo userInfo, BindingResult bindingResult){
		System.out.println(userInfo);
		//userInfoServices.save(userInfo);		
		return "redirect:/user/add";
	}
	
	@ModelAttribute("listUsers")
	public List<UserInfo> listUsers(){
		return userInfoServices.findAll();
	}
}

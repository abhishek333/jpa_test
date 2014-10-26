/**
 * 
 */
package asn.jpa_test.web.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Abhishek
 *
 */
@Controller
public class IndexController {

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String thymeleafHome(){
		
		return "thymeleaf/home";
	}

	@RequestMapping(value="/jsp-home", method=RequestMethod.GET)
	public String jspHome(){
		
		return "jsp/home";
	}
}

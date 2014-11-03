/**
 * 
 */
package asn.jpa_test.web.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import asn.jpa_test.core.services.IPersonService;
import asn.jpa_test.web.mvc.json.dto.PersonJson;

/**
 * @author Abhishek
 *
 */
@Controller
public class PersonController {

	@Autowired private IPersonService personService;
	
	@RequestMapping(value = "/pages/{pageNumber}", method = RequestMethod.GET)
	public String getRunbookPage(@PathVariable Integer pageNumber, Model model) {
	    Page<PersonJson> page = personService.findAllPersonJson(pageNumber);

	    int current = page.getNumber() + 1;
	    int begin = Math.max(1, current - 5);
	    int end = Math.min(begin + 10, page.getTotalPages());

	    model.addAttribute("personPage", page);
	    model.addAttribute("beginIndex", begin);
	    model.addAttribute("endIndex", end);
	    model.addAttribute("currentIndex", current);

	    return "jsp/person";
	}
}

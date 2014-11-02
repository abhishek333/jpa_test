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
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.Validator;

/**
 * @author Abhishek
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private final Logger LOG = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserInfoServices userInfoServices;
    @Resource(name = "userInfoValidator")
    private Validator userInfoValidator;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addUserView(Model model) {
        LOG.info("GET came to /user/add");
        model.addAttribute("newUser", new UserInfo());
        return "thymeleaf/user";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processAddUser(Model model, @ModelAttribute("newUser") UserInfo userInfo, BindingResult bindingResult) {
        LOG.info("POST came to /user/add");
        System.out.println(userInfo);
        userInfoValidator.validate(userInfo, bindingResult);
        if (bindingResult.hasErrors()) {
            LOG.info("validation failed..");
            return "thymeleaf/user";
        }
        //userInfoServices.save(userInfo);		
        return "redirect:/user/add";
    }

    @ModelAttribute("listUsers")
    public List<UserInfo> listUsers() {
        return userInfoServices.findAll();
    }
}

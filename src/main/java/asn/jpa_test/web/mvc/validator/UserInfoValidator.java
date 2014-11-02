/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asn.jpa_test.web.mvc.validator;

import asn.jpa_test.core.entity.UserInfo;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Abhishek
 */
@Component(value = "userInfoValidator")
public class UserInfoValidator implements Validator{

    @Override
    public boolean supports(Class<?> clazz) {
        return UserInfo.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fullName", "", "fullName required!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "", "userName required!");
    }
    
    
}

package posts.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import posts.entities.UserEntity;
import posts.service.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registrationForm(Model model){
        model.addAttribute("user", new UserEntity());
        return "registration";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processRegistration(@Valid UserEntity userEntity, Errors errors){
        if(errors.hasErrors()){
            return "registration";
        }

        userService.save(userEntity);
        return "redirect:/user/" + userEntity.getUsername();
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public String userProfile(@PathVariable String username, Model model){
        UserEntity userEntity = userService.getByUsername(username);

        model.addAttribute("user", userEntity);
        return "userprofile";
    }
}

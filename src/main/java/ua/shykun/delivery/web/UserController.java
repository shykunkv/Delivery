package ua.shykun.delivery.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.shykun.delivery.domain.User;
import ua.shykun.delivery.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;



    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegister() {
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String doRegister(@ModelAttribute User user) {
        userService.register(user);
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLogin() {
        return "login";
    }
}

package ua.shykun.delivery.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.shykun.delivery.domain.Pizza;
import ua.shykun.delivery.service.PizzaService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@Controller
@SessionAttributes("message")
public class HelloController {

    @Autowired
    private PizzaService pizzaService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "home";
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:menu";
    }

//    @ModelAttribute("message")
//    public String getString() {
//        return new String("Hello");
//
//    }

//    @RequestMapping(value = "/hello", method = RequestMethod.GET)
//    public String hello(Model model) {
//        return "hello";
//    }


    @RequestMapping(value = "/menu", method = RequestMethod.GET)
    public String menu(Model model) {
        List<Pizza> pizzas =  pizzaService.findAll();
        model.addAttribute("pizzas", pizzas);
        return "menu";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String newPizza(Model model) {
        Pizza.PizzaType[] types = Pizza.PizzaType.values();
        model.addAttribute("types", types);
        return "new_pizza";
    }

    @RequestMapping(value = "/addnew", method = RequestMethod.POST)
    public String addNewPizza(@ModelAttribute(value = "pizza") Pizza pizza) {
        System.out.println(pizza);
        pizzaService.save(pizza);
        return "redirect:menu";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editPizza(@RequestParam("id") Long pizzaId, Model model) {
        Pizza pizza = pizzaService.find(pizzaId);
        Pizza.PizzaType[] types = Pizza.PizzaType.values();
        model.addAttribute("types", types);
        model.addAttribute("pizza", pizza);
        return "new_pizza";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deletePizza(@RequestParam("id") Long pizzaId) {
        Pizza pizza = pizzaService.find(pizzaId);
        pizzaService.delete(pizza);
        return "redirect:menu";
    }

}

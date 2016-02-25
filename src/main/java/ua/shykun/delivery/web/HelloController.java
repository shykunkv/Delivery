package ua.shykun.delivery.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.shykun.delivery.domain.Pizza;
import ua.shykun.delivery.service.PizzaService;

import java.util.List;


@Controller
public class HelloController {

    @Autowired
    private PizzaService pizzaService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(Model model) {
        model.addAttribute("message", "Hello world");
        return "hello";
    }

    @RequestMapping(value = "/menu", method = RequestMethod.GET)
    public String menu(Model model) {
        List<Pizza> pizzas =  pizzaService.findAll();
        model.addAttribute("pizzas", pizzas);
        return "menu";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String newPizza(Model model) {
        return "new_pizza";
    }

    @RequestMapping(value = "/pizza", method = RequestMethod.GET)
    @ResponseBody
    public String viewPizzaById(Model model, @RequestParam(name = "id") Long pizzaId) {
        Pizza pizza = pizzaService.find(pizzaId);
        return pizza.toString();
    }

    @RequestMapping(value = "/addnew", method = RequestMethod.POST)
    public String addNewPizza(@ModelAttribute Pizza pizza) {
        pizzaService.save(pizza);
        return "redirect:menu";
    }
}

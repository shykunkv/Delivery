package ua.shykun.delivery;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.shykun.delivery.repository.PizzaRepository;

public class SpringDeliveryApp {

    public static void main(String... args) {
        ConfigurableApplicationContext applicationContext
                = new ClassPathXmlApplicationContext("applicationContext.xml");

        PizzaRepository pizzaRepository = (PizzaRepository) applicationContext.getBean("pizzaRepo");
        System.out.println(pizzaRepository.find(1));


    }

}

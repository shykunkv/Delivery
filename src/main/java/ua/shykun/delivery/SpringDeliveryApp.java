package ua.shykun.delivery;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.shykun.delivery.domain.Customer;
import ua.shykun.delivery.repository.OrderRepository;
import ua.shykun.delivery.repository.PizzaRepository;
import ua.shykun.delivery.service.OrderService;

public class SpringDeliveryApp {

    public static void main(String... args) {
        ConfigurableApplicationContext repositoryContext
                = new ClassPathXmlApplicationContext("repositoryContext.xml");


        ConfigurableApplicationContext applicationContext
                = new ClassPathXmlApplicationContext(new String[] {"applicationContext.xml"}, repositoryContext);


        //System.out.println(applicationContext.getParent());

        Customer customer = applicationContext.getBean("customer", Customer.class);

        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
        System.out.println(orderService.placeNewOrder(customer, new Integer[] {1, 2, 3}, new Integer[] {2, 2, 1}));

//      Customer newCustomer = applicationContext.getBean("newCustomer", Customer.class);
//      System.out.println(newCustomer.getAddresses());

        repositoryContext.close();
        applicationContext.close();
    }

}

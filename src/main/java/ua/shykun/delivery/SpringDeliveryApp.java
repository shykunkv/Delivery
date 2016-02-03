package ua.shykun.delivery;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.shykun.delivery.domain.Order;
import ua.shykun.delivery.domain.orderCost.DiscountManager;
import ua.shykun.delivery.service.OrderService;

public class SpringDeliveryApp {

    public static void main(String... args) {
        ConfigurableApplicationContext repositoryContext
                = new ClassPathXmlApplicationContext("repositoryContext.xml");


        ConfigurableApplicationContext applicationContext
                = new ClassPathXmlApplicationContext(new String[] {"applicationContext.xml"}, repositoryContext);


        OrderService orderService = applicationContext.getBean(OrderService.class);
        DiscountManager discountManager = applicationContext.getBean(DiscountManager.class);

        Order order = orderService.placeNewOrder(1, new Integer[] {1, 2, 3, 1, 2}, discountManager);

        //System.out.println(order);
        //System.out.println(order.getTotalPrice());

//        for(String s: applicationContext.getBeanDefinitionNames()) {
//            System.out.println(s);
//        }

        //System.out.println(applicationContext.getBean("pizzaFactoryBean"));

        System.out.println(applicationContext.getBean("newCustomer"));

        repositoryContext.close();
        applicationContext.close();
    }

}

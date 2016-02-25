package ua.shykun.delivery;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.shykun.delivery.domain.AccumulativeCard;
import ua.shykun.delivery.domain.Address;
import ua.shykun.delivery.domain.Customer;
import ua.shykun.delivery.domain.Pizza;
import ua.shykun.delivery.service.AddressService;
import ua.shykun.delivery.service.CustomerService;
import ua.shykun.delivery.service.OrderService;
import ua.shykun.delivery.service.PizzaService;

import java.util.ArrayList;
import java.util.List;

public class SpringDeliveryApp {

    public static void main(String... args) {
        ConfigurableApplicationContext repositoryContext
                = new ClassPathXmlApplicationContext("repositoryContext.xml");
        //repositoryContext.getEnvironment().setActiveProfiles("prod");
        repositoryContext.refresh();


        ConfigurableApplicationContext applicationContext
                = new ClassPathXmlApplicationContext(new String[] {"applicationContext.xml"}, repositoryContext);



        //AddressService addressService = applicationContext.getBean(AddressService.class);
//        Address address1 = new Address("0", "Sechenova", "Kyiv");
//        Address address2 = new Address("1", "Sechenova", "Kyiv");
//        List<Address> addressList = new ArrayList<Address>();
//        addressList.add(address1);
//        addressList.add(address2);
        //addressService.save(address);

        PizzaService pizzaService = applicationContext.getBean(PizzaService.class);
//        pizzaService.save(new Pizza("Meat pizza", 10.0, Pizza.PizzaType.MEAT));
//        pizzaService.save(new Pizza("Vegetable pizza", 20.0, Pizza.PizzaType.VEGETARIAN));
//        pizzaService.save(new Pizza("Cheese pizza", 30.0, Pizza.PizzaType.CHEESE));
//        pizzaService.save(new Pizza("Sea pizza", 40.0, Pizza.PizzaType.SEA));

//        CustomerService customerService = applicationContext.getBean(CustomerService.class);
//
//        Customer customer = new Customer("Kostiantyn");
//        AccumulativeCard accumulativeCard = new AccumulativeCard();
//        customer.setAccumulativeCard(accumulativeCard);
//        customer.setAddresses(addressList);
//
//        customerService.register(customer);




        repositoryContext.close();
        applicationContext.close();
    }

}

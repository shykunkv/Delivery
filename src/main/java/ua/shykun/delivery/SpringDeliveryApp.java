package ua.shykun.delivery;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.shykun.delivery.domain.*;
import ua.shykun.delivery.service.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SpringDeliveryApp {

    public static void main(String... args) {
        ConfigurableApplicationContext repositoryContext
                = new ClassPathXmlApplicationContext("repositoryContext.xml");
        //repositoryContext.getEnvironment().setActiveProfiles("prod");
        repositoryContext.refresh();


        ConfigurableApplicationContext applicationContext
                = new ClassPathXmlApplicationContext(new String[] {"applicationContext.xml"}, repositoryContext);



        //AddressService addressService = applicationContext.getBean(AddressService.class);
        Address address1 = new Address("1", "TEST", "Test");
//        Address address2 = new Address("1", "Sechenova", "Kyiv");
        List<Address> addressList = new ArrayList<Address>();
        addressList.add(address1);
//        addressList.add(address2);
        //addressService.save(address);

//        PizzaService pizzaService = applicationContext.getBean(PizzaService.class);
//        pizzaService.save(new Pizza("Meat pizza", 10.0, Pizza.PizzaType.MEAT));
//        pizzaService.save(new Pizza("Vegetable pizza", 20.0, Pizza.PizzaType.VEGETARIAN));
//        pizzaService.save(new Pizza("Cheese pizza", 30.0, Pizza.PizzaType.CHEESE));
//        pizzaService.save(new Pizza("Sea pizza", 40.0, Pizza.PizzaType.SEA));

//        CustomerService customerService = applicationContext.getBean(CustomerService.class);
//
        Customer customer = new Customer("TEST");
        AccumulativeCard accumulativeCard = new AccumulativeCard();
        customer.setAccumulativeCard(accumulativeCard);
        customer.setAddresses(addressList);
//
//        customerService.register(customer);


//        Set<UserRole> roles = new HashSet<>();
//        roles.add(UserRole.ROLE_ADMIN);
//        roles.add(UserRole.ROLE_USER);
//
//        User user = new User();
//        user.setLogin("admin9");
//        user.setCustomer(customer);
//        user.setUserRoles(roles);
//        user.setPassword("admin9");
//
//        UserService userService = applicationContext.getBean(UserService.class);
//        userService.save(user);

        repositoryContext.close();
        applicationContext.close();
    }

}

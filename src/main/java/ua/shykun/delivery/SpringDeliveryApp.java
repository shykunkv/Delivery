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
        repositoryContext.refresh();


        ConfigurableApplicationContext applicationContext
                = new ClassPathXmlApplicationContext(new String[] {"applicationContext.xml"}, repositoryContext);

        repositoryContext.close();
        applicationContext.close();
    }

}

package ua.shykun.delivery.repository.impl.inmem;

import org.springframework.stereotype.Repository;
import ua.shykun.delivery.domain.Customer;
import ua.shykun.delivery.repository.CustomerRepository;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

public class InMemCustomerRepository implements CustomerRepository {

    private final static Map<Integer, Customer> customers = new HashMap<>();

    @PostConstruct
    public void init() {
        customers.put(1, new Customer("Kostiantyn Shykun"));
        customers.put(2, new Customer("Bob Marley"));
    }

    @Override
    public Customer save(Customer customer) {
        return null;
    }

    @Override
    public Customer find(Long id) {
        return null;
    }
}

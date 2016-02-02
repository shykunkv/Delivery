package ua.shykun.delivery.repository.impl;

import org.springframework.stereotype.Repository;
import ua.shykun.delivery.domain.Customer;
import ua.shykun.delivery.repository.CustomerRepository;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Repository
public class InMemCustomerRepository implements CustomerRepository {

    private final static Map<Integer, Customer> customers = new HashMap<>();

    @PostConstruct
    public void init() {
        customers.put(1, new Customer("Kostiantyn Shykun"));
        customers.put(2, new Customer("Bob Marley"));
    }

    @Override
    public Customer find(int id) {
        return customers.get(id);
    }

    @Override
    public void save(Customer customer) {
        customers.put(null, customer);
    }

    @Override
    public Customer findByName(String name) {
        for (Map.Entry<Integer, Customer> entry: customers.entrySet()) {
            Customer curCustomer = entry.getValue();
            if (curCustomer.getName().equals(name)) {
                return curCustomer;
            }
        }

        return null;
    }
}

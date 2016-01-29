package ua.shykun.delivery.repository.impl;

import ua.shykun.delivery.domain.Customer;
import ua.shykun.delivery.repository.CustomerRepository;

import java.util.HashMap;
import java.util.Map;

public class InMemCustomerRepository implements CustomerRepository {

    private final static Map<Integer, Customer> customers = new HashMap<>();

    public void init() {
        customers.put(1, new Customer("Kostiantyn Shykun"));
        customers.put(2, new Customer("Bob Marley"));
    }

    @Override
    public Customer find(int id) {
        return customers.get(id);
    }

}

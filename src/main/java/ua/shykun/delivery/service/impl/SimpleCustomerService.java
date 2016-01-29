package ua.shykun.delivery.service.impl;

import ua.shykun.delivery.domain.Customer;
import ua.shykun.delivery.repository.CustomerRepository;
import ua.shykun.delivery.service.CustomerService;


public class SimpleCustomerService implements CustomerService {
    private final CustomerRepository customerRepository;

    public SimpleCustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer find(Integer id) {
        return customerRepository.find(id);
    }
}

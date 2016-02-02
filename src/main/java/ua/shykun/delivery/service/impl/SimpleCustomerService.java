package ua.shykun.delivery.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.shykun.delivery.domain.Customer;
import ua.shykun.delivery.repository.CustomerRepository;
import ua.shykun.delivery.service.CustomerService;

@Service
public class SimpleCustomerService implements CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public SimpleCustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer find(Integer id) {
        return customerRepository.find(id);
    }

    @Override
    public void register(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Customer findByName(String customerName) {
        return customerRepository.findByName(customerName);
    }
}

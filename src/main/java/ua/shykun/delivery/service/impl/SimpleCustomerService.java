package ua.shykun.delivery.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
    public Customer find(Long id) {
        return customerRepository.find(id);
    }

    @Override
    @Transactional
    public void register(Customer customer) {
        customerRepository.save(customer);
    }

}

package ua.shykun.delivery.service;

import ua.shykun.delivery.domain.Customer;

public interface CustomerService {
    Customer find(Long id);
    void register(Customer customer);
}

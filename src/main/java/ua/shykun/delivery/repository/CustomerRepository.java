package ua.shykun.delivery.repository;

import ua.shykun.delivery.domain.Customer;

public interface CustomerRepository {
    Customer find(Long id);
    Customer save(Customer customer);
}

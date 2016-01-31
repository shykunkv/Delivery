package ua.shykun.delivery.service;
import ua.shykun.delivery.domain.Customer;

public interface CustomerService {
    Customer find(Integer id);
    Customer create(String name);
}

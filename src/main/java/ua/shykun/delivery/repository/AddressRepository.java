package ua.shykun.delivery.repository;


import ua.shykun.delivery.domain.Address;

public interface AddressRepository {
    Address find(int id);
}

package ua.shykun.delivery.repository;


import ua.shykun.delivery.domain.Address;

public interface AddressRepository {
    Address find(Long id);
    Address save(Address address);
}

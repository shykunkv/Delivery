package ua.shykun.delivery.service;

import ua.shykun.delivery.domain.Address;

public interface AddressService {
    Address find(Long id);
    Address save(Address address);
}

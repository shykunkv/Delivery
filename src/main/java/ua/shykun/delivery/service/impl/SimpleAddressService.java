package ua.shykun.delivery.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.shykun.delivery.domain.Address;
import ua.shykun.delivery.repository.AddressRepository;
import ua.shykun.delivery.service.AddressService;

@Service
public class SimpleAddressService implements AddressService {

    private final AddressRepository addressRepository;

    @Autowired
    public  SimpleAddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address find(Integer id) {
        return addressRepository.find(id);
    }
}

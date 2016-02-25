package ua.shykun.delivery.repository.impl.inmem;

import org.springframework.stereotype.Repository;
import ua.shykun.delivery.domain.Address;
import ua.shykun.delivery.repository.AddressRepository;

import java.util.HashMap;
import java.util.Map;

public class InMemAddressRepository implements AddressRepository {

    private static final Map<Integer, Address> addresses = new HashMap<>();


    public void init() {
        addresses.put(1, new Address("6", "Sechenova", "Kyiv"));
        addresses.put(2, new Address("7", "Peremogy", "Kyiv"));
        addresses.put(3, new Address("22", "Khreschatyk", "Kyiv"));
    }

    @Override
    public Address find(Long id) {
        return addresses.get(id);
    }

    @Override
    public Address save(Address address) {
        return null;
    }


}

package ua.shykun.delivery.repository.impl.jpa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.shykun.delivery.domain.Address;
import ua.shykun.delivery.repository.AddressRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class JPAAddressRepository implements AddressRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Address find(Long id) {
        return em.find(Address.class, id);
    }

    @Override
    public Address save(Address address) {
        if (address.getId() == null) {
            em.persist(address);
        } else {
            em.merge(address);
        }

        return address;
    }
}

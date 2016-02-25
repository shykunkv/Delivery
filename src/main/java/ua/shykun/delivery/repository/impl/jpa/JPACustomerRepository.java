package ua.shykun.delivery.repository.impl.jpa;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.shykun.delivery.domain.Customer;
import ua.shykun.delivery.repository.CustomerRepository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Repository
public class JPACustomerRepository implements CustomerRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Customer find(Long id) {
        return em.find(Customer.class, id);
    }

    @Override
    public Customer save(Customer customer) {

        if (customer.getId() == null) {
            em.persist(customer);
        } else {
            em.merge(customer);
        }

        return customer;
    }
}

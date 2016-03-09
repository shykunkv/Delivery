package ua.shykun.delivery.repository.impl.jpa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.shykun.delivery.domain.User;
import ua.shykun.delivery.repository.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class JPAUserRepository implements UserRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public User save(User user) {
        if (user.getId() == null) {
            em.persist(user);
        } else {
            em.merge(user);
        }

        return user;
    }


    @Override
    public User find(Long id) {
        return em.find(User.class, id);
    }

    @Override
    public List<User> findAll() {
        return em.createQuery("FROM User", User.class).getResultList();
    }

    @Override
    public User findByLogin(String login) {
        TypedQuery<User> query = em.createQuery(
                "FROM User AS user WHERE user.login=:login", User.class);
        query.setParameter("login", login);
        List<User> result = query.getResultList();
        return result.isEmpty() ? null : result.get(0);
    }


}

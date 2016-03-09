package ua.shykun.delivery.service;


import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ua.shykun.delivery.domain.Pizza;
import ua.shykun.delivery.service.PizzaService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.assertNotNull;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:/applicationContext.xml",
        "classpath:/repositoryContext.xml"
})
@ActiveProfiles(profiles = "prod")
public class SimplePizzaServiceIT extends AbstractTransactionalJUnit4SpringContextTests {


    @Autowired
    private PizzaService pizzaService;

    @PersistenceContext
    private EntityManager em;


//    @Test
//    public void testFind() throws Exception {
//        System.out.println("FIND");
////        final String sql = "INSERT INTO " +
//                           "pizzas (pizza_name, pizza_price, pizza_type)" +
//                           "VALUES ('NAME', '100.0', 'MEAT')";
//
//        KeyHolder keyHolder = new GeneratedKeyHolder();
//
//        jdbcTemplate.update(
//                new PreparedStatementCreator() {
//                    @Override
//                    public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
//                        return connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//                    }
//                },
//                keyHolder);
//
//        Long id = keyHolder.getKey().longValue();

//        Pizza pizza = new Pizza("TESTNAME", 100.0, Pizza.PizzaType.MEAT);
//        Pizza result = pizzaService.save(pizza);
//        em.flush();
//
//        assertNotNull(pizzaService.find(result.getId()));
//
//    }

//    @Test
//    public void testSave() throws Exception {
//        System.out.println("SAVE");
//        Pizza pizza = new Pizza("TESTNAME", 100.0, Pizza.PizzaType.MEAT);
//
//        Pizza result = pizzaService.save(pizza);
//        em.flush();
//        System.out.println(result.getId());
//        assertNotNull(pizza.getId());
//    }
}
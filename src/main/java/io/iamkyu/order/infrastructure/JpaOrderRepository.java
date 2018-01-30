package io.iamkyu.order.infrastructure;

import io.iamkyu.order.domain.Order;
import io.iamkyu.order.domain.OrderNo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Kj Nam
 */
@Repository
public class JpaOrderRepository implements OrderRepository {

    @PersistenceContext private EntityManager entityManager;
    
    @Override
    public Order findById(OrderNo id) {
        return entityManager.find(Order.class, id);
    }

    @Override
    public void save(Order order) {
        entityManager.persist(order);
    }
}

package io.iamkyu.order.infrastructure;

import io.iamkyu.order.domain.Order;
import io.iamkyu.order.domain.OrderNo;

/**
 * @author Kj Nam
 */
public interface OrderRepository {
    Order findById(OrderNo no);

    void save(Order order);
}

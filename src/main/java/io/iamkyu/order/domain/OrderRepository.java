package io.iamkyu.order.domain;

/**
 * @author Kj Nam
 */
public interface OrderRepository {
    Order findById(OrderNo no);

    void save(Order order);
}

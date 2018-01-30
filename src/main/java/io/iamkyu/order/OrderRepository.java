package io.iamkyu.order;

/**
 * @author Kj Nam
 */
public interface OrderRepository {
    Order findById(OrderNo no);

    void save(Order order);
}

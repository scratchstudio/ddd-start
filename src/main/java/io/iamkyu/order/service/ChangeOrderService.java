package io.iamkyu.order.service;

import io.iamkyu.order.domain.Order;
import io.iamkyu.order.domain.OrderNo;
import io.iamkyu.order.domain.OrderRepository;
import io.iamkyu.order.domain.ShippingInfo;
import io.iamkyu.order.exception.OrderNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ChangeOrderService {

    private OrderRepository orderRepository;

    public ChangeOrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Transactional
    public void changeShippingInfo(OrderNo no, ShippingInfo newShippingInfo) throws OrderNotFoundException {
        Order order = orderRepository.findById(no);
        if (order == null) {
            throw new OrderNotFoundException();
        }
        order.changeShippingInfo(newShippingInfo);
    }
}

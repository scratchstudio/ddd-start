package io.iamkyu.order.domain;

/**
 * @author Kj Nam
 */
public enum OrderState {
    PAYMENT_WAITING, 
    PREPARING,
    SHIPPED,
    DELIVERING,
    DELIVERY_COMPLETED,
    CANCELED
}

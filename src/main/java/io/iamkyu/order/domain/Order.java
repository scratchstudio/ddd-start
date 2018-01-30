package io.iamkyu.order.domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

/**
 * @author Kj Nam
 */
@Entity
@Table(name = "purchase_order")
@Access(AccessType.FIELD)
public class Order {
    private OrderNo id;
    private List<OrderLine> orderLines;
    private Money totalAmount;
    private ShippingInfo shippingInfo;
    private OrderState state;

    public Order(List<OrderLine> orderLines, ShippingInfo shippingInfo) {
        setOrderLines(orderLines);
        setShippingInfo(shippingInfo);
    }

    public void changeShippingInfo(ShippingInfo newShippingInfo) {
        verifyNotYetShipped();
        setShippingInfo(newShippingInfo);
    }

    public void cancle() {
        verifyNotYetShipped();
        this.state = OrderState.CANCELED;
    }

    private void verifyNotYetShipped() {
        if (state != OrderState.PAYMENT_WAITING && state != OrderState.PREPARING) {
            throw new IllegalStateException("already shipped");
        }
    }

    private void setOrderLines(List<OrderLine> orderLines) {
        verifyAtLeastOneOrMoreOrderLines(orderLines);
        this.orderLines = orderLines;
        calculateTotalAmounts();
    }
    
    private void setShippingInfo(ShippingInfo shippingInfo) {
        if (shippingInfo == null) {
            throw new IllegalArgumentException("No shippingInfo");
        }
        this.shippingInfo = shippingInfo;
    }

    private void verifyAtLeastOneOrMoreOrderLines(List<OrderLine> orderLines) {
        if (orderLines == null || orderLines.isEmpty()) {
            throw new IllegalStateException("No orderLines");
        }
    }
    
    private void calculateTotalAmounts() {
        this.totalAmount = new Money(orderLines.stream()
                .mapToInt(x -> x.getPrice()
                        .multiply(x.getQuantity()).getValue())
                .sum());
    }
    
    // TODO equals and hash
}

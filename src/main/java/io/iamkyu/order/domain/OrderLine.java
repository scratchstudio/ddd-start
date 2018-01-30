package io.iamkyu.order.domain;

/**
 * @author Kj Nam
 */
public class OrderLine {
    
    private Product product;
    
    private Money price;

    private int quantity;

    private Money amounts;

    public OrderLine(Product product, Money price, int quantity) {
        this.product = product;
        this.price = price;
        this.quantity = quantity;
        this.amounts = calculateAmount();
    }

    private Money calculateAmount() {
        return price.multiply(quantity);
    }

    public Product getProduct() {
        return product;
    }

    public Money getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public Money getAmounts() {
        return amounts;
    }
}

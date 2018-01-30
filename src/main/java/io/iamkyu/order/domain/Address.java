package io.iamkyu.order.domain;

/**
 * @author Kj Nam
 */
public class Address {
    private String shippingAddress1;
    private String shippingAddress2;
    private String shippingZipcode;

    public Address(String shippingAddress1, String shippingAddress2, String shippingZipcode) {
        this.shippingAddress1 = shippingAddress1;
        this.shippingAddress2 = shippingAddress2;
        this.shippingZipcode = shippingZipcode;
    }

    public String getShippingAddress1() {
        return shippingAddress1;
    }

    public String getShippingAddress2() {
        return shippingAddress2;
    }

    public String getShippingZipcode() {
        return shippingZipcode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (shippingAddress1 != null ? !shippingAddress1.equals(address.shippingAddress1) : address.shippingAddress1 != null)
            return false;
        if (shippingAddress2 != null ? !shippingAddress2.equals(address.shippingAddress2) : address.shippingAddress2 != null)
            return false;
        return shippingZipcode != null ? shippingZipcode.equals(address.shippingZipcode) : address.shippingZipcode == null;
    }

    @Override
    public int hashCode() {
        int result = shippingAddress1 != null ? shippingAddress1.hashCode() : 0;
        result = 31 * result + (shippingAddress2 != null ? shippingAddress2.hashCode() : 0);
        result = 31 * result + (shippingZipcode != null ? shippingZipcode.hashCode() : 0);
        return result;
    }
}

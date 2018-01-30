package io.iamkyu.order.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author Kj Nam
 */
@Embeddable
public class Receiver {
    
    @Column(name = "receiver_name")
    private String name;

    @Column(name = "receiver_phone")
    private String phoneNumber;

    protected Receiver() {
        // for JPA
    }

    public Receiver(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Receiver receiver = (Receiver) o;

        if (name != null ? !name.equals(receiver.name) : receiver.name != null) return false;
        return phoneNumber != null ? phoneNumber.equals(receiver.phoneNumber) : receiver.phoneNumber == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        return result;
    }
}

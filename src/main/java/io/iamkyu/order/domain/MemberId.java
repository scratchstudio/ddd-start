package io.iamkyu.order.domain;

import java.io.Serializable;

public class MemberId implements Serializable {
    
    private String id;

    public MemberId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}

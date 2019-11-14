package com.yarmack.domain;

import java.math.BigDecimal;

public class Item {

    private final String id;
    private final String name;
    private final BigDecimal price;

    public Item(final String id, final String name, final BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }
}

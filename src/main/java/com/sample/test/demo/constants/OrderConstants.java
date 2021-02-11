package com.sample.test.demo.constants;

public enum OrderConstants {
    MESSAGE_SUCCESSFUL_ORDER("Thank you for your order!"),
    MESSAGE_NO_SELECT_ERROR("Missing name Missing phone number"),
    DDL_PIZZA1_DEFAULT("Choose Pizza"),
    DDL_PIZZA_TOP1_DEFAULT("Choose a Toppings 1"),
    DDL_PIZZA_TOP2_DEFAULT("Choose a Toppings 1"),
    QTY_MIN_PIZZA("1"),
    QTY_CHARACTER("CHAR"),
    QTY_MAX_PIZZA("99999"),
    QTY_RAND_QTY("345"),
    QTY_NO_PRICE("0"),
    MESSAGE_SUCCESSFUL_MASHROOM_OLIVES_NO_TOPPING("Thank you for your order! TOTAL: 67493.25 Small 6 Slices - no toppings"),
    QTY_NO_PIZZA("0");

    private String displayName;

    private OrderConstants(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}

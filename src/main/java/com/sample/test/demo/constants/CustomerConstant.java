package com.sample.test.demo.constants;

public enum CustomerConstant {
        CUSTOMER_NAME("Clint Eastwood"),
        CUSTOMER_PHONE("+1 909-545-8200"),
        CUSTOMER_EMAIL("Clint.eastwood@yahoo.com");
        private String displayName;
        private double cost;

        private CustomerConstant(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }

        public double getCost() {
            return cost;
        }
}

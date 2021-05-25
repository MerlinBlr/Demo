package com.fortech.demo.util;

public enum RetailerName {
    RET_A("RetA", 5),
    RET_B("RetB", 8);

    public final String retailerName;
    public final Integer stockLevel;

    RetailerName(String retailerName, Integer stockLevel) {
        this.retailerName = retailerName;
        this.stockLevel = stockLevel;
    }

    public Integer getStockLevel() {
        return stockLevel;
    }

    public String getRetailerName() {
        return retailerName;
    }
}

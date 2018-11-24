package com.mahull.zeus.domain.advertiser;

public enum Category {

    OTHER("Other"),
    ADULT("Adult"),
    GLAMOUR("Glamour"),
    DATING("Dating"),
    CONTENT("Content");

    private final String type;

    Category(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

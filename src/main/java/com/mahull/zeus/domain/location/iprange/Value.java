package com.mahull.zeus.domain.location.iprange;

import com.mahull.zeus.domain.location.GeoIPLocation;

public class Value {
    private final Key key;
    private final GeoIPLocation value;
    public Value(Key key, GeoIPLocation value) {
        super();
        this.key = key;
        this.value = value;
    }
    public Key getKey() {
        return key;
    }
    public GeoIPLocation getValue() {
        return value;
    }
}

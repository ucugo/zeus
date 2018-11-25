package com.mahull.zeus.domain.location.iprange;

import com.mahull.zeus.domain.location.GeoIpLocation;

public class Value {
    private final Key key;
    private final GeoIpLocation value;
    public Value(Key key, GeoIpLocation value) {
        super();
        this.key = key;
        this.value = value;
    }
    public Key getKey() {
        return key;
    }
    public GeoIpLocation getValue() {
        return value;
    }
}

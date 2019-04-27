package com.mahull.zeus.dao.entity.location.iprange;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class KeyIPAddress extends Key {

    private final long address;
    public KeyIPAddress(String ipAddress) throws UnknownHostException {
        super(ipAddress);
        this.address=AbstractDatabase.convertATON(InetAddress.getByName(ipAddress));
    }
    public KeyIPAddress(InetAddress ipAddress){
        super(ipAddress.getAddress()[0] & 0xff);
        this.address=AbstractDatabase.convertATON(ipAddress);
    }
    public long getAddress() {
        return address;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj == null){
            return false;
        }
        if(obj instanceof KeyIPAddress){
            KeyIPAddress other = (KeyIPAddress) obj;
            return this.address==other.address;
        }
        if(obj instanceof KeyRange){
            KeyRange other = (KeyRange) obj;
            return (other.getStartRange() <= this.address) && (other.getEndRange() >= this.address);
        }
        return false;
    }
}

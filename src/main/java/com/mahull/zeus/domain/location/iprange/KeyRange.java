package com.mahull.zeus.domain.location.iprange;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.util.SubnetUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class KeyRange extends Key {

    private static final Logger logger = LoggerFactory.getLogger(KeyRange.class);
    private final long startRange;
    private final long endRange;

    public KeyRange(int firstBlockHashCode, String ipSubnetRange) throws UnknownHostException {
        this(firstBlockHashCode, new SubnetUtils(ipSubnetRange).getInfo());
    }
    public KeyRange(int firstBlockHashCode, SubnetUtils.SubnetInfo info) throws UnknownHostException{
        this(firstBlockHashCode, info.getLowAddress(), info.getHighAddress());
    }
    public KeyRange(int firstBlockHashCode, String startIpAddress, String endIpAddress) throws UnknownHostException {
        super(firstBlockHashCode);
        VALIDATION:{
            new SubnetUtils(startIpAddress + "/1");
            new SubnetUtils(endIpAddress + "/1");
        }
        this.startRange=AbstractDatabase.convertATON(InetAddress.getByName(startIpAddress));
        this.endRange=AbstractDatabase.convertATON(InetAddress.getByName(endIpAddress));
        logger.debug("Created range startAddress:[{}] endAddress:[{}] startNum:[{}] endNum:[{}]",new Object[]{
                StringUtils.rightPad(startIpAddress, 15),
                StringUtils.rightPad(endIpAddress, 15),
                StringUtils.leftPad(""+this.startRange, 15),
                StringUtils.leftPad(""+this.endRange, 15),
        });
        if(this.startRange > this.endRange){
            throw new IllegalArgumentException("Start range cannot be greater than end range");
        }
    }
    public long getStartRange() {
        return startRange;
    }
    public long getEndRange() {
        return endRange;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj == null){
            return false;
        }
        if(obj instanceof KeyRange){
            KeyRange other = (KeyRange) obj;
            if (endRange != other.endRange){
                return false;
            }
            if (startRange != other.startRange){
                return false;
            }
            return true;
        }
        if(obj instanceof KeyIPAddress){
            KeyIPAddress other = (KeyIPAddress) obj;
            return (this.startRange <= other.getAddress()) && (this.endRange >= other.getAddress());
        }
        return false;
    }
}

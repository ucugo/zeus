package com.mahull.zeus.dao.entity.location.iprange;

import org.apache.commons.lang3.StringUtils;

public class Key{
    private final int firstBlock;
    protected Key(String ipAddress){
        String firstBlock = StringUtils.substringBefore(ipAddress, ".");
        this.firstBlock=Integer.valueOf(firstBlock);
    }
    public Key(int firstBlock){
        this.firstBlock=firstBlock;
    }
    @Override
    public int hashCode() {
        return this.firstBlock;
    }
}

package com.mahull.zeus.domain.location.iprange;

import com.mahull.zeus.domain.location.GeoIpLocation;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.util.SubnetUtils;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TimeZone;

public abstract class AbstractDatabase {

    private static final Logger logger = LoggerFactory.getLogger(AbstractDatabase.class);
    private HashMap<Key, Value> database=null;

    protected HashMap<Key, Value> createDatabaseFromInputStream(InputStream inputStream, boolean allowInvalidEntries) throws Exception, IOException, IllegalArgumentException{
        int lineCount=0;
        int successCount=0;
        int entryCount=0;
        int failCount=0;
        long startTime=System.nanoTime();
        HashMap<Key, Value> out = new HashMap<Key, Value>();
        HashMap<GeoIpLocation, GeoIpLocation> tmpCache=new HashMap<GeoIpLocation, GeoIpLocation>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line = null;
        while((line = reader.readLine())!= null){
            lineCount++;
            try{
                JSONObject jsonLine = new JSONObject(line);
                String ipAddressRange = jsonLine.optString("ipAddressRange");
                String startIpAddress = jsonLine.optString("startIpAddress");
                String endIpAddress = jsonLine.optString("endIpAddress");

                if(StringUtils.isBlank(ipAddressRange) && (StringUtils.isBlank(startIpAddress)||StringUtils.isBlank(endIpAddress))){
                    throw new IllegalArgumentException("Invalid IP address range.  No IP set");
                }
                if(StringUtils.isNotBlank(ipAddressRange) && (StringUtils.isNotBlank(startIpAddress)||StringUtils.isNotBlank(endIpAddress))){
                    throw new IllegalArgumentException("Invalid IP address range.  Both subnet and start/end ip set");
                }
                GeoIpLocation gL = new GeoIpLocation();
                gL.setCountryCode(jsonLine.optString("cc",null));
                gL.setCountryName(jsonLine.optString("country",null));
                gL.setRegion(jsonLine.optString("region",null));
                gL.setCity(jsonLine.optString("city",null));
                gL.setNetwork(jsonLine.optString("network",null));
                String tz = jsonLine.optString("timeZone",null);
                if(StringUtils.isNotBlank(tz)){
                    gL.setTimeZone(TimeZone.getTimeZone(tz));
                }
                GeoIpLocation gL2 = tmpCache.get(gL);
                if(gL2 == null){
                    tmpCache.put(gL, gL);
                    gL2=gL;
                }
                Integer[] firstBlocks;
                if(StringUtils.isNotBlank(ipAddressRange)){
                    firstBlocks = getAllUniqueFirstBlocks(ipAddressRange);
                } else {
                    firstBlocks = getAllUniqueFirstBlocks(startIpAddress, endIpAddress);
                }
                for(int firstBlock : firstBlocks){
                    Value value;
                    if(StringUtils.isNotBlank(ipAddressRange)){
                        value = new Value(new KeyRange(firstBlock, ipAddressRange), gL2);
                    } else {
                        value = new Value(new KeyRange(firstBlock, startIpAddress, endIpAddress), gL2);
                    }
                    out.put(value.getKey(), value);
                    entryCount++;
                }
                successCount++;
            }catch (Throwable e) {
                if(!allowInvalidEntries){
                    if(e instanceof IllegalArgumentException){
                        throw (IllegalArgumentException)e;
                    }
                    if(e instanceof IOException){
                        throw (IOException)e;
                    }
                    throw new Exception(e);
                }
                logger.warn("Error while loading IPRange database.  Message:[{}] Type:[{}]",e.getMessage(),e.getClass().getName());
                failCount++;
            }
        }
        startTime = System.nanoTime()-startTime;
        logger.info("Finnished Updating IPRange Database in [{}]ns.  Total Lines:[{}] Entries:[{}] Successful:[{}] Failed:[{}] ",
                new Object[]{startTime,lineCount,entryCount,successCount,failCount}
        );
        return out;
    }
    public boolean isReady(){
        return this.database != null;
    }
    public boolean isEmpty(){
        return this.database == null || this.database.isEmpty();
    }
    public HashMap<Key, Value> query(){
        return this.database;
    }




    public static Long convertATON(InetAddress address){
        long s1 = address.getAddress()[0] & 0xff;
        long s2 = address.getAddress()[1] & 0xff;
        long s3 = address.getAddress()[2] & 0xff;
        long s4 = address.getAddress()[3] & 0xff;
        return (16777216 * s1) + (65536 * s2) + (256 * s3) + s4;
    }
    public static Integer[] getAllUniqueFirstBlocks(String ipSubnetRange){
        SubnetUtils.SubnetInfo info = new SubnetUtils(ipSubnetRange).getInfo();
        return getAllUniqueFirstBlocks(info.getLowAddress(),info.getHighAddress());
    }
    public static Integer[] getAllUniqueFirstBlocks(String startIpAddress, String endIpAddress){
        Integer startFirstBlock	= Integer.valueOf(StringUtils.substringBefore(startIpAddress, "."));
        Integer endFirstBlock	= Integer.valueOf(StringUtils.substringBefore(endIpAddress, "."));
        if(startFirstBlock > endFirstBlock){
            throw new IllegalArgumentException("Start range is greater than end range");
        }
        List<Integer> out = new ArrayList<Integer>(255);
        for(int i = startFirstBlock ; i <= endFirstBlock ; i++){
            out.add(i);
        }
        return out.toArray(new Integer[0]);
    }

    public HashMap<Key, Value> getDatabase() {
        return database;
    }

    public void setDatabase(HashMap<Key, Value> database) {
        this.database = database;
    }

}

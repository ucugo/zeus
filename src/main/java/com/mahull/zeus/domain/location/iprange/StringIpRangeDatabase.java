package com.mahull.zeus.domain.location.iprange;

import com.mahull.zeus.domain.location.GeoIpLocation;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StringIpRangeDatabase extends AbstractDatabase {

    private static final Logger logger = LoggerFactory.getLogger(StringIpRangeDatabase.class);

    public StringIpRangeDatabase(String ipRanges, GeoIpLocation value) throws Exception{
        StringBuilder entries = new StringBuilder();
        String seperator = "";
        for(String entry : convertToDatabaseEntryList(ipRanges, value)){
            entries.append(seperator).append(entry);
            seperator="\n";
        }
        HashMap<Key, Value> database = createDatabaseFromInputStream(new ByteArrayInputStream(entries.toString().getBytes()),false);
        if(getDatabase() != null){
            getDatabase().clear();
        }
        setDatabase(database);
        logger.info("Updated database from String");
    }

    private List<String> convertToDatabaseEntryList(String raw, GeoIpLocation value){
        List<String> out = new ArrayList<String>();
        if(StringUtils.isBlank(raw)){
            return out;
        }
        raw = raw.replaceAll("\\s", ",");
        for(String rawRange : raw.split(",")){
            if(StringUtils.isBlank(rawRange)){
                continue;
            }
            if(rawRange.contains(":")){
                String[] rawRangeEntries = rawRange.split(":");
                out.add(convertStringEntryToDatabaseEntry(rawRangeEntries[0],rawRangeEntries[1], value));
            }else{
                out.add(convertStringEntryToDatabaseEntry(rawRange, value));
            }
        }
        return out;
    }
    private String convertStringEntryToDatabaseEntry(String entry, GeoIpLocation value){
        JSONObject out = new JSONObject();
        if(StringUtils.contains(entry, "/")){
            out.put("ipAddressRange", StringUtils.trim(entry));
        }else{
            out.put("startIpAddress", StringUtils.trim(entry));
            out.put("endIpAddress", StringUtils.trim(entry));
        }
        out.put("cc", value.getCountryCode());
        out.put("country", value.getCountryName());
        out.put("region", value.getRegion());
        out.put("city", value.getCity());
        out.put("network", value.getNetwork());
        if(value.getTimeZone() != null){
            out.put("timeZone", value.getTimeZone());
        }
        return out.toString();
    }
    private String convertStringEntryToDatabaseEntry(String startEntry, String endEntry, GeoIpLocation value){
        JSONObject out = new JSONObject();
        out.put("startIpAddress", StringUtils.trim(startEntry));
        out.put("endIpAddress", StringUtils.trim(endEntry));
        out.put("cc", value.getCountryCode());
        out.put("country", value.getCountryName());
        out.put("region", value.getRegion());
        out.put("city", value.getCity());
        out.put("network", value.getNetwork());
        if(value.getTimeZone() != null){
            out.put("timeZone", value.getTimeZone());
        }
        return out.toString();
    }
}

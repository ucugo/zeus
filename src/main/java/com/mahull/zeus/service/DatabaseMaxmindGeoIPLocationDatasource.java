package com.mahull.zeus.service;

import com.mahull.zeus.dao.entity.location.GeoIpLocation;
import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.InetAddress;
import java.util.TimeZone;

@Service
public class DatabaseMaxmindGeoIPLocationDatasource {

    private static final Logger logger = LoggerFactory.getLogger(DatabaseMaxmindGeoIPLocationDatasource.class);
    private Integer priority = 11;
    private Boolean enabled = true;
    private final DatabaseReader databaseCityReader;

    @Autowired
    public DatabaseMaxmindGeoIPLocationDatasource(DatabaseReader databaseCityReader) {
        this.databaseCityReader = databaseCityReader;
        System.out.println();
    }

    public GeoIpLocation getLocationFromDatabase(InetAddress inetAddress) throws IOException, GeoIp2Exception {
        final CityResponse city = this.databaseCityReader.city(inetAddress);
        GeoIpLocation out = new GeoIpLocation();
        out.setCountryCode(city.getCountry().getIsoCode());
        out.setCountryName(city.getCountry().getName());
        out.setCity(city.getCity().getName());
        out.setRegion(null);
        if(StringUtils.isNotEmpty(city.getCountry().getIsoCode()) && StringUtils.isNotEmpty(city.getLocation().getTimeZone())){
            out.setRegion(city.getLocation().getTimeZone());
            if(StringUtils.isNotBlank(city.getLocation().getTimeZone())){
                out.setTimeZone(TimeZone.getTimeZone(city.getLocation().getTimeZone()));
            }
        }
        return out;
    }
}

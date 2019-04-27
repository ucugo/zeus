package com.mahull.zeus.config;


import com.maxmind.geoip2.DatabaseReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.IOException;

@Configuration
public class GeoIpConfig {

    @Bean
    public DatabaseReader databaseCityReader(@Value("${geoip.database.city.file}") String databaseCity) throws IOException {
        return new DatabaseReader.Builder(new File(databaseCity)).build();
    }
}

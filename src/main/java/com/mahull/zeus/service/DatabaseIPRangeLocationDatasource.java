package com.mahull.zeus.service;

import com.mahull.zeus.repository.GeoIpLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class DatabaseIPRangeLocationDatasource {

    private Integer priority = 11;
    private Boolean enabled = true;
    private final GeoIpLocationRepository geoIpLocationRepository;

    private final String dataBaseFile;

    @Autowired
    public DatabaseIPRangeLocationDatasource(GeoIpLocationRepository geoIpLocationRepository, @Value("${geoip.database.file}") String dataBaseFile) {
        this.dataBaseFile = dataBaseFile;
        this.geoIpLocationRepository = geoIpLocationRepository;
    }
}

package com.mahull.zeus.service;

import com.mahull.zeus.dao.entity.location.iprange.AbstractDatabase;
import com.mahull.zeus.dao.entity.location.iprange.FileDatabase;
import com.mahull.zeus.dao.entity.location.iprange.Key;
import com.mahull.zeus.dao.repository.GeoIpLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.HashMap;

@Service
public class DatabaseIPRangeLocationDatasource {

    private Integer priority = 11;
    private Boolean enabled = true;
    private final GeoIpLocationRepository geoIpLocationRepository;
    private AbstractDatabase ipRangeDatabase;

    private final String dataBaseFile;

    @Autowired
    public DatabaseIPRangeLocationDatasource(GeoIpLocationRepository geoIpLocationRepository, @Value("${geoip.database.iprange.file}") String dataBaseFile) {
        this.dataBaseFile = dataBaseFile;
        this.geoIpLocationRepository = geoIpLocationRepository;

        ipRangeDatabase = new FileDatabase(new File(dataBaseFile));
        ipRangeDatabase.doUpdate();
        final HashMap<Key, com.mahull.zeus.dao.entity.location.iprange.Value> database = ipRangeDatabase.getDatabase();

        database.keySet().forEach(key -> System.out.println(key));

        System.out.println();
    }
}

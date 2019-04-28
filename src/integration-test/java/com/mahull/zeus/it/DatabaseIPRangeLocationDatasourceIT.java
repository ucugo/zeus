package com.mahull.zeus.it;

import org.junit.jupiter.api.Test;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringBootTest
@SpringJUnitConfig
@ActiveProfiles("integrationTest")
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class DatabaseIPRangeLocationDatasourceIT {

    @Test
    public void test() {
        System.out.println();
    }
}
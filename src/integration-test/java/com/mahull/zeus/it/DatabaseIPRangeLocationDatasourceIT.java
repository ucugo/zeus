package com.mahull.zeus.it;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringBootTest
@SpringJUnitConfig
@ActiveProfiles("integrationTest")
@ExtendWith(SpringExtension.class)
class DatabaseIPRangeLocationDatasourceIT {

    @Test
    public void test() {
        System.out.println();
    }
}
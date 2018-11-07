package com.linbit;

import org.apache.commons.dbcp2.BasicDataSource;
import org.flywaydb.core.Flyway;

public class FlywayTest {
    public static final String DATABASE_SCHEMA_NAME = "MY_SCHEMA";

    public static void main(String[] args) {
        BasicDataSource dataSource = new BasicDataSource();

        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres");
        dataSource.setUrl("jdbc:postgresql://172.17.0.2/postgres");

        Flyway flyway = new Flyway();
        flyway.setSchemas(DATABASE_SCHEMA_NAME);
        flyway.setDataSource(dataSource);
        flyway.setLocations("db.migration");

        flyway.migrate();
    }
}

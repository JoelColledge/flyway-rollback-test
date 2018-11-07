package db.migration;

import org.flywaydb.core.api.migration.jdbc.JdbcMigration;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class V1__Rollback_and_create_table implements JdbcMigration {
    @Override
    public void migrate(Connection connection) throws Exception {
        connection.rollback();
        try (PreparedStatement stmt = connection.prepareStatement("CREATE TABLE table_1(id INT PRIMARY KEY NOT NULL);"))
        {
            stmt.executeUpdate();
        }
    }
}

package ml.meajudadev.despesas.v1.database;

import java.sql.Connection;

public interface DatabaseService {
    public Connection getConnection();
}

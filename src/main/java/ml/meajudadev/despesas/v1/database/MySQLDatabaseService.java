package ml.meajudadev.despesas.v1.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Service
public class MySQLDatabaseService implements DatabaseService {
    @Autowired
    private DBConfig dbConfig;

    private final Connection connection;

    public MySQLDatabaseService() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.driver");
        var connectionString = String.format(
                "jdbc:mysql://%s/gestao_financeira?user=%s&password=%s",
                dbConfig.getUrl(),
                dbConfig.getUsername(),
                dbConfig.getPassword()
        );
        connection = DriverManager.getConnection(connectionString);
    }

    @Override
    public Connection getConnection() {
        return connection;
    }
}

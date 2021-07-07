package ml.meajudadev.api.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TransactionsRepository {
    @Autowired
    JdbcTemplate db;
}

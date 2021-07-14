package ml.meajudadev.api.repositories;

import ml.meajudadev.api.entities.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.Month;

@Repository
public class TransactionsRepository {
    @Autowired
    JdbcTemplate db;

    public void save(Transaction transaction) {
        transaction.setId(3L);
        transaction.setCreatedAt(LocalDate.of(2021, Month.JULY, 13));
        transaction.setUpdatedAt(LocalDate.of(2021, Month.JULY, 13));
    }
}

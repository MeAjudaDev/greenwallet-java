package ml.meajudadev.api.repositories;

import ml.meajudadev.api.entities.Transaction;
import ml.meajudadev.api.entities.enums.TransactionState;
import ml.meajudadev.api.entities.enums.TransactionType;
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

    public Transaction getById(Long id) {
        Transaction transaction = new Transaction();

        transaction.setId(3L);
        transaction.setCategoryId(1L);
        transaction.setUserId(1L);
        transaction.setDescription("Curso de JavaScript");
        transaction.setFixed(false);
        transaction.setState(TransactionState.ACTIVE);
        transaction.setType(TransactionType.EXPENSE);
        transaction.setValue(50D);
        transaction.setDueDate(LocalDate.of(2021, Month.JULY, 10));
        transaction.setCreatedAt(LocalDate.of(2021, Month.JULY, 13));
        transaction.setUpdatedAt(LocalDate.of(2021, Month.JULY, 13));

        return transaction;
    }
}

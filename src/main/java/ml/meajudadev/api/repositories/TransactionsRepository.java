package ml.meajudadev.api.repositories;

import ml.meajudadev.api.entities.Transaction;
import ml.meajudadev.api.entities.enums.TransactionState;
import ml.meajudadev.api.entities.enums.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.time.Month;

@Repository
public class TransactionsRepository {
    @Autowired
    JdbcTemplate db;

    public void save(Transaction transaction) {
        db.execute("""
                INSERT INTO transactions
                    user_id,
                    category_id,
                    description,
                    value,
                    is_fixed,
                    due_date,
                    type,
                    state
                ) VALUES (?, ?, ?, ?, ?, ?, ?, ?)
                """, (PreparedStatement ps) -> {
            ps.setLong(1, transaction.getUserId());
            ps.setLong(2, transaction.getCategoryId());
            ps.setString(3, transaction.getDescription());
            ps.setDouble(4, transaction.getValue());
            ps.setBoolean(5, transaction.isFixed());
            ps.setDate(6, transaction.getDueDate().);

            return ps.execute();
        });
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

package ml.meajudadev.api.repositories;

import ml.meajudadev.api.entities.Transaction;
import ml.meajudadev.api.entities.enums.TransactionState;
import ml.meajudadev.api.entities.enums.TransactionType;
import ml.meajudadev.api.v1.dto.ExpenseCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Repository
public class TransactionsRepository {
    @Autowired
    JdbcTemplate db;

    public void save(Transaction transaction) {
        db.execute("""
            INSERT INTO transactions (
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
            ps.setString(6, DateTimeFormatter.ISO_LOCAL_DATE.format(transaction.getDueDate()));
            ps.setString(7, String.valueOf(transaction.getType().label));
            ps.setString(8, String.valueOf(transaction.getState().label));
            return ps.execute();
        });
    }

    public Optional<Transaction> getById(Long id) {
        return db.query("SELECT * FROM transactions WHERE id = ?", (PreparedStatement ps) -> {
            ps.setLong(1, id);
        }, (ResultSet rs) -> {
            if (!rs.first())
                return Optional.empty();

            Transaction transaction = new Transaction(
                    rs.getLong("id"),
                    rs.getString("description"),
                    rs.getDouble("value"),
                    rs.getBoolean("is_fixed"),
                    LocalDate.parse(rs.getString("due_date"), DateTimeFormatter.ISO_LOCAL_DATE),
                    TransactionType.valueOf(rs.getString("type")),
                    TransactionState.valueOf(rs.getString("state")),
                    LocalDate.parse(rs.getString("updated_at"), DateTimeFormatter.ISO_LOCAL_DATE),
                    LocalDate.parse(rs.getString("created_at"), DateTimeFormatter.ISO_LOCAL_DATE),
                    rs.getLong("user_id"),
                    rs.getLong("category_id")
            );

            return Optional.of(transaction);
        });

    }
}

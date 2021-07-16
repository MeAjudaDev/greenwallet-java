package ml.meajudadev.api.repositories;

import ml.meajudadev.api.entities.Transaction;
import ml.meajudadev.api.entities.enums.TransactionState;
import ml.meajudadev.api.entities.enums.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Repository
public class TransactionsRepository {
    @Autowired
    JdbcTemplate db;

    public void save(Transaction transaction) {
        var holder = new GeneratedKeyHolder();
        db.update(connection -> {
            PreparedStatement ps = connection.prepareStatement("""
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
                    """, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setLong(1, transaction.getUserId());
            ps.setLong(2, transaction.getCategoryId());
            ps.setString(3, transaction.getDescription());
            ps.setDouble(4, transaction.getValue());
            ps.setBoolean(5, transaction.isFixed());
            ps.setString(6, DateTimeFormatter.ISO_LOCAL_DATE.format(transaction.getDueDate()));
            ps.setString(7, String.valueOf(transaction.getType().label));
            ps.setString(8, String.valueOf(transaction.getState().label));
            return ps;
        }, holder);

        Transaction saved = getById(Long.valueOf((int) holder.getKeys().get("id"))).get();
        transaction.setId(saved.getId());
        transaction.setCreatedAt(saved.getCreatedAt());
    }

    public Optional<Transaction> getById(Long id) {
        return db.query("SELECT * FROM transactions WHERE id = ?", (PreparedStatement ps) -> {
            ps.setLong(1, id);
        }, (ResultSet rs) -> {
            if (!rs.first())
                return Optional.empty();

            Transaction transaction = new Transaction()
                    .setId(rs.getLong("id"))
                    .setUserId(rs.getLong("user_id"))
                    .setCategoryId(rs.getLong("category_id"))
                    .setDescription(rs.getString("description"))
                    .setValue(rs.getDouble("value"))
                    .setFixed(rs.getBoolean("is_fixed"))
                    .setType(TransactionType.of(rs.getString("type").toCharArray()[0]))
                    .setState(TransactionState.of(rs.getString("state").toCharArray()[0]))
                    .setCreatedAt(LocalDate.parse(rs.getString("created_at"), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.nnnnnn")));

            String lastUpdatedAt = rs.getString("last_updated_at");
            if (lastUpdatedAt != null && !lastUpdatedAt.isEmpty() && !lastUpdatedAt.isBlank())
                transaction.setLastUpdatedAt(LocalDate.parse(lastUpdatedAt, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.nnnnnn")));

            String dueDate = rs.getString("due_date");
            if (dueDate != null && !dueDate.isEmpty() && !dueDate.isBlank())
                transaction.setDueDate(LocalDate.parse(dueDate, DateTimeFormatter.ISO_LOCAL_DATE));

            return Optional.of(transaction);
        });
    }
}

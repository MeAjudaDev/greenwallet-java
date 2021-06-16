package ml.meajudadev.api.repositories;

import ml.meajudadev.api.v1.dto.ExpenseCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;

@Repository
public class CategoriesRepository {
    @Autowired
    JdbcTemplate db;

    public void save(ExpenseCategoryDto category) {
        db.execute("""
            INSERT INTO categories (
                user_id,
                name,
                enabled,
                type
            ) VALUES (?, ?, ?, ?)
        """, (PreparedStatement ps) -> {
            ps.setLong(1, category.userId());
            ps.setString(2, category.name());
            ps.setBoolean(3, category.enabled());
            ps.setString(4, String.valueOf(category.type()));
            return ps.execute();
        });
    }

    public Optional<ExpenseCategoryDto> getById(long categoryId) {
        return db.query("SELECT * FROM categories WHERE id = ?", (PreparedStatement ps) -> {
            ps.setLong(1, categoryId);
        }, (ResultSet rs) -> {
            if (!rs.first())
                return Optional.empty();

            ExpenseCategoryDto expenseCategoryDto = new ExpenseCategoryDto(
                    rs.getLong("id"),
                    rs.getLong("user_id"),
                    rs.getString("name"),
                    rs.getBoolean("enabled"),
                    rs.getString("type").toCharArray()[0]
            );

            return Optional.of(expenseCategoryDto);
        });
    }
}

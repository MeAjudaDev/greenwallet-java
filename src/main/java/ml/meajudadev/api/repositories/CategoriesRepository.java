package ml.meajudadev.api.repositories;

import ml.meajudadev.api.v1.dto.ExpenseCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.PreparedStatement;
import java.util.Optional;

public class CategoriesRepository {
    @Autowired
    private JdbcTemplate db;

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
        return categories.stream().filter(x -> x.id() == categoryId).findFirst();
    }
}

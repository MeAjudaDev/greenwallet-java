package ml.meajudadev.despesas.v1.model;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

public record ExpenseModel(
        int id,
        int userId,
        String description,
        BigDecimal value,
        boolean isFixed,
        Calendar dueDate,
        List categoryIds
) {
}

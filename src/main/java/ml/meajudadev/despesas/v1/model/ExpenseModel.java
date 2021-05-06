package ml.meajudadev.despesas.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.Calendar;

public record ExpenseModel(
        @JsonProperty("id") int id,
        @JsonProperty("userId") int userId,
        @JsonProperty("categoryId") int categoryId,
        @JsonProperty("description") String description,
        @JsonProperty("value") BigDecimal value,
        @JsonProperty("isFixed") boolean isFixed,
        @JsonProperty("dueDate") Calendar dueDate,
        @JsonProperty("expenseType") char expenseType,
        @JsonProperty("expenseState") char expenseState
) {
}

package ml.meajudadev.despesas.v1.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ExpenseDto(
        @JsonProperty("id") int id,
        @JsonProperty("userId") int userId,
        @JsonProperty("categoryId") Integer categoryId,
        @JsonProperty("description") String description,
        @JsonProperty("value") BigDecimal value,
        @JsonProperty("isFixed") boolean isFixed,
        @JsonProperty("dueDate") LocalDate dueDate,
        @JsonProperty("expenseType") char expenseType,
        @JsonProperty("expenseState") char expenseState
) {
}

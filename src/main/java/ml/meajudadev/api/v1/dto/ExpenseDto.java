package ml.meajudadev.api.v1.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ExpenseDto(
        @JsonProperty("id") long id,
        @JsonProperty("userId") long userId,
        @JsonProperty("categoryId") long categoryId,
        @JsonProperty("description") String description,
        @JsonProperty("value") BigDecimal value,
        @JsonProperty("isFixed") boolean isFixed,
        @JsonProperty("dueDate") LocalDate dueDate,
        @JsonProperty("expenseType") char expenseType,
        @JsonProperty("expenseState") char expenseState
) { }

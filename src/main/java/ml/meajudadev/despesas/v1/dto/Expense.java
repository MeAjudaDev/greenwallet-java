package ml.meajudadev.despesas.v1.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.List;

public record Expense(
        @JsonProperty int id,
        @JsonProperty String description,
        @JsonProperty Double value,
        @JsonProperty Boolean isFixed,
        @JsonProperty LocalDate dueDate,
        @JsonProperty List<Integer> categoryIds,
        @JsonProperty int userId
) { }

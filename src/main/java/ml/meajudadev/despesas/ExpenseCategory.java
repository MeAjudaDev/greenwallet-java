package ml.meajudadev.despesas;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ExpenseCategory(
        @JsonProperty int id,
        @JsonProperty String description,
        @JsonProperty boolean enabled
) { }

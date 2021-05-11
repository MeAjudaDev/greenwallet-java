package ml.meajudadev.despesas;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ExpenseCategory(
        @JsonProperty("id") int id,
        @JsonProperty("userId") int userId,
        @JsonProperty("name") String name,
        @JsonProperty("state") char state,
        @JsonProperty("type") char type
) { }

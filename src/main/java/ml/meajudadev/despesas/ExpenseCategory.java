package ml.meajudadev.despesas;


import com.fasterxml.jackson.annotation.JsonProperty;

public record ExpenseCategory(
        @JsonProperty int id,
        @JsonProperty int userId,
        @JsonProperty String name,
        @JsonProperty char state,
        @JsonProperty char type
) { }

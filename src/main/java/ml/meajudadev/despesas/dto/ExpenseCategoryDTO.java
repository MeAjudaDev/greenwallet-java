package ml.meajudadev.despesas.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ExpenseCategoryDTO(
        @JsonProperty long id,
        @JsonProperty String name,
        @JsonProperty String state,
        @JsonProperty String type,
        @JsonProperty long userId,
        @JsonProperty String updatedAt,
        @JsonProperty String createdAt
    ) { }

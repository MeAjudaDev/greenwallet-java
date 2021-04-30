package ml.meajudadev.despesas.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public record ExpenseCategoryDTO(
        @JsonProperty long id,
        @JsonProperty String name,
        @JsonProperty char state,
        @JsonProperty char type,
        @JsonProperty long userId,
        @JsonProperty String updatedAt,
        @JsonProperty String createdAt
    ) { }

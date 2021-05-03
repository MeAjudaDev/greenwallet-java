package ml.meajudadev.despesas.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ExpenseCategoryDTO(
        @JsonProperty("id") long id,
        @JsonProperty("name") String name,
        @JsonProperty("state") String state,
        @JsonProperty("type") String type,
        @JsonProperty("userId") long userId,
        @JsonProperty("updatedAt") String updatedAt,
        @JsonProperty("createdAt")String createdAt
    ) { }

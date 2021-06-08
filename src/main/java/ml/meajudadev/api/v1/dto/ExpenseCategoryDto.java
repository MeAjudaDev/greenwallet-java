package ml.meajudadev.api.v1.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ExpenseCategoryDto(
        @JsonProperty("id") int id,
        @JsonProperty("userId") int userId,
        @JsonProperty("name") String name,
        @JsonProperty("state") char state,
        @JsonProperty("type") char type
) {
}

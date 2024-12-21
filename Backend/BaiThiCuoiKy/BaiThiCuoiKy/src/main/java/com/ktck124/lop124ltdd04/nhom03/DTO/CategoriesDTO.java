package com.ktck124.lop124ltdd04.nhom03.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoriesDTO {
    @JsonProperty("category_name")
    private String categoryName;
}

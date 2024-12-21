package com.ktck124.lop124ltdd04.nhom03.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDTO {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("product_name")
    private String productName;

    @JsonProperty("price")
    private Float price;

    @JsonProperty("color")
    private String color;

    @JsonProperty("category_id")
    private Long categoryId;

    @JsonProperty("image_urls")
    private List<String> imageUrls;
}

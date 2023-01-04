package com.quid.feignClient.model;

import static lombok.AccessLevel.PROTECTED;

import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = PROTECTED)
public class ProductRes {

    private Long id;
    private String title;
    private String description;
    private Long price;
    private Long discountPercentage;
    private Long rating;
    private Integer stock;
    private String brand;
    private String category;
    private String thumbnail;
    private List<String> images;

    @Builder
    public ProductRes(Long id, String title, String description, Long price,
        Long discountPercentage,
        Long rating, Integer stock, String brand, String category, String thumbnail,
        List<String> images) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.discountPercentage = discountPercentage;
        this.rating = rating;
        this.stock = stock;
        this.brand = brand;
        this.category = category;
        this.thumbnail = thumbnail;
        this.images = images;
    }
}

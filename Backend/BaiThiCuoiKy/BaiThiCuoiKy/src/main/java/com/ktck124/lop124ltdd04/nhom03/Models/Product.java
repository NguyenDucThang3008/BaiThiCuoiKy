package com.ktck124.lop124ltdd04.nhom03.Models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name", nullable = false, length = 350)
    private String productName;

    @Column(name = "price")
    private Float price;

    @Column(name = "color")
    private String color;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Categories categories;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ProductImage> productImages;
}

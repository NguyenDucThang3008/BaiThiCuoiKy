package com.ktck124.lop124ltdd04.nhom03.Repository;

import com.ktck124.lop124ltdd04.nhom03.Models.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductImageRepository extends JpaRepository<ProductImage, Long> {
    List<ProductImage> findByProductId(Long productId);
    ProductImage findByImageUrl(String imageUrl);
}

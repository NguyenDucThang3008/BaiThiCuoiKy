package com.ktck124.lop124ltdd04.nhom03.Services;

import com.ktck124.lop124ltdd04.nhom03.DTO.ProductDTO;
import com.ktck124.lop124ltdd04.nhom03.DTO.ProductImageDTO;
import com.ktck124.lop124ltdd04.nhom03.Models.Product;
import com.ktck124.lop124ltdd04.nhom03.Models.ProductImage;

import java.util.List;

public interface IProductService {
    Product createProduct(ProductDTO productDTO) throws Exception;
    Product getProductById(long productId) throws Exception;
    List<ProductDTO> getAllProducts(String keyword, Long categoryId);
    Product updateProduct(long productId, ProductDTO productDTO) throws Exception;
    void deleteProduct(long id);
    boolean existsByName(String name);
    ProductImage createProductImage(Long productId, ProductImageDTO productImageDTO) throws Exception;
    List<Product> findProductsByIds(List<Long> productIds);
    ProductImage getUrl(String imageName);
    List<String> getImageUrlsByProductId(Long productId);
}

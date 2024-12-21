package com.ktck124.lop124ltdd04.nhom03.Services;

import com.ktck124.lop124ltdd04.nhom03.DTO.ProductDTO;
import com.ktck124.lop124ltdd04.nhom03.DTO.ProductImageDTO;
import com.ktck124.lop124ltdd04.nhom03.Exception.DataNotFoundException;
import com.ktck124.lop124ltdd04.nhom03.Models.Categories;
import com.ktck124.lop124ltdd04.nhom03.Models.Product;
import com.ktck124.lop124ltdd04.nhom03.Models.ProductImage;
import com.ktck124.lop124ltdd04.nhom03.Repository.CategoriesRepository;
import com.ktck124.lop124ltdd04.nhom03.Repository.ProductImageRepository;
import com.ktck124.lop124ltdd04.nhom03.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService{

    private final ProductRepository productRepository;
    private final CategoriesRepository categoriesRepository;
    private final ProductImageRepository productImagesRepository;

    @Override
    public Product createProduct(ProductDTO productDTO) throws DataNotFoundException {
        Categories existingCategories = categoriesRepository.findById(productDTO.getCategoryId())
                .orElseThrow(()->
                        new DataNotFoundException("Cannot find categories with id: "+productDTO.getCategoryId()));
        Product product = Product.builder()
                .productName(productDTO.getProductName())
                .price(productDTO.getPrice())
                .color(productDTO.getColor())
                .categories(existingCategories).build();
        return productRepository.save(product);
    }

    @Override
    public Product getProductById(long productId) throws Exception {
        Optional<Product> optionalProduct = productRepository.getDetailProduct(productId);
        if(optionalProduct.isPresent()){
            return optionalProduct.get();
        }
        throw new DataNotFoundException("Cannot find product with ID: "+productId);
    }

    @Override
    public List<ProductDTO> getAllProducts(String keyword, Long categoryId) {
        List<Product> products = productRepository.searchProducts(categoryId, keyword);

        return products.stream().map(product -> ProductDTO.builder()
                        .id(product.getId())
                        .productName(product.getProductName())
                        .price(product.getPrice())
                        .color(product.getColor())
                        .categoryId(product.getCategories() != null ? product.getCategories().getId() : null)
                        .imageUrls(product.getProductImages() != null
                                ? product.getProductImages().stream()
                                .map(ProductImage::getImageUrl)
                                .collect(Collectors.toList())
                                : new ArrayList<>())
                        .build())
                .collect(Collectors.toList());

    }


    @Override
    public Product updateProduct(long productId, ProductDTO productDTO) throws Exception {
        Product existingProduct = getProductById(productId);
        if(existingProduct != null){
            Categories existingCategories = categoriesRepository.findById(productDTO.getCategoryId())
                    .orElseThrow(()-> new DataNotFoundException("Cannot find category with id: "+productDTO.getCategoryId()));
            existingProduct.setProductName(productDTO.getProductName());
            existingProduct.setCategories(existingCategories);
            existingProduct.setPrice(productDTO.getPrice());
            existingProduct.setColor(productDTO.getColor());
            return productRepository.save(existingProduct);
        }
        return null;
    }

    @Override
    public void deleteProduct(long id) {
        productRepository.deleteById(id);
    }

    @Override
    public boolean existsByName(String name) {
        return productRepository.existsByProductName(name);
    }

    @Override
    public ProductImage createProductImage(Long productId, ProductImageDTO productImageDTO) throws Exception {
        Product existingProduct = productRepository.findById(productId)
                .orElseThrow(()->
                        new DataNotFoundException("Cannot find product with id: "+productImageDTO.getProductId()));
        ProductImage newProductImage = ProductImage.builder()
                .product(existingProduct)
                .imageUrl(productImageDTO.getImageUrl())
                .build();
        int size = productImagesRepository.findByProductId(productId).size();
        if(size >= ProductImage.MAXIMUM_IMAGES_PER_PRODUCT){
            throw new DataNotFoundException("Numbers of images must be <= "+ ProductImage.MAXIMUM_IMAGES_PER_PRODUCT);
        }
        return productImagesRepository.save(newProductImage);
    }

    @Override
    public List<Product> findProductsByIds(List<Long> productIds) {
        return productRepository.findProductsByIds(productIds);
    }

    @Override
    public ProductImage getUrl(String imageName) {
        return productImagesRepository.findByImageUrl(imageName);
    }

    @Override
    public List<String> getImageUrlsByProductId(Long productId) {
        return productImagesRepository.findByProductId(productId)
                .stream()
                .map(ProductImage::getImageUrl)
                .collect(Collectors.toList());
    }
}

package Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Product implements Serializable {
    private int id;
    @SerializedName("product_name")
    private String productName;
    private int categoryId;
    private String color;
    private String size;
    private Float price;
    private float discount;

    public Product(String productName, String size, Float price) {
        this.id = id;
        this.productName = productName;
        this.categoryId = categoryId;
        this.size = size;
        this.color = color;
        this.price = price;
        this.discount = discount;
    }

    public Product(int id, String productName, String size, Float price) {
        this.id = id;
        this.productName = productName;
        this.size = size;
        this.price = price;
    }

    public Product(int i, String áoThunNam, int i1, int i2, String m, String number, String s) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }
}
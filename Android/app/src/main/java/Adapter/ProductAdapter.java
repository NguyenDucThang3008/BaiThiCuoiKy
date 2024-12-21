package Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ktck124.lop124ltdd04.nhom03.R;

import java.util.List;

import Model.Product;
import Model.ProductImage;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private List<Product> productList;
    private List<ProductImage> productImageList;
    private Context context;
    private boolean isAdmin;

    public ProductAdapter(List<Product> productList, List<ProductImage> productImageList, boolean isAdmin) {
        this.productList = productList;
        this.productImageList = productImageList;
        this.isAdmin = isAdmin;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {

        Product product = productList.get(position);
        ProductImage productImage = productImageList.get(position);


        holder.productName.setText(product.getProductName());
        holder.productPrice.setText(String.format("₫%,.0f", product.getPrice()));

        // Load the product image from drawable using its resource ID
        int imageResId = Integer.parseInt(productImage.getImageUrl());
        holder.productImage.setImageResource(imageResId);


    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    // ViewHolder class for holding item views
    public static class ProductViewHolder extends RecyclerView.ViewHolder {
        TextView productName, productPrice;
        ImageView productImage;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.product_name);
            productPrice = itemView.findViewById(R.id.product_price);
            productImage = itemView.findViewById(R.id.product_image);
        }
    }
}

package Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ItemDecoration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ktck124.lop124ltdd04.nhom03.R;
import androidx.recyclerview.widget.DividerItemDecoration;
import java.util.ArrayList;
import java.util.List;

import Adapter.ProductAdapter;
import Model.Product;
import Model.ProductImage;


public class HomeFragment extends Fragment {
    private RecyclerView productRecyclerView;
    private ProductAdapter productAdapter;
    private List<Product> productList;
    private List<ProductImage> productImageList;


    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Find views using findViewById
        productRecyclerView = view.findViewById(R.id.items);


        productRecyclerView.setLayoutManager(new GridLayoutManager(requireContext(), 2));
        productRecyclerView.addItemDecoration(new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL));

        // Load data
        productList = loadDataFromLayout();
        productImageList = loadProductImages();

        // Set adapter
        productAdapter = new ProductAdapter(productList, productImageList, false);
        productRecyclerView.setAdapter(productAdapter);

        return view;
    }

    private List<Product> loadDataFromLayout() {
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            products.add(new Product("Tên sản phẩm " + (i + 1), "M", (i + 1) * 100000));
        }
        return products;
    }

    private List<ProductImage> loadProductImages() {
        List<ProductImage> productImages = new ArrayList<>();
        int[] imageResIds = {
//                R.drawable.image1,
//                R.drawable.image2,
//                R.drawable.image3,
//                R.drawable.image4,
//                R.drawable.image5,
//                R.drawable.image6,
//                R.drawable.image7,
//                R.drawable.image8
        };

        for (int i = 0; i < imageResIds.length; i++) {
            productImages.add(new ProductImage(i, i, String.valueOf(imageResIds[i])));
        }
        return productImages;
    }
}

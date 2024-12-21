package Interface;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class APIClient {
    private static Retrofit retrofit = null;
    
    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("http://192.168.1.48:8088/")

                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }


    //Product
    public static ApiProduct createProduct(){
        return getClient().create(ApiProduct.class);
    }
    public static ApiProduct getProduct(){
        return getClient().create(ApiProduct.class);
    }
    public static ApiProduct updateProduct(){
        return getClient().create(ApiProduct.class);
    }
    public static ApiProduct deleteProduct(){
        return getClient().create(ApiProduct.class);
    }
    public static ApiProduct uploadImages(){
        return getClient().create(ApiProduct.class);
    }

    //Category
    public static APICaterogy createcategory() {
        return getClient().create(APICaterogy.class);
    }
    public static APICaterogy getcategory() {
        return getClient().create(APICaterogy.class);
    }
    public static APICaterogy updatecategory(){
        return getClient().create(APICaterogy.class);
    }
    public static APICaterogy deletecategory(){
        return getClient().create(APICaterogy.class);
    }

}
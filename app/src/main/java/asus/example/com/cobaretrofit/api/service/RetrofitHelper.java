package asus.example.com.cobaretrofit.api.service;

import asus.example.com.cobaretrofit.api.Constant;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

// 1.b untuk menginstansiasi interface menggunakan layanan retrofit
public class RetrofitHelper {

    public static Retrofit retrofit;

    /**
     * method untuk mengembalikan layanan retrofit
     * @return retrofit
     */
    public static Retrofit getRetrofitInstance(){
        if( retrofit == null ){
            retrofit = new Retrofit.Builder()
                    .baseUrl( Constant.BASEURL ) /* http://192.168.122.1/cobaRetrofit/ */
                    .addConverterFactory( GsonConverterFactory.create() )
                    .build();
        }

        return retrofit;
    }

    // instansiasi retrofit untuk interface UserClient
    public static UserClient userApiService(){
        return getRetrofitInstance().create(UserClient.class);
    }


}

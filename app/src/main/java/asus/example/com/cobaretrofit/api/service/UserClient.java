package asus.example.com.cobaretrofit.api.service;

import java.util.Map;

import asus.example.com.cobaretrofit.api.model.UserResponse;
import asus.example.com.cobaretrofit.api.model.UserResultItem;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/**
 * Created by asus on 06/01/18.
 */

// 1.a interface sebagai service retrofit untuk manipulasi data / CRUD
public interface UserClient {

    /**
     * method untuk insert banyak field
     * @param fields dari activity Register Account
     * @return
     */
    @FormUrlEncoded
    @POST("register.php")
    Call<UserResultItem> addAccount(
            @FieldMap Map<String, String> fields /* Send Data Form-Urlencoded Using FieldMap */
    );

    /**
     * method untuk insert banyak field
     * @param fields dari activity Register Account
     * @return
     */
    @FormUrlEncoded
    @POST("updateUser.php")
    Call<UserResultItem> updateAccount( /* Send Data form-urlencoded requests */
            @FieldMap Map<String, String> fields /* Send Data Form-Urlencoded Using FieldMap */
    );


    /**
     * method GET loadAccount (all record)
     * tanpa parameter
     * @return all user
     */
    @GET("infoAllUser.php")
    Call<UserResponse> loadAccount();

    /**
     * method GET findAccount (1 record)
     * @param params dari activity Search account
     * @return 1 user
     */
    @GET("findUser.php")
    Call<UserResponse> findAccount(
            @QueryMap Map<String, String> params /* Query Parameter request */
    );


}

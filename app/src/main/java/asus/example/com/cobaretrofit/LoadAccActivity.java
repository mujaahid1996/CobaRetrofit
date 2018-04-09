package asus.example.com.cobaretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import asus.example.com.cobaretrofit.api.model.UserResponse;
import asus.example.com.cobaretrofit.api.model.UserResultItem;
import asus.example.com.cobaretrofit.api.service.RetrofitHelper;
import asus.example.com.cobaretrofit.api.service.UserClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoadAccActivity extends AppCompatActivity {

    TextView tvUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_acc);

        tvUsers = (TextView) findViewById(R.id.tvUsers);
    }

    /**
     * method saat tap button view all user
     * @param view dari xml
     */
    public void viewAllUser(View view) {
        requestLoadUsers();
    }

    /**
     * method untuk melakukan parsing semua data user
     */
    private void requestLoadUsers() {
        // instansiasi retrofit dari awal / biasanya re-use kode RetrofitHelper
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("http://192.168.122.1/cobaRetrofit/")
                .addConverterFactory(GsonConverterFactory.create() );
        Retrofit retrofit =  builder.build();
        UserClient userClient = retrofit.create( UserClient.class ); // get client & call objek untuk request
        // call json
        Call<UserResponse> userModelCall = userClient.loadAccount();
        userModelCall.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                // feedback terhadap user menampilkan hasil response
                tvUsers.setText( response.body().getResult().toString() );
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                // feedback terhadap user saat terjadi kesalahan
                Toast.makeText(LoadAccActivity.this, "failure call"
                        ,Toast.LENGTH_SHORT).show();
            }
        });
    }


}

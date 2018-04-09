package asus.example.com.cobaretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

import asus.example.com.cobaretrofit.api.model.UserResponse;
import asus.example.com.cobaretrofit.api.model.UserResultItem;
import asus.example.com.cobaretrofit.api.service.RetrofitHelper;
import asus.example.com.cobaretrofit.api.service.UserClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchAccActivity extends AppCompatActivity {

    EditText etName;
    TextView tvSearchUser;
    Button btSearch;

    private String TAG = this.getClass().getSimpleName() + "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_acc);

        etName = (EditText) findViewById(R.id.et_searchName);
        tvSearchUser = (TextView) findViewById(R.id.tv_searchUser);
        btSearch = (Button) findViewById(R.id.bt_search);

        // method saat tap button search
        btSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestSearchUser(etName.getText().toString()); // ambil nilai dari hasil input
            }
        });

    }

    /**
     * method untuk parsing mencari 1 data user
     * @param name
     */
    private void requestSearchUser(String name) {
        UserClient userClient = RetrofitHelper.userApiService(); // objek dari interface UserClient sebagai API
        Map<String, String> data = new HashMap<>(); // inisialisasi HashMap untuk menampung parameter
        data.put("name", name); // isi parameter
        Call<UserResponse> userModelCall = userClient.findAccount(data); // panggil method api, membawa parameter
        // asynchronously request
        userModelCall.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                // ...
                tvSearchUser.setText(response.body().getResult().toString());
                Log.v(TAG, "GET retreive from API. " + response.body().toString());
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                // ...
                Toast.makeText(SearchAccActivity.this, "failure response", Toast.LENGTH_SHORT).show();
            }
        });

    }


}

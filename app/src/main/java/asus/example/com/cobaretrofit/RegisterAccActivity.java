package asus.example.com.cobaretrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.HashMap;
import java.util.Map;

import asus.example.com.cobaretrofit.api.model.UserResultItem;
import asus.example.com.cobaretrofit.api.service.RetrofitHelper;
import asus.example.com.cobaretrofit.api.service.UserClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterAccActivity extends AppCompatActivity {

    EditText etName;
    EditText etEmail;
    EditText etTopic;
    EditText etAge;
    Button btCreateAcc;
    Button btUpdateAcc;

    private String TAG = this.getClass().getSimpleName() + "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_acc);

        etName = (EditText) findViewById(R.id.et_name);
        etEmail = (EditText) findViewById(R.id.et_email);
        etTopic = (EditText) findViewById(R.id.et_topic);
        etAge = (EditText) findViewById(R.id.et_age);
        btCreateAcc = (Button) findViewById(R.id.bt_createAcc);
        btUpdateAcc = (Button) findViewById(R.id.bt_updateAcc);


        // method saat tap button create account
        btCreateAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // panggil method requestAddUser, membawa parameter
                requestAddUser(
                        etName.getText().toString()
                        , etEmail.getText().toString()
                        , etTopic.getText().toString()
                        , etAge.getText().toString()
                );
            }
        });

        // method saat tap button update account
        btUpdateAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // panggil method requestUpdateUser, membawa parameter
                requestUpdateUser(
                        etName.getText().toString()
                        , etEmail.getText().toString()
                        , etTopic.getText().toString()
                        , etAge.getText().toString()
                );
            }
        });

    }

    /**
     * method untuk insert 1 data user
     * @param name
     * @param email
     * @param topic
     * @param age
     */
    private void requestAddUser(String name, String email, String topic,  String age) {
        // objek dari interface UserClient
        UserClient userClient = RetrofitHelper.userApiService();
        //Calling JSON with param
        Map<String, String> data = new HashMap<>();
        data.put("name",name);
        data.put("email",email);
        data.put("topic",topic);
        data.put("age",age);
        Call<UserResultItem> userResultItemCall = userClient.addAccount( data );
        // asynchronously request
        userResultItemCall.enqueue(new Callback<UserResultItem>() {
            @Override
            public void onResponse(Call<UserResultItem> call, Response<UserResultItem> response) {
                // kondisi jika response sukses
//                if (response.isSuccessful()) {
//                    Log.v(TAG, "POST submitted to API. " + response.body().toString());
//                }
                Log.v(TAG, "POST submitted to API. " + response.body().toString());
            }

            @Override
            public void onFailure(Call<UserResultItem> call, Throwable t) {
                // feedback trace failure
                Log.e(TAG, "Unable to submit post to API.");
            }
        });
    }

    /**
     * method untuk update 1 data user
     * @param name
     * @param email
     * @param topic
     * @param age
     */
    private void requestUpdateUser(String name, String email, String topic,  String age) {
        // objek dari interface UserClient
        UserClient userClient = RetrofitHelper.userApiService();
        //Calling JSON with param
        Map<String, String> data = new HashMap<>();
        data.put("name",name);
        data.put("email",email);
        data.put("topic",topic);
        data.put("age",age);
        Call<UserResultItem> userResultItemCall = userClient.updateAccount( data );
        // asynchronously request
        userResultItemCall.enqueue(new Callback<UserResultItem>() {
            @Override
            public void onResponse(Call<UserResultItem> call, Response<UserResultItem> response) {
                // kondisi jika response sukses
//                if (response.isSuccessful()) {
//                    Log.v(TAG, "POST submitted to API. " + response.body().toString());
//                }
                Log.v(TAG, "POST submitted to API. " + response.body().toString());
            }

            @Override
            public void onFailure(Call<UserResultItem> call, Throwable t) {
                // feedback trace failure
                Log.e(TAG, "Unable to submit post to API.");
            }
        });
    }


}

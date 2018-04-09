package asus.example.com.cobaretrofit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

// 3. buat class untuk menghasilkan ui
public class MainActivity extends AppCompatActivity {

    // deklarasi
    Button btRegister, btView, btSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // inisialisasi
        btRegister = (Button) findViewById(R.id.bt_register);
        btView = (Button) findViewById(R.id.bt_view);
        btSearch = (Button) findViewById(R.id.bt_searchMenu);

        // method saat tap button register
        btRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), RegisterAccActivity.class));
            }
        });

        // method saat tap button view
        btView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), LoadAccActivity.class));
            }
        });

        // method saat tap button search
        btSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),SearchAccActivity.class));
            }
        });

    }


}

package com.example.covidapp_build_with_java_ver1;

import android.app.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class cityFinder extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    TextView Button_VietNam, Button_China, Button_Us, Button_Uk, Button_India,
    Button_Iran, Button_Egypt, Button_Sk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_finder);
        final EditText editText = findViewById(R.id.searchCity);

        Button_VietNam = findViewById(R.id.button_vn);
        Button_China = findViewById(R.id.button_china);
        Button_Us = findViewById(R.id.button_us);
        Button_Uk = findViewById(R.id.button_uk);
        Button_India = findViewById(R.id.button_india);
        Button_Egypt = findViewById(R.id.button_egypt);
        Button_Sk = findViewById(R.id.button_south_korea);
        Button_Iran = findViewById(R.id.button_iran);


        bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setBackground(null);
        bottomNavigationView.setSelectedItemId(R.id.nav_search);
        bottomNavigationView.setItemIconTintList(null);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId())
                {
                    case R.id.nav_home:
                        startActivity(new Intent(getApplicationContext(),HomePage.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_search:
                        return true;
                    case R.id.nav_symptom:
                        startActivity(new Intent(getApplicationContext(),Symptom.class));
                        overridePendingTransition(0,0);
                        return true;

                }
                return false;
            }
        });


        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                String newCity = editText.getText().toString();
                Intent intent = new Intent(cityFinder.this, HomePage.class);
                intent.putExtra("City", newCity);
                startActivity(intent);
                return false;
            }
        });
        Button_VietNam.setOnClickListener(view -> {
            findCountry("VietNam");
        });
        Button_China.setOnClickListener(view -> {
            findCountry("China");
        });
        Button_Uk.setOnClickListener(view -> {
            findCountry("United Kingdom");
        });
        Button_Us.setOnClickListener(view -> {
            findCountry("United States");
        });
        Button_India.setOnClickListener(view -> {
            findCountry("India");
        });
        Button_Iran.setOnClickListener(view -> {
            findCountry("Iran");
        });
        Button_Egypt.setOnClickListener(view -> {
            findCountry("Egypt");
        });
        Button_Sk.setOnClickListener(view -> {
            findCountry("South Korea");
        });



    }

    private void findCountry(String country) {
        Intent intent = new Intent(this,HomePage.class);
        intent.putExtra("City",country);
        startActivity(intent);
    }

}

package org.techtown.food;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MenuActivity extends AppCompatActivity {
    public static final int REQUEST_CODE_MAIN=100;
    public static final int REQUEST_KOREA_MENU = 102;
    public static final int REQUEST_JAPAN_MENU = 103;
    public static final int REQUEST_EVALUATE_MENU=110;
    public static final int REQUEST_CODE_MENU = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button buttonKorea = findViewById(R.id.buttonKorea);
        buttonKorea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),KoreaActivity.class);
                startActivityForResult(intent,REQUEST_KOREA_MENU);
            }
        });

        Button buttonJapan = findViewById(R.id.buttonJapan);
        buttonJapan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),JapanActivity.class);
                startActivityForResult(intent,REQUEST_JAPAN_MENU);
            }
        });

        Button buttonChina = findViewById(R.id.buttonChina);
        buttonChina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        Button buttonExtra = findViewById(R.id.buttonExtra);
        buttonExtra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.tab1:
                        Toast.makeText(getApplicationContext(),"이전 화면으로 이동합니다.",Toast.LENGTH_SHORT).show();
                        finish();
                        return true;
                    case R.id.tab2:
                        Toast.makeText(getApplicationContext(),"홈화면으로 이동합니다.",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                        startActivityForResult(intent,REQUEST_CODE_MAIN);
                        return true;
                    case R.id.tab3:
                        Toast.makeText(getApplicationContext(), "앱 평가하기로 이동합니다.", Toast.LENGTH_SHORT).show();
                        Intent intent2 = new Intent(getApplicationContext(),EvaluateActivity.class);
                        startActivityForResult(intent2,REQUEST_EVALUATE_MENU);

                }
                return false;
            }
        });

    }

}
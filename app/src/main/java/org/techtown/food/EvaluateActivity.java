package org.techtown.food;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class EvaluateActivity extends AppCompatActivity {
    public static final int REQUEST_CODE_MAIN=100;
    public static final int REQUEST_EVALUATE_MENU=110;

    int number=3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluate);

        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        RadioButton radioButton = findViewById(R.id.radioButton);
        RadioButton radioButton2 = findViewById(R.id.radioButton2);
        RadioButton radioButton3 = findViewById(R.id.radioButton3);
        radioButton3.setChecked(true);

        radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(radioButton2.isChecked())
                    number=2;
                else if(radioButton3.isChecked())
                    number=3;
            }
        });

        radioButton2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(radioButton3.isChecked())
                    number=3;
                else if(radioButton.isChecked())
                    number=1;
            }
        });

        radioButton3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(radioButton.isChecked())
                    number=1;
                else if(radioButton2.isChecked())
                    number=2;
            }
        });

        Button button4 = findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(number==1){
                    Toast.makeText(getApplicationContext(),"분발하겠습니다.",Toast.LENGTH_SHORT).show();
                }
                else if(number==2){
                    Toast.makeText(getApplicationContext(),"좋은 평가 감사합니다.",Toast.LENGTH_SHORT).show();
                }
                else if(number==3){
                    Toast.makeText(getApplicationContext(),"사랑합니다.",Toast.LENGTH_SHORT).show();
                }
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
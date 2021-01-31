package org.techtown.food;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class PosungActivity extends AppCompatActivity {
    public static final int REQUEST_CODE_MAIN=100;
    public static final int REQUEST_EVALUATE_MENU=110;


    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posung);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

        RecfoodAdapter adapter = new RecfoodAdapter();

        adapter.addItem(new Recfood(R.drawable.posung1,"육장돼지갈비","14,000원"));
        adapter.addItem(new Recfood(R.drawable.posung2,"멜젓생삼겹살","14,000원"));
        adapter.addItem(new Recfood(R.drawable.posung3,"오미양념게장","17,000원"));

        recyclerView.setAdapter(adapter);

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
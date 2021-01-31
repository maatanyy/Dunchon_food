package org.techtown.food;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class JapanActivity extends AppCompatActivity {
    public static final int REQUEST_CODE_MAIN=100;
    public static final int REQUEST_EVALUATE_MENU=110;

    SupportMapFragment mapFragment;
    GoogleMap map;

    MarkerOptions food4;
    MarkerOptions food5;

    Drawable pic4;
    Drawable pic5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_japan);


        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                map=googleMap;
                map.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(37.52482, 127.13455), 16));
                addMarkers();
                map.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                    @Override
                    public boolean onMarkerClick(Marker marker) {
                        Toast.makeText(getApplicationContext(), marker.getTitle() + "로 이동합니다.", Toast.LENGTH_SHORT).show();
                        if(marker.getTitle().equals("일층")){
                           //Intent intent = new Intent(getApplicationContext(),FirstFloorActivity.class);
                           // startActivityForResult(intent,REQUEST_FIRST_MENU);
                        }
                        else if(marker.getTitle().equals("유정상스시")){
                         //   Intent intent = new Intent(getApplicationContext(),YouActivity.class);
                         //   startActivityForResult(intent,REQUEST_YOU_MENU);
                        }
                        return true;
                    }
                });
            }
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.tab1:
                        Toast.makeText(getApplicationContext(),"뒤로가기",Toast.LENGTH_SHORT).show();
                        finish();
                        return true;
                    case R.id.tab2:
                        Toast.makeText(getApplicationContext(),"홈화면으로",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                        startActivityForResult(intent,REQUEST_CODE_MAIN);
                        return true;
                    case R.id.tab3:
                        Toast.makeText(getApplicationContext(), "앱 평가하기로 이동합니다.", Toast.LENGTH_SHORT).show();
                        Intent intent2 = new Intent(getApplicationContext(),EvaluateActivity.class);
                        startActivityForResult(intent2,REQUEST_EVALUATE_MENU);
                        return true;
                }
                return false;
            }
        });
    }
    public void addMarkers(){
        LatLng foodpos = new LatLng(37.52616,127.13447);
        food4 = new MarkerOptions();
        food4.position(foodpos);
        food4.title("일층");

        pic4 = getResources().getDrawable(R.drawable.image4);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.image4);
        bitmap = Bitmap.createScaledBitmap(bitmap,200,100,true);
        food4.icon(BitmapDescriptorFactory.fromBitmap(bitmap));

        map.addMarker(food4);

        foodpos = new LatLng(37.52244, 127.13383);
        food5 = new MarkerOptions();
        food5.position(foodpos);
        food5.title("유정상스시");
        pic5 = getResources().getDrawable(R.drawable.image5);
        bitmap = ((BitmapDrawable)pic5).getBitmap();
        bitmap = Bitmap.createScaledBitmap(bitmap,200,100,true);
        food5.icon(BitmapDescriptorFactory.fromBitmap(bitmap));
        map.addMarker(food5);
    }
}
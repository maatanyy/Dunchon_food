package org.techtown.food;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
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
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class KoreaActivity extends AppCompatActivity {
    public static final int REQUEST_POSUNG_MENU = 106;
    public static final int REQUEST_MYUNG_MENU = 107;
    public static final int REQUEST_DAWON_MENU = 108;
    public static final int REQUEST_CODE_MAIN=100;
    public static final int REQUEST_EVALUATE_MENU=110;

    SupportMapFragment mapFragment;
    GoogleMap map;

    MarkerOptions food1;
    MarkerOptions food2;
    MarkerOptions food3;

    Drawable pic1;
    Drawable pic2;
    Drawable pic3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_korea);

        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                map=googleMap;
                map.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(37.52538, 127.13366), 17));
                addMarkers();
                map.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                    @Override
                    public boolean onMarkerClick(Marker marker) {
                        Toast.makeText(getApplicationContext(), marker.getTitle() + "로 이동합니다.", Toast.LENGTH_SHORT).show();
                        if(marker.getTitle().equals("보성갈비")){
                            Intent intent = new Intent(getApplicationContext(),PosungActivity.class);
                            startActivityForResult(intent,REQUEST_POSUNG_MENU);
                        }
                      else if(marker.getTitle().equals("대원왕족발")){
                           Intent intent = new Intent(getApplicationContext(),DawonActivity.class);
                            startActivityForResult(intent,REQUEST_DAWON_MENU);
                        }
                       else if(marker.getTitle().equals("명가감자탕")){
                           Intent intent = new Intent(getApplicationContext(),MyungActivity.class);
                            startActivityForResult(intent,REQUEST_MYUNG_MENU);
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
                        return true;
                }
                return false;
            }
        });

    }


    public void addMarkers(){
        LatLng foodpos = new LatLng(37.52418,127.13380);
        food1 = new MarkerOptions();
        food1.position(foodpos);
        food1.title("명가감자탕");

        pic1 = getResources().getDrawable(R.drawable.image1);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.image1);
        bitmap = Bitmap.createScaledBitmap(bitmap,200,100,true);
        food1.icon(BitmapDescriptorFactory.fromBitmap(bitmap));

        map.addMarker(food1);

        foodpos = new LatLng(37.52613, 127.13347);
        food2 = new MarkerOptions();
        food2.position(foodpos);
        food2.title("보성갈비");
        pic2 = getResources().getDrawable(R.drawable.image2);
        bitmap = ((BitmapDrawable)pic2).getBitmap();
        bitmap = Bitmap.createScaledBitmap(bitmap,200,100,true);
        food2.icon(BitmapDescriptorFactory.fromBitmap(bitmap));
        map.addMarker(food2);

        foodpos = new LatLng(37.52474001343453,127.13302797687423);
        food3 = new MarkerOptions();
        food3.position(foodpos);
        food3.title("대원왕족발");
        pic3 = getResources().getDrawable(R.drawable.image3);
        bitmap=((BitmapDrawable)pic3).getBitmap();
        bitmap = Bitmap.createScaledBitmap(bitmap,200,100,true);
        food3.icon(BitmapDescriptorFactory.fromBitmap(bitmap));
        map.addMarker(food3);
    }
}
package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.yandex.mapkit.MapKitFactory;
import com.yandex.mapkit.geometry.Point;
import com.yandex.mapkit.map.CameraPosition;
import com.yandex.mapkit.mapview.MapView;

public class yaMap extends AppCompatActivity {

    final  String API_KEY_MAP = "d1969b60-f742-4724-b935-64da2d3d39b9";
     MapView mapView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ya_map);

        MapKitFactory.setApiKey(API_KEY_MAP);
        MapKitFactory.initialize(this);
        setContentView(R.layout.activity_ya_map);

        mapView = findViewById(R.id.mapview);
        mapView.getMap().move(new CameraPosition(new Point(59.945933, 30.320045), 15.0f, 0.0f, 0.0f));

    }


    @Override
    protected void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onStop();
    }

}
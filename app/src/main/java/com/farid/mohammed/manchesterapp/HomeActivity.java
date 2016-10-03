package com.farid.mohammed.manchesterapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    GridView androidGridView;

    String[] gridViewString = {
            "Alram", "Android", "Mobile", "Website", "Profile", "WordPress"
    } ;
    int[] gridViewImageId = {
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        CustemGridView adapterViewAndroid = new CustemGridView(HomeActivity.this, gridViewString, gridViewImageId);
        androidGridView=(GridView)findViewById(R.id.grid_view_image_text);
        androidGridView.setAdapter(adapterViewAndroid);
        androidGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int i, long id) {
                //Toast.makeText(HomeActivity.this, "GridView Item: " + gridViewString[+i], Toast.LENGTH_SHORT).show();
                finish();

            }
        });

    }
}

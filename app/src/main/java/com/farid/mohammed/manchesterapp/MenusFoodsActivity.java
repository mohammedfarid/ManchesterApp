package com.farid.mohammed.manchesterapp;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MenusFoodsActivity extends AppCompatActivity {
    ListView androidListView;
    Intent intent;
    SeaFoodManchester seaFoodManchester;
    public static int [] listViewImage={
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher};
    public static String [] listViewString={
            "Let Us C",
            "c++",
            "JAVA",
            "Jsp",
            "Microsoft .Net",
            "Android",
            "PHP",
            "Jquery",
            "JavaScript"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_menus_foods);

        seaFoodManchester = new SeaFoodManchester();
        intent = new Intent(this, LocationPlaceaActivity.class);

        CustomListView adapterViewAndroid = new CustomListView(MenusFoodsActivity.this,
                seaFoodManchester.listViewString,seaFoodManchester.listViewImage);
        androidListView=(ListView) findViewById(R.id.listView);
        androidListView.setAdapter(adapterViewAndroid);
        androidListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int i, long id) {
                startActivity(intent);
            }
        });
    }
}

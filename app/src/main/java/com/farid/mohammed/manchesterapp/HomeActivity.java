package com.farid.mohammed.manchesterapp;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    Intent intent,intent2;
    GridView androidGridView;

    String[] gridViewString = {
            "Italian Pizza", "Meat Manchester", "Chickens Manchester", "Sea Food Manchester",
            "Cheese Manchester", "Sweet Manchester","Contact Us"
    } ;
    int[] gridViewImageId = {
            R.mipmap.ic_launcher,
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
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_home);

        intent = new Intent(this, MenusFoodsActivity.class);
        intent2 = new Intent(this,LocationPlaceaActivity.class);

        CustemGridView adapterViewAndroid = new CustemGridView(HomeActivity.this, gridViewString, gridViewImageId);
        androidGridView=(GridView)findViewById(R.id.grid_view_image_text);
        androidGridView.setAdapter(adapterViewAndroid);
        androidGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int i, long id) {
                // ListView Clicked item index
                int itemPosition     = i;
                //or other way
                // ListView Clicked item value
                String  itemValue    =  androidGridView.getItemAtPosition(i).toString();

                if (itemPosition == 0){
                    intent.putExtra("Italian_Pizza",true);
                    intent.putExtra("Meat_Food",false);
                    intent.putExtra("Chicken_Food",false);
                    intent.putExtra("Sea_Food",false);
                    intent.putExtra("Cheese_Food",false);
                    intent.putExtra("Sweet_Food",false);
                    startActivity(intent);
                }else if(itemPosition == 1){
                    intent.putExtra("Italian_Pizza",false);
                    intent.putExtra("Meat_Food",true);
                    intent.putExtra("Chicken_Food",false);
                    intent.putExtra("Sea_Food",false);
                    intent.putExtra("Cheese_Food",false);
                    intent.putExtra("Sweet_Food",false);
                    startActivity(intent);
                }else if(itemPosition == 2){
                    intent.putExtra("Italian_Pizza",false);
                    intent.putExtra("Meat_Food",false);
                    intent.putExtra("Chicken_Food",true);
                    intent.putExtra("Sea_Food",false);
                    intent.putExtra("Cheese_Food",false);
                    intent.putExtra("Sweet_Food",false);
                    startActivity(intent);
                }else if(itemPosition == 3){
                    intent.putExtra("Italian_Pizza",false);
                    intent.putExtra("Meat_Food",false);
                    intent.putExtra("Chicken_Food",false);
                    intent.putExtra("Sea_Food",true);
                    intent.putExtra("Cheese_Food",false);
                    intent.putExtra("Sweet_Food",false);
                    startActivity(intent);
                }else if(itemPosition == 4){
                    intent.putExtra("Italian_Pizza",false);
                    intent.putExtra("Meat_Food",false);
                    intent.putExtra("Chicken_Food",false);
                    intent.putExtra("Sea_Food",false);
                    intent.putExtra("Cheese_Food",true);
                    intent.putExtra("Sweet_Food",false);
                    startActivity(intent);
                }else if(itemPosition == 5){
                    intent.putExtra("Italian_Pizza",false);
                    intent.putExtra("Meat_Food",false);
                    intent.putExtra("Chicken_Food",false);
                    intent.putExtra("Sea_Food",false);
                    intent.putExtra("Cheese_Food",false);
                    intent.putExtra("Sweet_Food",true);
                    startActivity(intent);
                }else if(itemPosition == 6){
                    startActivity(intent2);
                }
            }
        });

    }
}

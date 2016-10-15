package com.farid.mohammed.manchesterapp;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MenusFoodsActivity extends AppCompatActivity {
    ListView androidListView;
    Intent intent;
    TextView title;

    CustomListView adapterViewAndroid;

    ItalianPizzaManchester italianPizzaManchester;
    MeatManchester meatManchester;
    ChickensManchester chickensManchester;
    SeaFoodManchester seaFoodManchester;
    CheeseManchester cheeseManchester;
    SweetManchester sweetManchester;

    Intent getIntentFood;

    boolean italianPizza = false ,meatFood = false,chickenFood = false,
            seaFood = false,cheeseFood = false,sweetFood = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_menus_foods);
        title = (TextView) findViewById(R.id.title_food);
        intent = new Intent(this, LocationPlaceaActivity.class);

        italianPizzaManchester = new ItalianPizzaManchester();
        meatManchester = new MeatManchester();
        chickensManchester = new ChickensManchester();
        seaFoodManchester = new SeaFoodManchester();
        cheeseManchester = new CheeseManchester();
        sweetManchester = new SweetManchester();


        getIntentFood = getIntent();

        italianPizza = getIntentFood.getBooleanExtra("Italian_Pizza",false);
        meatFood = getIntentFood.getBooleanExtra("Meat_Food",false);
        chickenFood = getIntentFood.getBooleanExtra("Chicken_Food",false);
        seaFood = getIntentFood.getBooleanExtra("Sea_Food",false);
        cheeseFood = getIntentFood.getBooleanExtra("Cheese_Food",false);
        sweetFood = getIntentFood.getBooleanExtra("Sweet_Food",false);


        if(italianPizza){
            Toast.makeText(getApplicationContext(),"ita2",Toast.LENGTH_SHORT).show();

            title.setText(italianPizzaManchester.title);
            adapterViewAndroid = new CustomListView(MenusFoodsActivity.this,
                    italianPizzaManchester.listViewString,italianPizzaManchester.listViewImage);

        }
        if(meatFood){
            title.setText(meatManchester.title);
            adapterViewAndroid = new CustomListView(MenusFoodsActivity.this,
                    meatManchester.listViewString,meatManchester.listViewImage);
        }
        if(chickenFood){
            title.setText(chickensManchester.title);
            adapterViewAndroid = new CustomListView(MenusFoodsActivity.this,
                    chickensManchester.listViewString,chickensManchester.listViewImage);
        }
        if(seaFood){
            title.setText(seaFoodManchester.title);
            adapterViewAndroid = new CustomListView(MenusFoodsActivity.this,
                    seaFoodManchester.listViewString,seaFoodManchester.listViewImage);
        }
        if(cheeseFood){
            title.setText(cheeseManchester.title);
            adapterViewAndroid = new CustomListView(MenusFoodsActivity.this,
                    cheeseManchester.listViewString,cheeseManchester.listViewImage);
        }
        if(sweetFood){
            title.setText(sweetManchester.title);
            adapterViewAndroid = new CustomListView(MenusFoodsActivity.this,
                    sweetManchester.listViewString,sweetManchester.listViewImage);
        }

        androidListView=(ListView) findViewById(R.id.listView);
        androidListView.setAdapter(adapterViewAndroid);
        androidListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int i, long id) {
                //startActivity(intent);

            }
        });
    }
}

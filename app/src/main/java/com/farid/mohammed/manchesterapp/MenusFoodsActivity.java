package com.farid.mohammed.manchesterapp;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MenusFoodsActivity extends AppCompatActivity {

    private Toolbar toolbar;

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

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.app_name);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        italianPizzaManchester = new ItalianPizzaManchester(getApplicationContext());
        meatManchester = new MeatManchester(getApplicationContext());
        chickensManchester = new ChickensManchester(getApplicationContext());
        seaFoodManchester = new SeaFoodManchester(getApplicationContext());
        cheeseManchester = new CheeseManchester(getApplicationContext());
        sweetManchester = new SweetManchester(getApplicationContext());


        getIntentFood = getIntent();

        italianPizza = getIntentFood.getBooleanExtra("Italian_Pizza",false);
        meatFood = getIntentFood.getBooleanExtra("Meat_Food",false);
        chickenFood = getIntentFood.getBooleanExtra("Chicken_Food",false);
        seaFood = getIntentFood.getBooleanExtra("Sea_Food",false);
        cheeseFood = getIntentFood.getBooleanExtra("Cheese_Food",false);
        sweetFood = getIntentFood.getBooleanExtra("Sweet_Food",false);


        if(italianPizza){
            title.setText(italianPizzaManchester.title);
            adapterViewAndroid = new CustomListView(MenusFoodsActivity.this,
                    italianPizzaManchester.listViewString);

        }
        if(meatFood){
            title.setText(meatManchester.title);
            adapterViewAndroid = new CustomListView(MenusFoodsActivity.this,
                    meatManchester.listViewString);
        }
        if(chickenFood){
            title.setText(chickensManchester.title);
            adapterViewAndroid = new CustomListView(MenusFoodsActivity.this,
                    chickensManchester.listViewString);
        }
        if(seaFood){
            title.setText(seaFoodManchester.title);
            adapterViewAndroid = new CustomListView(MenusFoodsActivity.this,
                    seaFoodManchester.listViewString);
        }
        if(cheeseFood){
            title.setText(cheeseManchester.title);
            adapterViewAndroid = new CustomListView(MenusFoodsActivity.this,
                    cheeseManchester.listViewString);
        }
        if(sweetFood){
            title.setText(sweetManchester.title);
            adapterViewAndroid = new CustomListView(MenusFoodsActivity.this,
                    sweetManchester.listViewString);
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
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        // Configure the search info and add any event listeners...
        MenuItem item = menu.findItem(R.id.activity_lang);
        item.setVisible(false);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        try {
            switch (item.getItemId()) {
                case android.R.id.home:
                    Toast.makeText(getApplicationContext(),"actionSetting",Toast.LENGTH_SHORT).show();
                    NavUtils.navigateUpFromSameTask(this);
                    break;
                case R.id.activity_share:
                    Toast.makeText(getApplicationContext(),"share",Toast.LENGTH_SHORT).show();
                    Intent share = new Intent(android.content.Intent.ACTION_SEND);
                    share.setType("text/plain");
                    share.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);

                    // Add data to the intent, the receiving app will decide
                    // what to do with it.
                    share.putExtra(Intent.EXTRA_SUBJECT, "Title Of The Post");
                    share.putExtra(Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=com.textwatch.egypt&hl=en");

                    startActivity(Intent.createChooser(share, "Share link!"));
                    break;
                default:
                    return super.onOptionsItemSelected(item);
            }
        } catch (Exception e) {

        }
        return true;
    }
}

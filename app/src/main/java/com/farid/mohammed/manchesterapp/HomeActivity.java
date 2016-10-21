package com.farid.mohammed.manchesterapp;

import android.*;
import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.PersistableBundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;


public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private static final String SELECT_ITEM_ID = "selected";
    private static final String FIRST_TIME ="firstTime" ;
    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private int seletedId;
    private  boolean userSawDrawer = false;

    static final String ACTION_SCAN = "com.google.zxing.client.android.SCAN";

    Intent intent,intent2;
    GridView androidGridView;
    String[] gridViewString ;
    String [] grid = {
            "Italian Pizza",
            "Meat Manchester",
            "Chickens Manchester",
            "Sea Food Manchester",
            "Cheese Manchester",
            "Sweet Manchester"};;
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
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_home);
        gridViewString=getResources().getStringArray(R.array.grid_view);


        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //add DrawerNavigation
        navigationView = (NavigationView) findViewById(R.id.main_drawer);
        navigationView.setNavigationItemSelectedListener(this);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this
                ,drawerLayout
                ,toolbar
                ,R.string.drawer_open
                ,R.string.drawer_close);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        if(!didUserSeeDrawer()){
            showDrawer();
            markeDrawerSeen();
        }else {
            hideDrawer();
        }
        seletedId = savedInstanceState == null ? R.id.menus_food : savedInstanceState.getInt(SELECT_ITEM_ID);
        navigated(seletedId);

        intent2 = new Intent(this,LocationPlaceaActivity.class);

        intent = new Intent(this, MenusFoodsActivity.class);
        CustemGridView adapterViewAndroid = new CustemGridView(HomeActivity.this,gridViewString, gridViewImageId);
        androidGridView=(GridView)findViewById(R.id.grid_view_image_text);
        androidGridView.setAdapter(adapterViewAndroid);
        androidGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int i, long id) {
                // ListView Clicked item index
                int itemPosition     = i;
                //or other way
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
                }
            }
        });

    }

    private void navigated(int seletedId) {
        Intent intent = null;
        if(seletedId == R.id.menus_food){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        if(seletedId == R.id.branches){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        if(seletedId == R.id.offers_event){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        if(seletedId == R.id.contact_us){
            intent = new Intent(this,LocationPlaceaActivity.class);
            drawerLayout.closeDrawer(GravityCompat.START);
            startActivity(intent);
        }
        if(seletedId == R.id.reseved_table){
            intent = new Intent(this,LocationPlaceaActivity.class);
            drawerLayout.closeDrawer(GravityCompat.START);
            startActivity(intent);
        }
        if(seletedId == R.id.bar_code){
            drawerLayout.closeDrawer(GravityCompat.START);

        }
        if(seletedId == R.id.developed_by){
            intent = new Intent(this,DevelopeByActivity.class);
            drawerLayout.closeDrawer(GravityCompat.START);
            startActivity(intent);
        }
    }
    private boolean didUserSeeDrawer(){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        userSawDrawer=sharedPreferences.getBoolean(FIRST_TIME,false);
        return userSawDrawer;
    }
    private void markeDrawerSeen(){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        userSawDrawer =true;
        sharedPreferences.edit().putBoolean(FIRST_TIME,userSawDrawer).apply();
    }
    private void showDrawer(){
        drawerLayout.openDrawer(GravityCompat.START);
    }
    private void hideDrawer(){
        drawerLayout.closeDrawer(GravityCompat.START);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        actionBarDrawerToggle.onConfigurationChanged(newConfig);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        item.setChecked(true);
        seletedId = item.getItemId();
        navigated(seletedId);
        return true;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(SELECT_ITEM_ID,seletedId);
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }
    //on ActivityResult method
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                //get the extras that are returned from the intent
                String contents = intent.getStringExtra("SCAN_RESULT");
                String format = intent.getStringExtra("SCAN_RESULT_FORMAT");
                Toast toast = Toast.makeText(this, "Content:" + contents + " Format:" + format, Toast.LENGTH_LONG);
                toast.show();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        // Configure the search info and add any event listeners...
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        try {
            switch (item.getItemId()) {
                case R.id.activity_share:
                    Toast.makeText(getApplicationContext(),"share",Toast.LENGTH_SHORT).show();
                    Intent share = new Intent(android.content.Intent.ACTION_SEND);
                    share.setType("text/plain");
                    share.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);

                    // Add data to the intent, the receiving app will decide
                    // what to do with it.
                    share.putExtra(Intent.EXTRA_SUBJECT, "Title Of The Post");
                    share.putExtra(Intent.EXTRA_TEXT, "http://www.codeofaninja.com");

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
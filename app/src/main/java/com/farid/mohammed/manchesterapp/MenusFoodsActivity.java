package com.farid.mohammed.manchesterapp;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MenusFoodsActivity extends AppCompatActivity {
    ListView lv;
    Context context;

    ArrayList prgmName;
    public static int [] prgmImages={
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher};
    public static String [] prgmNameList={
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
        context=this;

        lv=(ListView) findViewById(R.id.listView);
        lv.setAdapter(new CustomListView(this, prgmNameList,prgmImages));
    }
}

package com.farid.mohammed.manchesterapp;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialog;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import customs.CustomListView;
import menuscontant.CheeseManchester;
import menuscontant.ChickensManchester;
import menuscontant.ItalianPizzaManchester;
import menuscontant.MeatManchester;
import menuscontant.SeaFoodManchester;
import menuscontant.SweetManchester;

public class MenusFoodsActivity extends AppCompatActivity {

    final Context context = this;
    int laInted = 0, meInted = 0, smInted = 0;
    EditText ed_la, ed_me, ed_sm;
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
    boolean italianPizza = false, meatFood = false, chickenFood = false,
            seaFood = false, cheeseFood = false, sweetFood = false;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
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

        italianPizza = getIntentFood.getBooleanExtra("Italian_Pizza", false);
        meatFood = getIntentFood.getBooleanExtra("Meat_Food", false);
        chickenFood = getIntentFood.getBooleanExtra("Chicken_Food", false);
        seaFood = getIntentFood.getBooleanExtra("Sea_Food", false);
        cheeseFood = getIntentFood.getBooleanExtra("Cheese_Food", false);
        sweetFood = getIntentFood.getBooleanExtra("Sweet_Food", false);


        if (italianPizza) {
            title.setText(italianPizzaManchester.title);
            adapterViewAndroid = new CustomListView(MenusFoodsActivity.this,
                    italianPizzaManchester.listViewString, italianPizzaManchester.image);

        }
        if (meatFood) {
            title.setText(meatManchester.title);
            adapterViewAndroid = new CustomListView(MenusFoodsActivity.this,
                    meatManchester.listViewString, meatManchester.image);
        }
        if (chickenFood) {
            title.setText(chickensManchester.title);
            adapterViewAndroid = new CustomListView(MenusFoodsActivity.this,
                    chickensManchester.listViewString, chickensManchester.image);
        }
        if (seaFood) {
            title.setText(seaFoodManchester.title);
            adapterViewAndroid = new CustomListView(MenusFoodsActivity.this,
                    seaFoodManchester.listViewString, seaFoodManchester.image);
        }
        if (cheeseFood) {
            title.setText(cheeseManchester.title);
            adapterViewAndroid = new CustomListView(MenusFoodsActivity.this,
                    cheeseManchester.listViewString, cheeseManchester.image);
        }
        if (sweetFood) {
            title.setText(sweetManchester.title);
            adapterViewAndroid = new CustomListView(MenusFoodsActivity.this,
                    sweetManchester.listViewString, sweetManchester.image);
        }

        androidListView = (ListView) findViewById(R.id.listView);
        androidListView.setAdapter(adapterViewAndroid);
        androidListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int i, long id) {
                final AppCompatDialog dialog = new AppCompatDialog(context);
                dialog.setContentView(R.layout.custom_dialog_price);
                TextView text = (TextView) dialog.findViewById(R.id.title);
                ImageView imageView = (ImageView) dialog.findViewById(R.id.image);
                Button bu_n_la = (Button) dialog.findViewById(R.id.n_la);
                Button bu_n_me = (Button) dialog.findViewById(R.id.n_me);
                Button bu_n_sm = (Button) dialog.findViewById(R.id.n_sm);

                Button bu_p_la = (Button) dialog.findViewById(R.id.p_la);
                Button bu_p_me = (Button) dialog.findViewById(R.id.p_me);
                Button bu_p_sm = (Button) dialog.findViewById(R.id.p_sm);

                Button bu_ok = (Button) dialog.findViewById(R.id.bu_ok);

                TextView tv_price_la = (TextView) dialog.findViewById(R.id.price_la);
                TextView tv_price_me = (TextView) dialog.findViewById(R.id.price_me);
                TextView tv_price_sm = (TextView) dialog.findViewById(R.id.price_sm);

                ed_la = (EditText) dialog.findViewById(R.id.ed_la);
                ed_la.setText("" + laInted, TextView.BufferType.EDITABLE);
                ed_me = (EditText) dialog.findViewById(R.id.ed_me);
                ed_me.setText("" + meInted, TextView.BufferType.EDITABLE);
                ed_sm = (EditText) dialog.findViewById(R.id.ed_sm);
                ed_sm.setText("" + smInted, TextView.BufferType.EDITABLE);

                if (italianPizza) {
                    dialog.setTitle(italianPizzaManchester.title);
                    text.setText(italianPizzaManchester.listViewString[i]);
                    imageView.setImageResource(italianPizzaManchester.image);
                }
                if (meatFood) {
                    dialog.setTitle(meatManchester.title);
                    text.setText(meatManchester.listViewString[i]);
                    imageView.setImageResource(meatManchester.image);
                }
                if (chickenFood) {
                    dialog.setTitle(chickensManchester.title);
                    text.setText(chickensManchester.listViewString[i]);
                    imageView.setImageResource(chickensManchester.image);
                }
                if (seaFood) {
                    dialog.setTitle(seaFoodManchester.title);
                    text.setText(seaFoodManchester.listViewString[i]);
                    imageView.setImageResource(seaFoodManchester.image);
                }
                if (cheeseFood) {
                    dialog.setTitle(cheeseManchester.title);
                    text.setText(cheeseManchester.listViewString[i]);
                    imageView.setImageResource(cheeseManchester.image);
                    tv_price_la.setText("" + cheeseManchester.laPrice[i] + "L.E");
                    tv_price_me.setText("" + cheeseManchester.mePrice[i] + "L.E");
                    tv_price_sm.setText("" + cheeseManchester.smPrice[i] + "L.E");
                }
                if (sweetFood) {
                    dialog.setTitle(sweetManchester.title);
                    text.setText(sweetManchester.listViewString[i]);
                    imageView.setImageResource(sweetManchester.image);
                }
                bu_p_la.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        laInted++;
                        ed_la.setText("" + laInted);
                    }
                });
                bu_p_me.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        meInted++;
                        ed_me.setText("" + meInted);
                    }
                });
                bu_p_sm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        smInted++;
                        ed_sm.setText("" + smInted);
                    }
                });
                bu_n_la.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (laInted >= 0) {
                            laInted--;
                        } else {
                            laInted = 0;
                        }
                        ed_la.setText("" + laInted);

                    }
                });
                bu_n_me.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (meInted >= 0) {
                            meInted--;
                        } else {
                            meInted = 0;
                        }
                        ed_me.setText("" + meInted);
                    }
                });
                bu_n_sm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (smInted >= 0) {
                            smInted--;
                        } else {
                            smInted = 0;
                        }
                        ed_sm.setText("" + smInted);
                    }
                });
                bu_ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
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
                    Toast.makeText(getApplicationContext(), "actionSetting", Toast.LENGTH_SHORT).show();
                    NavUtils.navigateUpFromSameTask(this);
                    break;
                case R.id.activity_share:
                    Toast.makeText(getApplicationContext(), "share", Toast.LENGTH_SHORT).show();
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

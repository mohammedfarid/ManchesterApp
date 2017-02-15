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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import customs.CustomListView;
import menuscontant.CheeseManchester;
import menuscontant.ChickensManchester;
import menuscontant.ItalianPizzaManchester;
import menuscontant.MeatManchester;
import menuscontant.SeaFoodManchester;
import menuscontant.SweetManchester;

public class MenusFoodsActivity extends AppCompatActivity {

    final Context context = this;
    int intEd1 = 0, intEd2 = 0, intEd3 = 0, intEd4 = 0;
    int intTv1 = 0, intTv2 = 0, intTv3 = 0, intTv4 = 0;
    int intTotal = 0;
    EditText ed_1, ed_2, ed_3, ed_4;
    ListView androidListView;
    ListView collectPrice;
    ArrayAdapter<String> adapter;
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
    TextView tv_totalPrice;
    ArrayList<String> price;

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
        price = new ArrayList<String>();
        collectPrice = (ListView) findViewById(R.id.collect_id_price);
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, price);
        tv_totalPrice = (TextView) findViewById(R.id.totalPrice);


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
                final TextView text = (TextView) dialog.findViewById(R.id.title);
                ImageView imageView = (ImageView) dialog.findViewById(R.id.image);
                Button bu_n_1 = (Button) dialog.findViewById(R.id.n_1);
                Button bu_n_2 = (Button) dialog.findViewById(R.id.n_2);
                Button bu_n_3 = (Button) dialog.findViewById(R.id.n_3);
                Button bu_n_4 = (Button) dialog.findViewById(R.id.n_4);

                Button bu_p_1 = (Button) dialog.findViewById(R.id.p_1);
                Button bu_p_2 = (Button) dialog.findViewById(R.id.p_2);
                Button bu_p_3 = (Button) dialog.findViewById(R.id.p_3);
                Button bu_p_4 = (Button) dialog.findViewById(R.id.p_4);

                Button bu_ok = (Button) dialog.findViewById(R.id.bu_ok);

                final TextView tv_price_1 = (TextView) dialog.findViewById(R.id.price_1);
                final TextView tv_price_2 = (TextView) dialog.findViewById(R.id.price_2);
                TextView tv_price_3 = (TextView) dialog.findViewById(R.id.price_3);
                TextView tv_price_4 = (TextView) dialog.findViewById(R.id.price_4);

                final TextView tv_size_1 = (TextView) dialog.findViewById(R.id.show_size_1);
                final TextView tv_size_2 = (TextView) dialog.findViewById(R.id.show_size_2);
                final TextView tv_size_3 = (TextView) dialog.findViewById(R.id.show_size_3);
                final TextView tv_size_4 = (TextView) dialog.findViewById(R.id.show_size_4);

                intEd1 = 0;
                intEd2 = 0;
                intEd3 = 0;
                intEd4 = 0;

                ed_1 = (EditText) dialog.findViewById(R.id.ed_1);
                ed_1.setText("" + intEd1, TextView.BufferType.EDITABLE);
                ed_2 = (EditText) dialog.findViewById(R.id.ed_2);
                ed_2.setText("" + intEd2, TextView.BufferType.EDITABLE);
                ed_3 = (EditText) dialog.findViewById(R.id.ed_3);
                ed_3.setText("" + intEd3, TextView.BufferType.EDITABLE);
                ed_4 = (EditText) dialog.findViewById(R.id.ed_4);
                ed_4.setText("" + intEd4, TextView.BufferType.EDITABLE);

                LinearLayout layoutFirst = (LinearLayout) dialog.findViewById(R.id.li_1);
                LinearLayout layoutSecond = (LinearLayout) dialog.findViewById(R.id.li_2);
                LinearLayout layoutThird = (LinearLayout) dialog.findViewById(R.id.li_3);
                LinearLayout layoutFourth = (LinearLayout) dialog.findViewById(R.id.li_4);

                if (italianPizza) {
                    dialog.setTitle(italianPizzaManchester.title);
                    text.setText(italianPizzaManchester.listViewString[i]);
                    imageView.setImageResource(italianPizzaManchester.image);
                    if (i == 22 || i == 23) {
                        layoutSecond.setVisibility(LinearLayout.GONE);
                        layoutThird.setVisibility(LinearLayout.GONE);
                        layoutFourth.setVisibility(LinearLayout.GONE);
                        tv_size_1.setText("");
                        intTv1 = italianPizzaManchester.price_1[i];
                        tv_price_1.setText("" + intTv1 + "L.E");
                    } else {
                        layoutFourth.setVisibility(LinearLayout.GONE);
                        tv_size_1.setText("Large");
                        tv_size_2.setText("Medium");
                        tv_size_3.setText("Small");
                        intTv1 = italianPizzaManchester.price_1[i];
                        intTv2 = italianPizzaManchester.price_2[i];
                        intTv3 = italianPizzaManchester.price_3[i];
                        tv_price_1.setText("" + intTv1 + "L.E");
                        tv_price_2.setText("" + intTv2 + "L.E");
                        tv_price_3.setText("" + intTv3 + "L.E");
                    }

                }
                if (meatFood) {
                    dialog.setTitle(meatManchester.title);
                    text.setText(meatManchester.listViewString[i]);
                    imageView.setImageResource(meatManchester.image);
                    tv_size_1.setText("Small");
                    tv_size_2.setText("Large");
                    tv_size_3.setText("Cerip");
                    tv_size_4.setText("Sarokh");
                    intTv1 = meatManchester.price_1[i];
                    intTv2 = meatManchester.price_2[i];
                    intTv3 = meatManchester.price_3[i];
                    intTv4 = meatManchester.price_4[i];
                    tv_price_1.setText("" + intTv1 + "L.E");
                    tv_price_2.setText("" + intTv2 + "L.E");
                    tv_price_3.setText("" + intTv3 + "L.E");
                    tv_price_4.setText("" + intTv4 + "L.E");
                }
                if (chickenFood) {
                    dialog.setTitle(chickensManchester.title);
                    text.setText(chickensManchester.listViewString[i]);
                    imageView.setImageResource(chickensManchester.image);
                    tv_size_1.setText("Small");
                    tv_size_2.setText("Large");
                    tv_size_3.setText("Cerip");
                    tv_size_4.setText("Sarokh");
                    intTv1 = chickensManchester.price_1[i];
                    intTv2 = chickensManchester.price_2[i];
                    intTv3 = chickensManchester.price_3[i];
                    intTv4 = chickensManchester.price_4[i];
                    tv_price_1.setText("" + intTv1 + "L.E");
                    tv_price_2.setText("" + intTv2 + "L.E");
                    tv_price_3.setText("" + intTv3 + "L.E");
                    tv_price_4.setText("" + intTv4 + "L.E");
                }
                if (seaFood) {
                    dialog.setTitle(seaFoodManchester.title);
                    text.setText(seaFoodManchester.listViewString[i]);
                    imageView.setImageResource(seaFoodManchester.image);
                    intTv1 = seaFoodManchester.price_1[i];
                    intTv2 = seaFoodManchester.price_2[i];
                    intTv3 = seaFoodManchester.price_3[i];
                    intTv4 = seaFoodManchester.price_4[i];
                    tv_size_1.setText("Small");
                    tv_size_2.setText("Large");
                    tv_size_3.setText("Cerip");
                    tv_size_4.setText("Sarokh");
                    tv_price_1.setText("" + intTv1 + "L.E");
                    tv_price_2.setText("" + intTv2 + "L.E");
                    tv_price_3.setText("" + intTv3 + "L.E");
                    tv_price_4.setText("" + intTv4 + "L.E");
                }
                if (cheeseFood) {
                    dialog.setTitle(cheeseManchester.title);
                    text.setText(cheeseManchester.listViewString[i]);
                    imageView.setImageResource(cheeseManchester.image);
                    layoutSecond.setVisibility(LinearLayout.GONE);
                    layoutThird.setVisibility(LinearLayout.GONE);
                    layoutFourth.setVisibility(LinearLayout.GONE);
                    tv_size_1.setText("");
                    intTv1 = cheeseManchester.price_1[i];
                    tv_price_1.setText("" + intTv1 + "L.E");
                }
                if (sweetFood) {
                    dialog.setTitle(sweetManchester.title);
                    text.setText(sweetManchester.listViewString[i]);
                    imageView.setImageResource(sweetManchester.image);
                    layoutSecond.setVisibility(LinearLayout.GONE);
                    layoutThird.setVisibility(LinearLayout.GONE);
                    layoutFourth.setVisibility(LinearLayout.GONE);
                    tv_size_1.setText("");
                    intTv1 = sweetManchester.price_1[i];
                    tv_price_1.setText("" + intTv1 + "L.E");
                }
                bu_p_1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        intEd1++;
                        ed_1.setText("" + intEd1);
                    }
                });
                bu_p_2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        intEd2++;
                        ed_2.setText("" + intEd2);
                    }
                });
                bu_p_3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        intEd3++;
                        ed_3.setText("" + intEd3);
                    }
                });
                bu_p_4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        intEd4++;
                        ed_4.setText("" + intEd4);
                    }
                });
                bu_n_1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (intEd1 >= 1) {
                            intEd1--;
                        } else {
                            intEd1 = 0;
                        }
                        ed_1.setText("" + intEd1);

                    }
                });
                bu_n_2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (intEd2 >= 1) {
                            intEd2--;
                        } else {
                            intEd2 = 0;
                        }
                        ed_2.setText("" + intEd2);
                    }
                });
                bu_n_3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (intEd3 >= 1) {
                            intEd3--;
                        } else {
                            intEd3 = 0;
                        }
                        ed_3.setText("" + intEd3);
                    }
                });
                bu_n_4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (intEd4 >= 1) {
                            intEd4--;
                        } else {
                            intEd4 = 0;
                        }
                        ed_4.setText("" + intEd4);
                    }
                });
                bu_ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        /*Toast.makeText(getApplicationContext(),
                                "" + text.getText() +
                                        "\n" + tv_size_1.getText() + " " + intEd1 * intTv1 +
                                        "\n" + tv_size_2.getText() + " " + intEd2 * intTv2 +
                                        "\n" + tv_size_3.getText() + " " + intEd3 * intTv3 +
                                        "\n" + tv_size_4.getText() + " " + intEd4 * intTv4,
                                Toast.LENGTH_LONG).show();*/
                        if (intEd1 > 0) {
                            price.add(text.getText() + " "
                                    + tv_size_1.getText() + " " + intEd1 * intTv1);
                            intTotal += intEd1 * intTv1;
                        }
                        if (intEd2 > 0) {
                            price.add(text.getText() + " "
                                    + tv_size_2.getText() + " " + intEd2 * intTv2);
                            intTotal += intEd2 * intTv2;
                        }
                        if (intEd3 > 0) {
                            price.add(text.getText() + " "
                                    + tv_size_3.getText() + " " + intEd3 * intTv3);
                            intTotal += intEd3 * intTv3;
                        }
                        if (intEd4 > 0) {
                            price.add(text.getText() + " "
                                    + tv_size_4.getText() + " " + intEd4 * intTv4);
                            intTotal += intEd4 * intTv4;
                        }
                        Toast.makeText(getApplicationContext(), "المجموع" + intTotal, Toast.LENGTH_LONG).show();
                        collectPrice.setAdapter(adapter);
                        tv_totalPrice.setText("المجموع : "+intTotal);
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

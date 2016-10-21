package com.farid.mohammed.manchesterapp;

import android.content.Context;

/**
 * Created by Mohammed on 10/10/2016.
 */

public class ItalianPizzaManchester {
    public String title ;
    public String [] listViewString;
    public ItalianPizzaManchester(Context context){
        this.title = context.getResources().getString(R.string.italian_pizza);
        this.listViewString = context.getResources().getStringArray(R.array.italian_pizza_array);
    }
}

package com.farid.mohammed.manchesterapp;

import android.content.Context;

/**
 * Created by Mohammed on 10/10/2016.
 */

public class SweetManchester {
    public String title ;
    public String [] listViewString;
    public SweetManchester(Context context){
        this.title = context.getResources().getString(R.string.sweet_man);
        this.listViewString = context.getResources().getStringArray(R.array.sweet_man_array);
    }

}

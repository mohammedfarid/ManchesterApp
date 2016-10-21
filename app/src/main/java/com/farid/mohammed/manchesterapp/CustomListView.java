package com.farid.mohammed.manchesterapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Mohammed on 04/10/2016.
 */

public class CustomListView extends BaseAdapter {

    private Context mContext;
    private final String[] listViewString;
    //private final int[] listViewImageId;
    private static LayoutInflater inflater=null;

    public CustomListView(Context context, String[] listViewString) {
        // TODO Auto-generated constructor stub
        this.listViewString=listViewString;
        mContext=context;
        //this.listViewImageId=listViewImageId;
        this.inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {return listViewString.length;}

    @Override
    public Object getItem(int position) {return position;}

    @Override
    public long getItemId(int position) {return position;}

    public class Holder
    {
        TextView tv;
        //ImageView img;
        //CheckBox sm,me,la;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Holder holder=new Holder();
        View listViewAndroid;
        if (convertView==null){
            listViewAndroid = new View(mContext);
            listViewAndroid = inflater.inflate(R.layout.program_list, parent,false);
        }else{
            listViewAndroid = (View) convertView;
        }

        holder.tv=(TextView) listViewAndroid.findViewById(R.id.textView1);
        //holder.img=(ImageView) listViewAndroid.findViewById(R.id.imageView1);
        //holder.sm = (CheckBox) listViewAndroid.findViewById(R.id.small_size);
        //holder.me = (CheckBox) listViewAndroid.findViewById(R.id.medium_size);
        //holder.la = (CheckBox) listViewAndroid.findViewById(R.id.large_size);
        holder.tv.setText(listViewString[position]);
        //holder.img.setImageResource(listViewImageId[position]);
        return listViewAndroid;
    }
}

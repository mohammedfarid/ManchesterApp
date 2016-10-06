package com.farid.mohammed.manchesterapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Mohammed on 04/10/2016.
 */

public class CustomListView extends BaseAdapter {

    private Context mContext;
    private final String[] listViewString;
    private final int[] listViewImageId;

    private static LayoutInflater inflater=null;
    public CustomListView(Context context, String[] prgmNameList, int[] prgmImages) {
        // TODO Auto-generated constructor stub
        listViewString=prgmNameList;
        mContext=context;
        listViewImageId=prgmImages;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return listViewString.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public class Holder
    {
        TextView tv;
        ImageView img;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder=new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.program_list, null);
        holder.tv=(TextView) rowView.findViewById(R.id.textView1);
        holder.img=(ImageView) rowView.findViewById(R.id.imageView1);
        holder.tv.setText(listViewString[position]);
        holder.img.setImageResource(listViewImageId[position]);
        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(mContext, "You Clicked "+listViewString[position], Toast.LENGTH_LONG).show();
            }
        });
        return rowView;
    }
}

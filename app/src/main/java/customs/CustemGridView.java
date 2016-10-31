package customs;

import android.widget.ArrayAdapter;
import android.view.LayoutInflater;
import android.content.Context;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.ViewGroup;
import android.view.View;

import com.farid.mohammed.manchesterapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mohammed on 01/10/2016.
 */

public class CustemGridView extends BaseAdapter {
    private Context mContext;
    private final String[] gridViewString;
    private final int[] gridViewImageId;
    private static LayoutInflater inflater=null;

    public CustemGridView(Context context, String[] gridViewString, int[] gridViewImageId) {
        mContext = context;
        this.gridViewImageId = gridViewImageId;
        this.gridViewString = gridViewString;
        this.inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return gridViewString.length;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    public class Holder
    {
        TextView tv;
        ImageView img;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        View gridViewAndroid;
        if (convertView == null) {
            gridViewAndroid = new View(mContext);
            gridViewAndroid = inflater.inflate(R.layout.listview_with_text_image, parent,false);

        } else {
            gridViewAndroid = (View) convertView;
        }
        TextView textViewAndroid = (TextView) gridViewAndroid.findViewById(R.id.android_gridview_text);
        ImageView imageViewAndroid = (ImageView) gridViewAndroid.findViewById(R.id.android_gridview_image);
        textViewAndroid.setText(gridViewString[i]);
        imageViewAndroid.setImageResource(gridViewImageId[i]);
        return gridViewAndroid;
    }
}

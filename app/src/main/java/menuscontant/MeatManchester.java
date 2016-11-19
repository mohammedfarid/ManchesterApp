package menuscontant;

import android.content.Context;

import com.farid.mohammed.manchesterapp.R;

/**
 * Created by Mohammed on 10/10/2016.
 */

public class MeatManchester {
    public String title;
    public String[] listViewString;
    public int image = R.mipmap.ic_launcher;
    public int[] price_1 = {5, 6, 6, 7, 6, 6, 7, 6, 8, 5, 8, 8, 6, 9};
    public int[] price_2 = {0, 9, 9, 10, 9, 9, 10, 9, 11, 8, 11, 11, 9, 12};
    public int[] price_3 = {12, 0, 0, 12, 12, 12, 13, 14, 14, 12, 14, 14, 12, 15};
    public int[] price_4 = {0, 0, 0, 0, 0, 15, 16, 17, 17, 15, 17, 17, 15, 18};

    public MeatManchester(Context context) {
        this.title = context.getResources().getString(R.string.meat_man);
        this.listViewString = context.getResources().getStringArray(R.array.meat_man_array);
    }
}

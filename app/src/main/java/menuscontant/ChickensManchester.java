package menuscontant;

import android.content.Context;

import com.farid.mohammed.manchesterapp.R;

/**
 * Created by Mohammed on 10/10/2016.
 */

public class ChickensManchester {
    public String title;

    public String[] listViewString;
    public int image = R.mipmap.ic_launcher;
    public int[] price_1 = {7, 8, 8, 8, 10, 10, 12, 12, 12, 10, 10, 10, 12, 6, 12};
    public int[] price_2 = {10, 12, 11, 11, 13, 13, 15, 16, 16, 13, 13, 14, 15, 8, 15};
    public int[] price_3 = {12, 15, 14, 14, 16, 15, 17, 17, 17, 14, 17, 16, 17, 14, 17};
    public int[] price_4 = {0, 19, 18, 18, 20, 18, 20, 20, 20, 18, 20, 20, 20, 18, 20};

    public ChickensManchester(Context context) {
        this.title = context.getResources().getString(R.string.chick_man);
        this.listViewString = context.getResources().getStringArray(R.array.chick_man_array);
    }
}

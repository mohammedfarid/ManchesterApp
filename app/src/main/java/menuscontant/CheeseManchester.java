package menuscontant;

import android.content.Context;

import com.farid.mohammed.manchesterapp.R;

/**
 * Created by Mohammed on 10/10/2016.
 */

public class CheeseManchester {
    public String title;
    public String[] listViewString;
    public int image = R.mipmap.cheese;
    public int[] price_1 = {8, 8, 8, 8, 12};

    public CheeseManchester(Context context) {
        this.title = context.getResources().getString(R.string.cheese_man);
        this.listViewString = context.getResources().getStringArray(R.array.cheese_man_array);

    }
}

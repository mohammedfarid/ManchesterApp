package menuscontant;

import android.content.Context;

import com.farid.mohammed.manchesterapp.R;

/**
 * Created by Mohammed on 10/10/2016.
 */

public class SeaFoodManchester {
    public String title;
    public String[] listViewString;
    public int image = R.mipmap.ic_launcher;
    public int[] price_1 = {14, 12, 16};
    public int[] price_2 = {18, 16, 20};
    public int[] price_3 = {20, 18, 22};
    public int[] price_4 = {22, 20, 25};

    public SeaFoodManchester(Context context) {
        this.title = context.getResources().getString(R.string.sea_food_man);
        this.listViewString = context.getResources().getStringArray(R.array.sea_food_man_array);
    }
}

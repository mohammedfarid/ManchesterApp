package menuscontant;

import android.content.Context;

import com.farid.mohammed.manchesterapp.R;

/**
 * Created by Mohammed on 10/10/2016.
 */

public class ItalianPizzaManchester {
    public String title;
    public String[] listViewString;
    public int image = R.mipmap.pizza;
    public int[] price_1 = {25, 25, 25, 30, 30, 30, 35, 35, 35, 35, 45, 50, 45, 50, 50, 55, 45, 50, 60, 55, 55, 60, 5, 10};
    public int[] price_2 = {20, 20, 20, 25, 25, 25, 30, 30, 30, 30, 35, 40, 35, 40, 40, 45, 40, 45, 50, 45, 45, 50, 5, 10};
    public int[] price_3 = {15, 15, 15, 20, 20, 20, 25, 25, 25, 25, 30, 35, 30, 35, 35, 40, 35, 40, 40, 35, 35, 40, 5, 10};

    public ItalianPizzaManchester(Context context) {
        this.title = context.getResources().getString(R.string.italian_pizza);
        this.listViewString = context.getResources().getStringArray(R.array.italian_pizza_array);

    }
}

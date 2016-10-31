package menuscontant;

import android.content.Context;

import com.farid.mohammed.manchesterapp.R;

/**
 * Created by Mohammed on 10/10/2016.
 */

public class SeaFoodManchester {
    public String title ;
    public String [] listViewString;
    public SeaFoodManchester(Context context){
        this.title = context.getResources().getString(R.string.sea_food_man);
        this.listViewString = context.getResources().getStringArray(R.array.sea_food_man_array);
    }
}

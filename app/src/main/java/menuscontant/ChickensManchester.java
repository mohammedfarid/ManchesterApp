package menuscontant;

import android.content.Context;

import com.farid.mohammed.manchesterapp.R;

/**
 * Created by Mohammed on 10/10/2016.
 */

public class ChickensManchester {
    public String title ;

    public String [] listViewString;
    public ChickensManchester(Context context){
        this.title = context.getResources().getString(R.string.chick_man);
        this.listViewString = context.getResources().getStringArray(R.array.chick_man_array);
    }
}
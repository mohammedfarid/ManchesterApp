package menuscontant;

import android.content.Context;

import com.farid.mohammed.manchesterapp.R;

/**
 * Created by Mohammed on 10/10/2016.
 */

public class MeatManchester {
    public String title ;
    public String [] listViewString;
    public MeatManchester(Context context){
        this.title = context.getResources().getString(R.string.meat_man);
        this.listViewString = context.getResources().getStringArray(R.array.meat_man_array);
    }
}

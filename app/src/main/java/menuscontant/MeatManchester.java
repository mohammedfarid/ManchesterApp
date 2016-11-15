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
    public int[] laPrice = {20, 24, 33, 11, 22};
    public int[] mePrice = {20, 24, 22, 11, 22};
    public int[] smPrice = {20, 24, 11, 11, 22};

    public MeatManchester(Context context) {
        this.title = context.getResources().getString(R.string.meat_man);
        this.listViewString = context.getResources().getStringArray(R.array.meat_man_array);
    }
}

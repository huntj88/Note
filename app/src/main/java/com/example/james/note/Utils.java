package com.example.james.note;

import android.content.res.Resources;
import android.util.TypedValue;

/**
 * Created by James on 3/17/2017.
 */

public class Utils {

    public static int dpToPx(int dp)
    {
        return(int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, Resources.getSystem().getDisplayMetrics());
    }
}

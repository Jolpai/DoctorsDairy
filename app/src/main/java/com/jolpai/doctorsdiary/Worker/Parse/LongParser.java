package com.jolpai.doctorsdiary.Worker.Parse;

import android.util.Log;

/**
 * Created by User on 3/9/2017.
 */

public class LongParser {

    public static long parseStrToLong(String string){
        long number =0;
        try{
            number=Long.parseLong(string);
        }catch (NumberFormatException ex){
            Log.e("EX" , ex.toString());
        }
        return number;
    }
}

package com.jolpai.doctorsdiary.Worker.Parse;

import android.util.Log;

/**
 * Created by User on 11/19/2016.
 */

public class IntParser {

    public static int parseStrToInt(String string){
        if(string.equalsIgnoreCase(""))
            return 0;
        try{
            return Integer.parseInt(string);
        }catch (NumberFormatException ex){
            Log.e("EX",ex.toString());
        }
        return 0;

    }
}

package com.jolpai.doctorsdiary.Worker;

import android.util.Log;

/**
 * Created by User on 11/19/2016.
 */

public class IntParser {

    public static int StrToInt(String string){
        int number=0;
        try{
            number=Integer.parseInt(string);
        }catch (NumberFormatException ex){
            Log.e("EX",ex.toString());
        }

        return number;

    }
}

package com.jolpai.doctorsdiary.Worker.Parse;

import android.icu.text.NumberFormat;
import android.util.Log;

/**
 * Created by User on 11/25/2016.
 */

public class StrParser {


    public static String parseIntToString(int strValue){
        if(strValue==0)
            return "";
        try{
            return Integer.toString(strValue);
        }catch (NumberFormatException ex){
            Log.e("EX",ex.toString());
        }
        return "";
    }

    public static String parseDoubleToString(double strValue){
        if(strValue==0.0)
            return "";
        try{
            return Double.toString(strValue);
        }catch (NumberFormatException ex){
            Log.e("EX",ex.toString());
        }
        return "";
    }

    public static String parseNumberToString(Number number){
        return number+"";
    }
}

package com.jolpai.doctorsdiary.Model.Worker.Parse;

import android.util.Log;

/**
 * Created by User on 11/19/2016.
 */

public class DoubleParser implements I_DoubleParser{

    public static double parseStrToDouble(String string){
        Double number =0.0;
        try{
            number=Double.parseDouble(string);
        }catch (NumberFormatException ex){
            Log.e("EX" , ex.toString());
        }
        return number;
    }

    @Override
    public double parseStrToDouble() {
        return 0;
    }
}

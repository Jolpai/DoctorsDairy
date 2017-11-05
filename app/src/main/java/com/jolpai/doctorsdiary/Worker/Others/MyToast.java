package com.jolpai.doctorsdiary.Worker.Others;

import android.widget.Toast;

import com.jolpai.doctorsdiary.App;

/**
 * Created by User on 1/25/2017.
 */

public class MyToast {

    public static void toast_short(String msg){
        Toast.makeText(App.context,msg,Toast.LENGTH_SHORT).show();
    }

    public static void toast_long(String msg){
        Toast.makeText(App.context,msg,Toast.LENGTH_SHORT).show();
    }

    public static void toast_red(String msg){
        Toast.makeText(App.context,msg,Toast.LENGTH_SHORT).show();
    }

    public static void toast_amber(String msg){
        Toast.makeText(App.context,msg,Toast.LENGTH_SHORT).show();
    }

    public static void toast_green(String msg){
        Toast.makeText(App.context,msg,Toast.LENGTH_SHORT).show();
    }

    public static void toast_error(String msg){
        Toast.makeText(App.context,msg,Toast.LENGTH_SHORT).show();
    }
}

package com.jolpai.doctorsdiary.IO.custom_view;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;

import java.util.Random;

import static android.R.attr.centerColor;
import static android.R.attr.endColor;
import static android.R.attr.startColor;

/**
 * Created by User on 10/13/2016.
 */

public class MyStyle {

    public  Drawable getShape(){

        GradientDrawable gradientDrawable =
                new GradientDrawable(GradientDrawable.Orientation.TL_BR, new int[] {
                        startColor, centerColor, endColor
                });
        gradientDrawable.setGradientType(GradientDrawable.LINEAR_GRADIENT);
        gradientDrawable.setCornerRadii(this.getRandomFloatArray());
        gradientDrawable.setGradientCenter(0.0f, 0.45f);

        return gradientDrawable;
    }

    private float [] getRandomFloatArray(){
        Random rnd = new Random();
        float[] floats = new float[8];
        for (int i =0; i < floats.length; i++){
            floats[i] = rnd.nextInt(45);
        }
        return floats;
    }

}

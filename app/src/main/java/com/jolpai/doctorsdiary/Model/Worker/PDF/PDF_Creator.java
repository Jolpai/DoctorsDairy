package com.jolpai.doctorsdiary.Model.Worker.PDF;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;

/**
 * Created by Tanim reja on 12/1/2016.
 */

public class PDF_Creator {


    public static void pdfGenerate(View v){
        Bitmap b = Bitmap.createBitmap( v.getLayoutParams().width, v.getLayoutParams().height, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(b);
        v.layout(v.getLeft(), v.getTop(), v.getRight(), v.getBottom());
        v.draw(c);
    }
}

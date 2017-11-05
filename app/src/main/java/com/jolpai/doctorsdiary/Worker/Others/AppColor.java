package com.jolpai.doctorsdiary.Worker.Others;

import com.jolpai.doctorsdiary.App;
import com.jolpai.doctorsdiary.R;

/**
 * Created by User on 10/30/2017.
 */

public class AppColor {
    private static final AppColor ourInstance = new AppColor();
    private int toolbarColor,
            toolbarTextColor,
            white,
            amber_500,
            green_500,
            blue_500,
            green_hangout,
            blue_a_400;

    public static AppColor getInstance() {
        return ourInstance;
    }

    private AppColor() {
        white= App.context.getResources().getColor(R.color.white);
        amber_500=App.context.getResources().getColor(R.color.amber_500);
        green_500=App.context.getResources().getColor(R.color.green_500);
        blue_500=App.context.getResources().getColor(R.color.blue_500);
        blue_a_400=App.context.getResources().getColor(R.color.blue_a_400);
        green_hangout=App.context.getResources().getColor(R.color.green_hangout);
    }

    public static AppColor getOurInstance() {
        return ourInstance;
    }

    public int getToolbarColor() {
        return toolbarColor;
    }

    public int getToolbarTextColor() {
        return toolbarTextColor;
    }

    public int getWhite() {
        return white;
    }

    public int getAmber_500() {
        return amber_500;
    }

    public int getGreen_500() {
        return green_500;
    }

    public int getBlue_500() {
        return blue_500;
    }

    public int getGreen_hangout() {
        return green_hangout;
    }

    public int getBlue_a_400() {
        return blue_a_400;
    }
}

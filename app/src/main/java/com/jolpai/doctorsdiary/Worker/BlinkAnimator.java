package com.jolpai.doctorsdiary.Worker;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

/**
 * Created by User on 11/30/2016.
 */

public class BlinkAnimator {

    public static Animation blink(){
        Animation anim = new AlphaAnimation(0.8f, 1.0f);
        anim.setDuration(500); //You can manage the blinking time with this parameter
        anim.setStartOffset(20);
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(Animation.INFINITE);

        return anim;
    }
}

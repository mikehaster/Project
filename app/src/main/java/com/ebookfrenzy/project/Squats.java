package com.ebookfrenzy.project;

/**
 * Created by mikeh_000 on 4/23/2016.
 */
import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.ebookfrenzy.project.R;

import java.util.ArrayList;
import java.util.List;

public class Squats extends Activity
{

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.content_squats);



        // simple_animation occurs at animationLocation within layout/main
        ImageView animationLocation = (ImageView)findViewById(R.id.squats);
        animationLocation.setBackgroundResource(R.drawable.simple_animation);

        // animationHandler caused animationStart 100 milliseconds from now
        Handler animationHandler = new Handler();
        AnimationStart animationStart = new AnimationStart();
        animationHandler.postAtTime(animationStart, SystemClock.uptimeMillis() + 100);

        // animationHandler caused animationStop 5000 milliseconds from now
        AnimationStop animationStop = new AnimationStop();
        animationHandler.postAtTime(animationStop, SystemClock.uptimeMillis() + 5000);
    }

    class AnimationStart implements Runnable
    {
        public void run()
        // The animation at simple_anim started
        {
            ImageView animationLocation = (ImageView)findViewById(R.id.squats);
            AnimationDrawable frameAnimation =
                    (AnimationDrawable) animationLocation.getBackground();
            frameAnimation.start();
        }
    }

    class AnimationStop implements Runnable
            // The animation at simple_anim stopped
    {
        public void run()
        {
            ImageView animationLocation = (ImageView)findViewById(R.id.squats);
            AnimationDrawable frameAnimation =
                    (AnimationDrawable) animationLocation.getBackground();
            frameAnimation.stop();
        }
    }
}
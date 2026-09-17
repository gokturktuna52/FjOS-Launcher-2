package com.fjos.launcher;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextClock;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout screen = new LinearLayout(this);
        screen.setOrientation(LinearLayout.VERTICAL);
        screen.setGravity(Gravity.CENTER);
        screen.setPadding(40, 40, 40, 40);
        screen.setBackgroundColor(Color.rgb(3, 15, 28));

        TextView logo = new TextView(this);
        logo.setText("FjOS");
        logo.setTextColor(Color.rgb(41, 182, 246));
        logo.setTextSize(64);
        logo.setGravity(Gravity.CENTER);

        TextClock clock = new TextClock(this);
        clock.setFormat24Hour("HH:mm");
        clock.setTextColor(Color.WHITE);
        clock.setTextSize(72);
        clock.setGravity(Gravity.CENTER);

        TextClock date = new TextClock(this);
        date.setFormat24Hour("dd MMMM yyyy • EEEE");
        date.setTextColor(Color.LTGRAY);
        date.setTextSize(22);
        date.setGravity(Gravity.CENTER);

        TextView slogan = new TextView(this);
        slogan.setText("\nHIZ • ÖZGÜRLÜK • SENİN İÇİN\n\nFjOS Launcher 0.1\nHONOR Pad X9");
        slogan.setTextColor(Color.WHITE);
        slogan.setTextSize(20);
        slogan.setGravity(Gravity.CENTER);

        screen.addView(logo);
        screen.addView(clock);
        screen.addView(date);
        screen.addView(slogan);

        setContentView(screen);
    }
}

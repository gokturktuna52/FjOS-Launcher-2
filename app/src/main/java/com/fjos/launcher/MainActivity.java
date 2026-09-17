package com.fjos.launcher;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextClock;
import android.widget.TextView;
import java.util.List;

public class MainActivity extends Activity {

    private int dp(int value) {
        return (int) (value * getResources().getDisplayMetrics().density);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setPadding(dp(24), dp(20), dp(24), dp(20));
        root.setBackgroundColor(Color.rgb(3, 15, 28));

        TextView logo = new TextView(this);
        logo.setText("FjOS");
        logo.setTextColor(Color.rgb(41, 182, 246));
        logo.setTextSize(36);
        logo.setGravity(Gravity.CENTER);

        TextClock clock = new TextClock(this);
        clock.setFormat24Hour("HH:mm");
        clock.setTextColor(Color.WHITE);
        clock.setTextSize(42);
        clock.setGravity(Gravity.CENTER);

        TextClock date = new TextClock(this);
        date.setFormat24Hour("dd MMMM yyyy • EEEE");
        date.setTextColor(Color.LTGRAY);
        date.setTextSize(16);
        date.setGravity(Gravity.CENTER);

        TextView title = new TextView(this);
        title.setText("\nUYGULAMALAR");
        title.setTextColor(Color.WHITE);
        title.setTextSize(17);
        title.setGravity(Gravity.CENTER);

        root.addView(logo);
        root.addView(clock);
        root.addView(date);
        root.addView(title);

        ScrollView scroll = new ScrollView(this);

        GridLayout grid = new GridLayout(this);
        grid.setColumnCount(5);
        grid.setPadding(0, dp(16), 0, dp(16));

        Intent queryIntent = new Intent(Intent.ACTION_MAIN, null);
        queryIntent.addCategory(Intent.CATEGORY_LAUNCHER);

        PackageManager pm = getPackageManager();
        List<ResolveInfo> apps = pm.queryIntentActivities(queryIntent, 0);

        for (ResolveInfo info : apps) {
            if (info.activityInfo.packageName.equals(getPackageName())) {
                continue;
            }

            LinearLayout item = new LinearLayout(this);
            item.setOrientation(LinearLayout.VERTICAL);
            item.setGravity(Gravity.CENTER);
            item.setPadding(dp(8), dp(10), dp(8), dp(10));

            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
            params.width = 0;
            params.height = GridLayout.LayoutParams.WRAP_CONTENT;
            params.columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f);
            item.setLayoutParams(params);

            ImageView icon = new ImageView(this);
            Drawable drawable = info.loadIcon(pm);
            icon.setImageDrawable(drawable);

            LinearLayout.LayoutParams iconParams =
                    new LinearLayout.LayoutParams(dp(52), dp(52));
            icon.setLayoutParams(iconParams);

            TextView name = new TextView(this);
            name.setText(info.loadLabel(pm));
            name.setTextColor(Color.WHITE);
            name.setTextSize(12);
            name.setGravity(Gravity.CENTER);
            name.setMaxLines(2);

            final String packageName = info.activityInfo.packageName;

            item.setOnClickListener(v -> {
                Intent launch = pm.getLaunchIntentForPackage(packageName);
                if (launch != null) {
                    startActivity(launch);
                }
            });

            item.addView(icon);
            item.addView(name);
            grid.addView(item);
        }

        scroll.addView(grid);

        LinearLayout.LayoutParams scrollParams =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        0,
                        1f
                );

        root.addView(scroll, scrollParams);

        TextView footer = new TextView(this);
        footer.setText("FjOS Launcher 0.2");
        footer.setTextColor(Color.GRAY);
        footer.setGravity(Gravity.CENTER);
        footer.setPadding(0, dp(8), 0, 0);
        root.addView(footer);

        setContentView(root);
    }
}

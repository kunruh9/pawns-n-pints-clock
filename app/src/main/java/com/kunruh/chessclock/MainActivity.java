package com.kunruh.chessclock;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView timer1 = (TextView) findViewById(R.id.timer1);

        final long startTime = System.currentTimeMillis();
        final long time = 1000 * 30;

        ScheduledExecutorService timeRunner = Executors.newSingleThreadScheduledExecutor();

        timeRunner.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        long timePassed = System.currentTimeMillis() - startTime;
                        timer1.setText(String.valueOf(time - timePassed));
                    }
                });
            }
        }, 0, 100, TimeUnit.MILLISECONDS);
    }
}

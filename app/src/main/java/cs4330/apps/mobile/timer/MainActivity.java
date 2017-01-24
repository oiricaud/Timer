package cs4330.apps.mobile.timer;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import android.os.Handler;


public class MainActivity extends AppCompatActivity {
    long startTime;
    TextView timerPlacement;
    long countUp;
    //we are going to use a handler to be able to run in our TimerTask
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpButtons();
        //TimerApplet();
    }

    private void setUpButtons() {
        new java.util.Date();
        Button startButton = (Button) findViewById(R.id.StartTimer);
        Button stopButton = (Button) findViewById(R.id.StopTimer);
        startButton.setText("Start");
        stopButton.setText("Stop");
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                long temp = System.currentTimeMillis();
                Chronometer stopWatch = (Chronometer) findViewById(R.id.chrono);
                startTime = SystemClock.elapsedRealtime();
                timerPlacement = (TextView) findViewById(R.id.timerPlacement);
                stopWatch.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
                    @Override
                    public void onChronometerTick(Chronometer arg0) {
                        countUp = (SystemClock.elapsedRealtime() - arg0.getBase()) / 1000;
                        String asText = (countUp / 60) + ":" + (countUp % 60);
                        timerPlacement.setText(asText);
                    }
                });
                stopWatch.start();
            }
        });
    }
}




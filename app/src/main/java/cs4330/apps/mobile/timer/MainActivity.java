package cs4330.apps.mobile.timer;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

/** An Android Application that allows users to use a timer.
 * @author Oscar I. Ricaud
 * Homework 1 - Note Applets have been outdated... used Android Studio to develop the app.
 * @version 1.0
 */
public class MainActivity extends AppCompatActivity {
    long startTime;
    long countUp;
    long stopTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpButtons();
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
                Chronometer stopWatch = (Chronometer) findViewById(R.id.chrono);
                startTime = SystemClock.elapsedRealtime();
                stopWatch.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
                    @Override
                    public void onChronometerTick(Chronometer arg0) {
                        countUp = (SystemClock.elapsedRealtime() - arg0.getBase()) / 1000;
                        String asText = (countUp / 60) + ":" + (countUp % 60);
                    }
                });
                stopWatch.start();
            }
        });
        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Chronometer stopWatch = (Chronometer) findViewById(R.id.chrono);
                startTime = SystemClock.elapsedRealtime();
                stopWatch.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
                    @Override
                    public void onChronometerTick(Chronometer arg0) {
                        countUp = (SystemClock.elapsedRealtime() - arg0.getBase()) / 1000;
                        String asText = (countUp / 60) + ":" + (countUp % 60);
                    }
                });
                stopWatch.stop();
            }
        });
    }
}

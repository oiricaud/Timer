package cs4330.apps.mobile.timer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


/** An Android Application that allows users to use a timer.
 * @author Oscar I. Ricaud
 * @version 1.0
 */
public class MainActivity extends AppCompatActivity {
    private TextView timerDisplay;
    private Button startButton;
    private Button stopButton;
    TimerModel timer = new TimerModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timerDisplay = (TextView) findViewById(R.id.textView);
        startButton = (Button) findViewById(R.id.startButton);
        stopButton = (Button) findViewById(R.id.stopButton);
        stopButton.setEnabled(false);
        displayTime();
    }

    /**
     * Called when the start button is clicked.
     */
    public void startClicked(View view) {
        startButton.setEnabled(false);
        stopButton.setEnabled(true);
        timer.start();
        new Thread(() -> {
            while (timer.isRunning()) {
                MainActivity.this.runOnUiThread(MainActivity.this::displayTime);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException ignored) {
                }
            }
        }).start();
    }

    /**
     * Called when the stop button is clicked.
     */
    public void stopClicked(View view) {
        startButton.setEnabled(true);
        stopButton.setEnabled(false);
        timer.stop();
    }

    private void displayTime() {
        long sec = timer.elapsedTime() / 1000;
        long min = sec / 60;
        long hour = min / 60;
        sec = sec % 60;
        min = min % 60;
        String time = String.format("%d:%02d:%02d", hour, min, sec);
        timerDisplay.setText(time);
    }
}
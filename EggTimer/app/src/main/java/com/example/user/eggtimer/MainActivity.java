package com.example.user.eggtimer;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    SeekBar timerSeekBar;

    TextView timerTextView;
    Button controlButton;
    Boolean countIsActice = false;
    CountDownTimer countDownTimer;

    public void resetTimer(){
        timerTextView.setText("00:30");
        timerSeekBar.setProgress(30);
        timerSeekBar.setEnabled(true);
        countDownTimer.cancel();
        controlButton.setText("GO!");
        countIsActice = false;
    }
    public void updateTimer(int secondLeft) {
        int minutes = (Integer) secondLeft / 60;
        int seconds = (Integer) secondLeft - minutes * 60;
        String Minutes = Integer.toString(minutes);
        String secondString = Integer.toString(seconds);
        if (seconds <= 9) {
            secondString = "0" + secondString;
        }
        if (minutes <= 9) {
            Minutes = "0" + Minutes;
        }
        timerTextView.setText(Minutes + ":" + secondString);
    }

    public void controlTimer(View view) {
        if (countIsActice == false) {
            countIsActice = true;
            timerSeekBar.setEnabled(false);
            controlButton.setText("STOP");
            countDownTimer = new CountDownTimer(timerSeekBar.getProgress() * 1000 + 500, 1000) {

                @Override
                public void onTick(long millisUntilFinished) {
                    updateTimer((int) millisUntilFinished / 1000);
                }

                @Override
                public void onFinish() {
                   resetTimer();
                    MediaPlayer mplayer = MediaPlayer.create(getApplicationContext(), R.raw.music);
                    mplayer.start();
                }
            }.start();

        }else {
            resetTimer();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        controlButton = (Button)findViewById(R.id.controllButton);
        timerSeekBar = (SeekBar)findViewById(R.id.timerSeekBar);
        timerTextView = (TextView)findViewById(R.id.timerTextView);
        timerSeekBar.setMax(600);
        timerSeekBar.setProgress(30);

        timerSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                updateTimer(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}

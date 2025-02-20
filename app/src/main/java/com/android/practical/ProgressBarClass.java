package com.android.practical;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ProgressBarClass extends AppCompatActivity {

        private ProgressBar progressBarIndeterminate, progressBarDeterminate;
        private Button startButton;
        private int progressStatus = 0;
        private Handler handler = new Handler();

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_progress_bar);

            // Initialize UI elements
            progressBarIndeterminate = findViewById(R.id.progressBarIndeterminate);
            progressBarDeterminate = findViewById(R.id.progressBarDeterminate);
            startButton = findViewById(R.id.startButton);

            startButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startProgress();
                }
            });
        }

        private void startProgress() {
            // Show indeterminate progress bar
            progressBarIndeterminate.setVisibility(View.VISIBLE);

            // Reset progress
            progressStatus = 0;
            progressBarDeterminate.setProgress(0);

            // Simulate a background task with a delay
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (progressStatus < 100) {
                        progressStatus += 10;
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                progressBarDeterminate.setProgress(progressStatus);
                            }
                        });
                        try {
                            Thread.sleep(500); // Delay to simulate work
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    // Hide indeterminate progress bar after completion
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            progressBarIndeterminate.setVisibility(View.GONE);
                            Toast.makeText(ProgressBarClass.this, "Progress Completed!", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }).start();
        }
    }
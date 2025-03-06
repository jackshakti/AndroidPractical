package com.android.practical;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DateTimePickerActivity extends AppCompatActivity {

        Button btnDate, btnTime;
        TextView tvDateTime;
        int year, month, day, hour, minute;
        Calendar calendar;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_date_time_picker);

            btnDate = findViewById(R.id.btnDate);
            btnTime = findViewById(R.id.btnTime);
            tvDateTime = findViewById(R.id.tvDateTime);

            calendar = Calendar.getInstance();

            // Get current date and time
            year = calendar.get(Calendar.YEAR);
            month = calendar.get(Calendar.MONTH);
            day = calendar.get(Calendar.DAY_OF_MONTH);
            hour = calendar.get(Calendar.HOUR_OF_DAY);
            minute = calendar.get(Calendar.MINUTE);

            // Date Picker
            btnDate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DatePickerDialog datePickerDialog = new DatePickerDialog(DateTimePickerActivity.this,
                            new DatePickerDialog.OnDateSetListener() {
                                @Override
                                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                    tvDateTime.setText("Date: " + dayOfMonth + "/" + (month + 1) + "/" + year);
                                }
                            }, year, month, day);
                    datePickerDialog.show();
                }
            });

            // Time Picker
            btnTime.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TimePickerDialog timePickerDialog = new TimePickerDialog(DateTimePickerActivity.this,
                            new TimePickerDialog.OnTimeSetListener() {
                                @Override
                                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                    String currentText = tvDateTime.getText().toString();
                                    tvDateTime.setText(currentText + "\nTime: " + hourOfDay + ":" + minute);
                                }
                            }, hour, minute, true);
                    timePickerDialog.show();
                }
            });
        }
    }
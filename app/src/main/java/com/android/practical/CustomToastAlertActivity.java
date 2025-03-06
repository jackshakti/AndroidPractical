package com.android.practical;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CustomToastAlertActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_custom_toast_alert);

            // Button to trigger custom toast
            Button btnShowToast = findViewById(R.id.btn_show_toast);
            btnShowToast.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showCustomToast("Hello! This is a Custom Toast.", R.drawable.ic_launcher_foreground);
                }
            });
        }

        private void showCustomToast(String message, int iconResId) {
            // Inflate custom layout
            LayoutInflater inflater = getLayoutInflater();
            View layout = inflater.inflate(R.layout.custom_toast, findViewById(R.id.toast_root));

            // Set message text
            TextView text = layout.findViewById(R.id.toast_message);
            text.setText(message);

            // Set icon
            ImageView icon = layout.findViewById(R.id.toast_icon);
            icon.setImageResource(iconResId);

            // Create and show the toast
            Toast toast = new Toast(getApplicationContext());
            toast.setDuration(Toast.LENGTH_LONG);
            toast.setView(layout);
            toast.show();
        }
    }
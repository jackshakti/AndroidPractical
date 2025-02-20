package com.android.practical;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ButtonImageButtonToggleButton extends AppCompatActivity {

    private ImageView imageView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_image_button_toggle_button);

        // Button setup
        Button button = findViewById(R.id.button);
        button.setOnClickListener(v ->
                Toast.makeText(ButtonImageButtonToggleButton.this, "Button Clicked!", Toast.LENGTH_SHORT).show()
        );

        // ImageButton setup
        imageView = findViewById(R.id.imageView);
        ImageButton imageButton = findViewById(R.id.imageButton);
        imageButton.setOnClickListener(v -> imageView.setImageResource(R.drawable.ic_launcher_foreground));

        // ToggleButton setup
        textView = findViewById(R.id.textView);
        ToggleButton toggleButton = findViewById(R.id.toggleButton);
        toggleButton.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                textView.setVisibility(View.GONE);
            } else {
                textView.setVisibility(View.VISIBLE);
            }
        });
    }
}
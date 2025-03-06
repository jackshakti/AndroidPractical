package com.android.practical;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Checkbox extends AppCompatActivity {

    CheckBox checkBoxSports, checkBoxMusic, checkBoxMovies;

    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkbox);

        // Initialize CheckBoxes and Button
        checkBoxSports = findViewById(R.id.checkBoxSports);
        checkBoxMusic = findViewById(R.id.checkBoxMusic);
        checkBoxMovies = findViewById(R.id.checkBoxMovies);
        btnSubmit = findViewById(R.id.btnSubmit);

        // Set Click Listener
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder selectedOptions = new StringBuilder("Selected: ");

                if (checkBoxSports.isChecked()) {
                    selectedOptions.append("Sports ");
                }
                if (checkBoxMusic.isChecked()) {
                    selectedOptions.append("Music ");
                }
                if (checkBoxMovies.isChecked()) {
                    selectedOptions.append("Movies ");
                }

                if (selectedOptions.toString().equals("Selected: ")) {
                    selectedOptions.append("None");
                }

                // Show a Toast with selected options
                Toast.makeText(Checkbox.this, selectedOptions.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
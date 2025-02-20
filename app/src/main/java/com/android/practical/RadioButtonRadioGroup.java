package com.android.practical;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RadioButtonRadioGroup extends AppCompatActivity {

    private RadioGroup radioGroup;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button_radio_group);

        radioGroup = findViewById(R.id.radioGroup);
        submitButton = findViewById(R.id.submitButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get selected radio button ID
                int selectedId = radioGroup.getCheckedRadioButtonId();

                if (selectedId != -1) {
                    // Find the selected radio button
                    RadioButton selectedRadioButton = findViewById(selectedId);
                    String selectedText = selectedRadioButton.getText().toString();

                    // Show a Toast message with the selected option
                    Toast.makeText(RadioButtonRadioGroup.this, "Selected: " + selectedText, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(RadioButtonRadioGroup.this, "Please select an option", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
package com.android.practical;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class ListViewGridViewImageViewScrollView extends AppCompatActivity {

        private ListView listView;
        private GridView gridView;
        private ImageView imageView;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_list_view_grid_view_image_view_scroll_view);

            // Initialize UI components
            imageView = findViewById(R.id.imageView);
            listView = findViewById(R.id.listView);
            gridView = findViewById(R.id.gridView);

            // Sample data
            List<String> items = new ArrayList<>();
            for (int i = 1; i <= 10; i++) {
                items.add("Item " + i);
            }

            // Adapter for ListView
            ArrayAdapter<String> listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
            listView.setAdapter(listAdapter);

            // Adapter for GridView
            ArrayAdapter<String> gridAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
            gridView.setAdapter(gridAdapter);
        }
    }
package com.example.planets;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // TODO 1: Review the starter code.
    // TODO 2: Create the Planet class.
    // TODO 3: Create the PlanetDataSource class.

    private EditText weightEditText;
    private Button calculateButton;
    private Spinner planetSelectView;
    private ImageView planetImageView;
    private TextView weightOnPlanetLabel;

    // TODO 4: Add PlanetDataSource instance to the MainActivity class.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        setUpCalculateButton();
        setUpPlanetSelectView();
    }

    private void initViews() {
        weightEditText = findViewById(R.id.weightEditText);
        calculateButton = findViewById(R.id.calculateButton);
        planetSelectView = findViewById(R.id.planetSelectView);
        planetImageView = findViewById(R.id.planetImageView);
        weightOnPlanetLabel = findViewById(R.id.weightOnPlanetLabel);
    }

    private void setUpCalculateButton() {
        // TODO 5: Implement OnClickListener for the calculateButton.
    }

    private void setUpPlanetSelectView() {
        // TODO 6: Create and set an Adapter to the planetSelectView.
        // TODO 7: Implement OnItemSelectedListener for the planetSelectView.
    }

    // TODO 8: Implement recalculateWeight function.

}
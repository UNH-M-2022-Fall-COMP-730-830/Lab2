package com.example.planets;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
// MainActivity and AppCompatActivity have IS-A relationship.

    // TODO 1: Review the starter code.
    // TODO 2: Create the Planet class.
    // TODO 3: Create the PlanetDataSource class.

    private EditText weightEditText;
    private Button calculateButton;
    private Spinner planetSelectView;
    private ImageView planetImageView;
    private TextView weightOnPlanetLabel;

    // TODO 4: Add PlanetDataSource instance to the MainActivity class.
    private PlanetDataSource planetDataSource = new PlanetDataSource();

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
        // Instance of anonymous class
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onCalculateClick();
            }
        };
        calculateButton.setOnClickListener(listener);
    }

    private void setUpPlanetSelectView() {
        // TODO 6: Create and set an Adapter to the planetSelectView.
        ArrayAdapter adapter = new ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            planetDataSource.getNames()
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        planetSelectView.setAdapter(adapter);

        // TODO 7: Implement OnItemSelectedListener for the planetSelectView.
        // Because MainActivity implements AdapterView.OnItemSelectedListener we can use this
        // instance as a listener
        planetSelectView.setOnItemSelectedListener(this);
    }

    private void onCalculateClick() {
        recalculateWeight();
    }

    // Implementation of AdapterView.OnItemSelectedListener

    public void onItemSelected(AdapterView<?> parent, View view, int index, long id) {
        Planet selectedPlanet = planetDataSource.getDataSource()[index];
        planetImageView.setImageResource(selectedPlanet.getImage());
        recalculateWeight();
    }

    public void onNothingSelected(AdapterView<?> parent) {
        planetImageView.setImageResource(0);
        weightOnPlanetLabel.setText("");
    }

    // TODO 8: Implement recalculateWeight function.
    // Example of Function Overloading. recalculateWeight function has two forms: with parameters and
    // with no parameters.

    private void recalculateWeight() {
        int selectedIndex = planetSelectView.getSelectedItemPosition();
        String weightString = weightEditText.getText().toString();
        double weight;
        try {
            weight = Double.parseDouble(weightString);
        } catch (NumberFormatException exception) {
            Toast.makeText(this, "Invalid format", Toast.LENGTH_LONG).show();
            return;
        }

        recalculateWeight(weight, selectedIndex);
    }

    private void recalculateWeight(double mass, int planetIndex) {
        Planet selectedPlanet = planetDataSource.getDataSource()[planetIndex];
        double weight = selectedPlanet.calculateWeight(mass);
        String planetName = selectedPlanet.getName();
        String weightOnPlanetText = String.format("Your weight on %s is %.1f", planetName, weight);

        weightOnPlanetLabel.setText(weightOnPlanetText);
    }
}
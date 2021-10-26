package com.example.inchesconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText inchesEditText;
    Button calculateBtn;
    TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inchesString = inchesEditText.getText().toString();
                if (inchesString.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please input a value", Toast.LENGTH_SHORT).show();
                } else {
                    double result = calculateHeight(inchesString);
                    displayHeight(result);
                }
            }
        });
    }
    private void findViews() {
        inchesEditText = findViewById(R.id.edit_text_inches);
        calculateBtn = findViewById(R.id.calculate_button);
        resultTextView = findViewById(R.id.text_view_output);
    }

    private double calculateHeight(String inchesString) {
        int inches = Integer.parseInt(inchesString);
        return inches * 0.0254;
    }

    private void displayHeight(double result) {
        DecimalFormat myFormatter = new DecimalFormat("0.00");
        String resultString = myFormatter.format(result);
        resultTextView.setText(resultString + " metres");
    }


}
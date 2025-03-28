package com.example.devmobile;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.*;


public class MainActivity extends AppCompatActivity {
    private EditText inputNumber;
    private Spinner spinnerInputBase, spinnerOutputBase;
    private TextView resultText;
    private Button convertButton;
    private String results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputNumber = findViewById(R.id.inputNumber);
        spinnerInputBase = findViewById(R.id.spinnerInputBase);
        spinnerOutputBase = findViewById(R.id.spinnerOutputBase);
        resultText = findViewById(R.id.resultText);
        convertButton = findViewById(R.id.convertButton);

        String[] bases = {
                "Decimal",
                "Binary",
                "Octal",
                "Hexadecimal"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, // context
                android.R.layout.simple_spinner_dropdown_item, // layout for dropdown menu
                bases // drop down items
        );
        spinnerInputBase.setAdapter(adapter);
        spinnerOutputBase.setAdapter(adapter);

        convertButton.setOnClickListener(view -> {
            results = "";
            Object selectedItem = spinnerOutputBase.getSelectedItem();

            switch (spinnerInputBase.getSelectedItem().toString()){
                case "Decimal":
                    int decimalValue = Integer.parseInt(inputNumber.getText().toString());
                     if (selectedItem.equals("Binary")) {
                         results = Integer.toBinaryString(decimalValue);
                    } else if (selectedItem.equals("Octal")) {
                         results = Integer.toOctalString(decimalValue);
                    } else if (selectedItem.equals("Hexadecimal")) {
                        results = Integer.toHexString(decimalValue);
                     } else {
                         results = inputNumber.getText().toString();
                     }
                    break;
                case "Binary":
                    String binaryValue = inputNumber.getText().toString();
                    if(selectedItem.equals("Decimal")){
                        results = String.valueOf(Integer.parseInt(binaryValue, 2));
                    } else if(selectedItem.equals("Octal")){
                    } else if(selectedItem.equals("Hexadecimal")){
                    } else {
                        results = inputNumber.getText().toString();
                    }
                    break;
                case "Octal":
                    break;
                case "Hexadecimal":
                    break;
                default:
                    break;
            }


            resultText.setText("Conversion logic results: " + this.results);
        });




//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
    }
}
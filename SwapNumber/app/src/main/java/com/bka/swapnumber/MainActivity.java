package com.bka.swapnumber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText input;
    TextView resultView;
    Button convert;
    int coso = 10;
    String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = (EditText) findViewById(R.id.input);
        resultView = (TextView) findViewById(R.id.result);
        convert = (Button) findViewById(R.id.button);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.planets_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                coso = Integer.parseInt(parent.getSelectedItem().toString());
                System.out.println(coso);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (coso) {
                    case 10: {
                        result = Integer.toString(Integer.parseInt(input.getText().toString()), 10);
                        break;
                    }
                    case 2: {
                        result = Integer.toString(Integer.parseInt(input.getText().toString()), 2);
                        break;
                    }
                    case 8: {
                        result = Integer.toString(Integer.parseInt(input.getText().toString()), 8);
                        break;
                    }
                    case 16: {
                        result = Integer.toString(Integer.parseInt(input.getText().toString()), 16);
                        break;
                    }
                    default: {
                        break;
                    }
                }
                resultView.setText("Result: " + result);
            }
        });
    }
}
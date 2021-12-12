package com.bka.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentConvertMeter extends Fragment {
    EditText input;
    TextView resultView;
    Button convert;
    String donvi;
    String result;


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_convert_meter,container, false);
        super.onCreate(savedInstanceState);

        input = (EditText) view.findViewById(R.id.input);
        resultView = (TextView) view.findViewById(R.id.result);
        convert = (Button) view.findViewById(R.id.button);

        Spinner spinner = (Spinner) view.findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.meter, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                donvi = parent.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (donvi) {
                    case "mm": {
                        result = Float.toString(Float.parseFloat(input.getText().toString()) * 1000);
                        break;
                    }
                    case "cm": {
                        result = Float.toString(Float.parseFloat(input.getText().toString()) * 100);
                        break;
                    }
                    case "dm": {
                        result = Float.toString(Float.parseFloat(input.getText().toString()) * 10);
                        break;
                    }
                    case "km": {
                        result = Float.toString(Float.parseFloat(input.getText().toString()) / 1000);
                        break;
                    }
                    default: {
                        break;
                    }
                }
                resultView.setText("Result: " + result);
            }
        });
        return view;
    }
}

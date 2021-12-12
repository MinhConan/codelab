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

public class FragmentConvertNumber extends Fragment {
    EditText input;
    TextView resultView;
    Button convert;
    int coso = 10;
    String result;


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_convert_number,container, false);
        super.onCreate(savedInstanceState);

        input = (EditText) view.findViewById(R.id.input);
        resultView = (TextView) view.findViewById(R.id.result);
        convert = (Button) view.findViewById(R.id.button);

        Spinner spinner = (Spinner) view.findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
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
        return view;
    }
}

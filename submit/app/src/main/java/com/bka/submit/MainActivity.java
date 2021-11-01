package com.bka.submit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText hoten;
    EditText mssv;
    EditText ngaysinh;
    EditText sdt;
    EditText email;
    Button submit;

    String name, mail, id, date, phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submit = (Button) findViewById(R.id.submit);
        hoten = (EditText) findViewById(R.id.hoten);
        mssv = (EditText) findViewById(R.id.mssv);
        ngaysinh = (EditText) findViewById(R.id.ngaysinh);
        sdt = (EditText) findViewById(R.id.sdt);
        email = (EditText) findViewById(R.id.email);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name = hoten.getText().toString();
                mail = email.getText().toString();
                id = mssv.getText().toString();
                date = ngaysinh.getText().toString();
                phone = sdt.getText().toString();

                if (name.isEmpty()) {
                    Toast.makeText(MainActivity.this, "chua nhap ho ten", Toast.LENGTH_SHORT).show();
                }

                if (mail.isEmpty()) {
                    Toast.makeText(MainActivity.this, "chua nhap mssv", Toast.LENGTH_SHORT).show();
                }

                if (id.isEmpty()) {
                    Toast.makeText(MainActivity.this, "chua nhap sdt", Toast.LENGTH_SHORT).show();
                }

                if (mail.isEmpty()) {
                    Toast.makeText(MainActivity.this, "chua nhap email", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
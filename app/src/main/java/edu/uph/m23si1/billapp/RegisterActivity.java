package edu.uph.m23si1.billapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    private EditText inputAngka1, inputAngka2;
    private TextView textViewHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        setContentView(R.layout.activity_register);

        inputAngka1 = findViewById(R.id.inputAngka1);
        inputAngka2 = findViewById(R.id.inputAngka2);
        textViewHasil = findViewById(R.id.textViewHasil);

        Button btnTambah = findViewById(R.id.btnTambah);
        Button btnKali = findViewById(R.id.btnKali);
        Button btnBagi = findViewById(R.id.btnBagi);

        btnTambah.setOnClickListener(view -> hitung('+'));
        btnKali.setOnClickListener(view -> hitung('*'));
        btnBagi.setOnClickListener(view -> hitung('/'));
    }

    private void hitung(char operasi) {
        try {
            double angka1 = Double.parseDouble(inputAngka1.getText().toString());
            double angka2 = Double.parseDouble(inputAngka2.getText().toString());
            double hasil = 0;

            switch (operasi) {
                case '+':
                    hasil = angka1 + angka2;
                    break;
                case '*':
                    hasil = angka1 * angka2;
                    break;
                case '/':
                    if (angka2 != 0) {
                        hasil = angka1 / angka2;
                    } else {
                        textViewHasil.setText("∞");
                        return;
                    }
                    break;
            }

            textViewHasil.setText(String.valueOf(hasil));

        } catch (NumberFormatException e) {
            textViewHasil.setText("0");
        }
    }
}

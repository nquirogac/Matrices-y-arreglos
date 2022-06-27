package com.example.uncomedor;

import static com.example.uncomedor.MainActivity.pila;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TurnoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turno);
    }
    public void Actualizar(View view) {
        Button btn = this.findViewById(R.id.button11);
        btn.setText("4");
    }
}
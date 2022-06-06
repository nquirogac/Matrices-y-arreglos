package com.example.uncomedor;

import static com.example.uncomedor.MainActivity.pila;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ComedorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comedor);
    }

    public void iraTurno(View view) {
        pila.push(TurnoActivity.class);
        Intent siguiente = new Intent(this, TurnoActivity.class);
        this.startActivity(siguiente);
    }
}
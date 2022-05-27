package com.example.uncomedor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

import com.example.uncomedor.Data.Pila;

public class MainActivity extends AppCompatActivity {
    public static Pila pila = new Pila();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pila.push(MainActivity.class);
    }


    public void iraAuth(View view) {
        pila.push(AuthActivity.class);
        Intent siguiente = new Intent(this, AuthActivity.class);
        this.startActivity(siguiente);
    }

}

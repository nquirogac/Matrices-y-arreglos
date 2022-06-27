package com.example.uncomedor;

import static com.example.uncomedor.MainActivity.pila;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class AdmiActivity extends AppCompatActivity {
    /*
    public TextView tvn1 = (TextView)this.findViewById(R.id.tvn1);
    public TextView tvn2 = (TextView)this.findViewById(R.id.tvn2);
    public TextView tvn3 = (TextView)this.findViewById(R.id.tvn33);
    public TextView tvn4 = (TextView)this.findViewById(R.id.tvn4);
    public TextView tvn5 = (TextView)this.findViewById(R.id.tvn5);

    LinearLayout ly5 = this.findViewById(R.id.ly5);


     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admi);

    }

    public void actualizar(View view) {
        Toast.makeText(AdmiActivity.this, "0000", Toast.LENGTH_SHORT).show();
        TextView tvn1 = (TextView)this.findViewById(R.id.tvn1);
        TextView tvn2 = (TextView)this.findViewById(R.id.tvn2);
        TextView tvn3 = (TextView)this.findViewById(R.id.tvn3);
        TextView tvn4 = (TextView)this.findViewById(R.id.tvn4);
        TextView tvn5 = (TextView)this.findViewById(R.id.tvn5);
        Toast.makeText(AdmiActivity.this, "aaaa", Toast.LENGTH_SHORT).show();
        LinearLayout ly5 = this.findViewById(R.id.ly5);

        tvn1.setText(tvn2.getText());
        Toast.makeText(AdmiActivity.this, "bbbb", Toast.LENGTH_SHORT).show();
        tvn4.setText(tvn3.getText());
        tvn3.setText(tvn4.getText());
        tvn4.setText(tvn5.getText());
        Toast.makeText(AdmiActivity.this, "ccc", Toast.LENGTH_SHORT).show();
        ly5.setVisibility(View.INVISIBLE);
        Toast.makeText(AdmiActivity.this, "ddddd", Toast.LENGTH_SHORT).show();
    }
    public void iraComedores(View view) {
        Intent siguiente = new Intent(this, ComedoresActivity.class);
        this.startActivity(siguiente);
    }

}
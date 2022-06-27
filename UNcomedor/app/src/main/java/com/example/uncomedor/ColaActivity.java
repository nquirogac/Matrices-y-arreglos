package com.example.uncomedor;

import static com.example.uncomedor.MainActivity.pila;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class ColaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cola);
    }

    public void actualizar(View view) {

        TextView tvn1 = (TextView)this.findViewById(R.id.tvn1);
        TextView tvn2 = (TextView)this.findViewById(R.id.tvn2);
        TextView tvn3 = (TextView)this.findViewById(R.id.tvn33);
        TextView tvn4 = (TextView)this.findViewById(R.id.tvn4);
        TextView tvn5 = (TextView)this.findViewById(R.id.tvn5);

        TextView tvm1 = (TextView)this.findViewById(R.id.tvm1);
        TextView tvm2 = (TextView)this.findViewById(R.id.tvm2);
        TextView tvm3 = (TextView)this.findViewById(R.id.tvm3);
        TextView tvm4 = (TextView)this.findViewById(R.id.tvm4);
        TextView tvm5 = (TextView)this.findViewById(R.id.tvm5);

        TextView tvf1 = (TextView)this.findViewById(R.id.tvf1);
        TextView tvf2 = (TextView)this.findViewById(R.id.tvf2);
        TextView tvf3 = (TextView)this.findViewById(R.id.tvf3);
        TextView tvf4 = (TextView)this.findViewById(R.id.tvf4);
        TextView tvf5 = (TextView)this.findViewById(R.id.tvf5);

        LinearLayout ly5 = this.findViewById(R.id.ly5);

        tvn1.setText(tvn2.getText());
        tvn2.setText(tvn3.getText());
        tvn3.setText(tvn4.getText());
        tvn4.setText(tvn5.getText());

        tvm1.setText(tvm2.getText());
        tvm2.setText(tvm3.getText());
        tvm3.setText(tvm4.getText());
        tvm4.setText(tvm5.getText());

        tvf1.setText(tvf2.getText());
        tvf2.setText(tvf3.getText());
        tvf3.setText(tvf4.getText());
        tvf4.setText(tvf5.getText());

        ly5.setVisibility(View.INVISIBLE);

    }
    public void iraComedores(View view) {
        Intent siguiente = new Intent(this, ComedoresActivity.class);
        this.startActivity(siguiente);
    }
    public void refresh(View view){
        LinearLayout ly5 = this.findViewById(R.id.ly5);
        TextView tvn5 = (TextView)this.findViewById(R.id.tvn5);
        TextView tvm5 = (TextView)this.findViewById(R.id.tvm5);
        TextView tvf5 = (TextView)this.findViewById(R.id.tvf5);

        tvn5.setText("Natalia Quiroga");
        tvm5.setText("Menú 2");
        tvf5.setText("Nequi");

        ly5.setVisibility(View.VISIBLE);

    }
}
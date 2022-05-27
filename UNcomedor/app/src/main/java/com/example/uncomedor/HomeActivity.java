
package com.example.uncomedor;

import static com.example.uncomedor.MainActivity.pila;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;



public class HomeActivity extends AppCompatActivity {

    DatabaseReference mDatabase;
    FirebaseDatabase database;
    FirebaseAuth fAuth;



    public HomeActivity() {
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        TextView txtusername = (TextView)this.findViewById(R.id.nombretv);
        TextView txtuseremail = (TextView)this.findViewById(R.id.correotv);
        TextView txtcedula = (TextView)this.findViewById(R.id.cedulatv);
        TextView txtapoyo = (TextView)this.findViewById(R.id.apoyotv);
        String[] val = new String[4];
        fAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        String userID = this.fAuth.getCurrentUser().getUid();
        String nombreUsuario = getIntent().getStringExtra("nombreUsuario");
        String emailUsuario = getIntent().getStringExtra("emailUsuario");
        String cedula = getIntent().getStringExtra("cedulaUsuario");
        String apoyo = getIntent().getStringExtra("apoyoUsuario");
        txtusername.setText(nombreUsuario);
        txtuseremail.setText(emailUsuario);
        txtcedula.setText(cedula);
        txtapoyo.setText(apoyo);

    }

    public void singout(View view) {
        FirebaseAuth.getInstance().signOut();
        pila.pop();
        Intent siguiente = new Intent(this, MainActivity.class);
        this.startActivity(siguiente);
    }
    public void iraComedores(View view) {
        pila.push(ComedoresActivity.class);
        Intent siguiente = new Intent(this, ComedoresActivity.class);
        this.startActivity(siguiente);
    }


}

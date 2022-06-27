package com.example.uncomedor;

import static com.example.uncomedor.MainActivity.pila;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import com.example.uncomedor.Data.Usuario;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;


public class AuthActivity extends AppCompatActivity {
    EditText nombreET;
    EditText cedulaET;
    EditText correoET;
    EditText contraseñaET;
    Button registerBtn;
    TextView iraLogin;
    FirebaseAuth fAuth;
    CheckBox parcialCB;
    CheckBox completoCB;
    private ProgressDialog progressDialog;
    private int MY_PERMISSIONS_REQUEST_READ_CONTACTS;
    DatabaseReference mDatabase;
    FirebaseDatabase database;
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        nombreET = findViewById(R.id.nombreEt);
        this.cedulaET = (EditText)this.findViewById(R.id.cedulaEt);
        this.correoET = (EditText)this.findViewById(R.id.emailEt);
        this.contraseñaET = (EditText)this.findViewById(R.id.passEt);
        this.registerBtn = (Button)this.findViewById(R.id.btnRegistro);
        this.parcialCB = (CheckBox)this.findViewById(R.id.cbparcial);
        this.completoCB = (CheckBox)this.findViewById(R.id.cbcompleto);
        this.progressDialog = new ProgressDialog(this);
        this.fAuth = FirebaseAuth.getInstance();
        this.database = FirebaseDatabase.getInstance();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();


        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = nombreET.getText().toString().trim();
                String cedula = cedulaET.getText().toString().trim();
                String email = correoET.getText().toString().trim();
                String password = contraseñaET.getText().toString().trim();
                String apoyo = "";
                mDatabase = FirebaseDatabase.getInstance().getReference();
                if(TextUtils.isEmpty(nombre)){
                    Toast.makeText(AuthActivity.this, "Ingrese su nombre", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(cedula)){
                    Toast.makeText(AuthActivity.this, "Ingrese su número de cedula", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(email)){
                    Toast.makeText(AuthActivity.this, "Ingrese un Email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    Toast.makeText(AuthActivity.this, "Ingrese una contraseña", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(parcialCB.isChecked()==true && completoCB.isChecked()==true) {
                    Toast.makeText(AuthActivity.this, "Escoja solo un tipo de apoyo", Toast.LENGTH_SHORT).show();
                    return;
                }if(parcialCB.isChecked()==false && completoCB.isChecked()==false) {
                    Toast.makeText(AuthActivity.this, "Escoja un tipo de apoyo", Toast.LENGTH_SHORT).show();
                    return;
                }if(parcialCB.isChecked()==true) {
                    apoyo = "Parcial";

                }if(completoCB.isChecked()==true) {
                    apoyo = "Completo";

                }
                progressDialog.setMessage("Realizando registro...");
                progressDialog.show();

                //crear usuario
                String finalApoyo = apoyo;

                fAuth.createUserWithEmailAndPassword(email,password)
                        .addOnCompleteListener(AuthActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    Toast.makeText(AuthActivity.this,"Se ha registrado "+email+" correctamente", Toast.LENGTH_SHORT).show();
                                    //DATOS PARA LA BD
                                    Map<String, Object> map = new HashMap<>();

                                    map.put("email", email);
                                    map.put("password", password);
                                    map.put("nombre", nombre);
                                    map.put("cedula", cedula);
                                    map.put("apoyo", finalApoyo);
                                    map.put("id", fAuth.getCurrentUser().getUid());
                                    Usuario uu = new Usuario(nombre,cedula, finalApoyo, email,password,fAuth.getCurrentUser().getUid());

                                    String id = fAuth.getCurrentUser().getUid();
                                    System.out.println("este es el id"+id);
                                    //CREAR EL USUARIO EN FIREBASE
                                    if(email.equals("comedor1@gmail.com")||email.equals("comedor2@gmail.com")||email.equals("comedor3@gmail.com")){
                                        mDatabase.child("Users").child("Comedores").child(id).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task3) {
                                                if (task3.isSuccessful()) {
                                                    irAdmi();
                                                } else {
                                                    Toast.makeText(AuthActivity.this, "No se pudieron crear los datos correctamente", Toast.LENGTH_SHORT).show();
                                                }
                                            }
                                        });
                                    }else {
                                        mDatabase.child("Users").child("Usuarios").child(id).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {

                                            @Override
                                            public void onComplete(@NonNull Task<Void> task2) {
                                                if (task2.isSuccessful()) {
                                                    irHomeDatos();
                                                } else {
                                                    Toast.makeText(AuthActivity.this, "No se pudieron crear los datos correctamente", Toast.LENGTH_SHORT).show();
                                                }
                                            }
                                        });
                                    }
                                }else{
                                    if(task.getException() instanceof FirebaseAuthUserCollisionException){
                                        Toast.makeText(AuthActivity.this,"El usuario ya existe", Toast.LENGTH_SHORT).show();
                                    }else {
                                        Toast.makeText(AuthActivity.this, "Error en el registro", Toast.LENGTH_SHORT).show();
                                    }
                                }
                                progressDialog.dismiss();
                            }
                        });
            }

        });


    }

    public void irHomeDatos(){//OBTENER DATOS DE FIREBASE DEL USUARIO Y LLEVARLOS A HOME
        final String[] val = new String[4];
        DatabaseReference ref;
        pila.push(HomeActivity.class);
        ref = FirebaseDatabase.getInstance().getReference();

        String userID = fAuth.getCurrentUser().getUid();
        ref.child("Users").child("Usuarios").child(userID).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    if(dataSnapshot.exists()){
                        String nombre = dataSnapshot.child("nombre").getValue(String.class);
                        String email = dataSnapshot.child("email").getValue(String.class);
                        String cedula = dataSnapshot.child("cedula").getValue(String.class);
                        String apoyo = dataSnapshot.child("apoyo").getValue(String.class);
                        val[0] = nombre;
                        val[1] = email;
                        val[2] = cedula;
                        val[3] = apoyo;
                        //getLocation();
                        Intent intention = new Intent(AuthActivity.this, HomeActivity.class);
                        intention.putExtra("nombreUsuario",val[0].toString());
                        intention.putExtra("emailUsuario",val[1].toString());
                        intention.putExtra("cedulaUsuario",val[2].toString());
                        intention.putExtra("apoyoUsuario",val[3].toString());
                        startActivity(intention);

                    }
                }
                @Override
                public void onCancelled(DatabaseError databaseError) {
                    System.out.println("Fallo la lectura: " + databaseError.getCode());
                }
            });

    }

    public void irAdmi(){
        Intent siguiente = new Intent(this, AdmiActivity.class);
        this.startActivity(siguiente);
    }


    public void iraLogin(View view) {
        pila.pop();
        pila.push(LoginActivity.class);
        Intent siguiente = new Intent(this, LoginActivity.class);
        this.startActivity(siguiente);
    }


}

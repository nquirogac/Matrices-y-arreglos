package com.example.uncomedor;

import static com.example.uncomedor.MainActivity.pila;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

public class LoginActivity extends AppCompatActivity {
    EditText correo2ET;
    EditText contraseña2ET;
    Button loginbtn;
    FirebaseAuth fAuth;
    private ProgressDialog progressDialog;
    DatabaseReference mDatabase;
    FirebaseDatabase database;
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.progressDialog = new ProgressDialog(this);

        this.correo2ET = (EditText)this.findViewById(R.id.emailEt);
        this.contraseña2ET = (EditText)this.findViewById(R.id.passEt);
        this.loginbtn = (Button)this.findViewById(R.id.btnRegistro);
        this.fAuth = FirebaseAuth.getInstance();
        this.loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email2 = correo2ET.getText().toString().trim();
                String password2 = contraseña2ET.getText().toString().trim();

                if(TextUtils.isEmpty(email2)){
                    Toast.makeText(LoginActivity.this, "Ingrese un Email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(password2)){
                    Toast.makeText(LoginActivity.this, "Ingrese una contraseña", Toast.LENGTH_SHORT).show();
                    return;
                }
                progressDialog.setMessage("Iniciando sesión...");
                progressDialog.show();

                //logear usuario

                fAuth.signInWithEmailAndPassword(email2,password2)
                        .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    Toast.makeText(LoginActivity.this,"Bienvenido: "+email2, Toast.LENGTH_SHORT).show();

                                    irHomeDatos();

                                }else{
                                    if(task.getException() instanceof FirebaseAuthUserCollisionException){
                                        Toast.makeText(LoginActivity.this,"El usuario ya existe", Toast.LENGTH_SHORT).show();
                                    }else {
                                        Toast.makeText(LoginActivity.this, "Error en el registro", Toast.LENGTH_SHORT).show();
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
                    Intent intention = new Intent(LoginActivity.this, HomeActivity.class);
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

    public void iraAuth(View view) {
        pila.pop();
        pila.push(AuthActivity.class);
        Intent siguiente = new Intent(this, AuthActivity.class);
        this.startActivity(siguiente);
    }

}
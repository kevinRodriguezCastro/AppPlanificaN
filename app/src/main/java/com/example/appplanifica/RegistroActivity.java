package com.example.appplanifica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class RegistroActivity extends AppCompatActivity {
    EditText nombre,correo,contraseña;
    Button btnRegistrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        nombre = (EditText) findViewById(R.id.rNombre);
        correo = (EditText) findViewById(R.id.rCorreo);
        contraseña = (EditText) findViewById(R.id.rContraseña);
        btnRegistrar = (Button) findViewById(R.id.btnRegistro);
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrar();
            }
        });
    }
    public void registrar(){
        MyOpenHelper dbHelper = new MyOpenHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        if (db != null) {
            // Hacer las operaciones que queramos sobre la base de datos
            db.execSQL("INSERT INTO usuario (nombre,correo, contraseña) VALUES ('"+nombre.getText().toString()+"','"+correo.getText().toString()+"','"+contraseña.getText().toString()+"')");
        }
        Intent i = new Intent(this,InicioSesionActivity.class);
        startActivity(i);
    }
}
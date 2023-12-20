package com.example.appplanifica;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button btnIniciar,btnRegistrar;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnIniciar = (Button) findViewById(R.id.btnIniciar);
        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciarSesion();
            }
        });
        btnRegistrar = (Button) findViewById(R.id.btnRegistrar);
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrar();
            }
        });

        MyOpenHelper dbHelper = new MyOpenHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        if (db != null) {
            // Hacer las operaciones que queramos sobre la base de datos
            db.execSQL("INSERT INTO usuario (nombre, contraseña) VALUES ('kevin','123')");
        }

    }
    public void iniciarSesion(){
        Intent i = new Intent(this,InicioSesionActivity.class);
        startActivity(i);
    }
    public void registrar(){
        Intent i = new Intent(this,RegistroActivity.class);
        startActivity(i);
    }
}
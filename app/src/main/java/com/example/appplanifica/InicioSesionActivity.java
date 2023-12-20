package com.example.appplanifica;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class InicioSesionActivity extends AppCompatActivity {
    private EditText correo, contraseña;
    private Button btnEnviar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);

        correo = (EditText) findViewById(R.id.iCorreo);
        contraseña = (EditText) findViewById(R.id.iContraseña);
        btnEnviar = (Button) findViewById(R.id.btnIniciarSesion);
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iniciarSesion();
            }
        });

    }
    private void iniciarSesion(){
        MyOpenHelper dbHelper = new MyOpenHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ArrayList<String> resultado = new ArrayList<>();
        String[] arg = {correo.getText().toString(),contraseña.getText().toString()};
        if (db != null) {
            Cursor cursor = db.query("usuario", null, "correo = ? and contraseña = ?", arg, null, null, null);
            if (cursor.moveToNext()) {
                Toast.makeText(this,"sesion iniciada",Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this,"Error iniciar sesion",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
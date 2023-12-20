package com.example.appplanifica;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyOpenHelper extends SQLiteOpenHelper {
    private static final String USUARIO_TABLE_CREATE = "CREATE TABLE usuario(id_usuario INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT,correo TEXT, contraseña TEXT)";
    private static final String DB_NAME = "registro.db";
    private static final int DB_VERSION = 2;
    public MyOpenHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(USUARIO_TABLE_CREATE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

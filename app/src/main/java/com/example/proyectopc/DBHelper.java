package com.example.proyectopc;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NOMBRE = "tiempo.db";
    private static final String TABLE_NOMBRE = "tiempos";
    private static final String TABLE_NOMBRE2 = "metas";

    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_NOMBRE + "(" +"id INTEGER PRIMARY KEY AUTOINCREMENT," + "fecha DATETIME,"+"minutos TEXT)");
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_NOMBRE2+ "(" +"id INTEGER PRIMARY KEY AUTOINCREMENT," + "meta INTEGER,"+"cumple BOOLEAN)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_NOMBRE);
        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_NOMBRE2);
        onCreate(sqLiteDatabase);
    }
}
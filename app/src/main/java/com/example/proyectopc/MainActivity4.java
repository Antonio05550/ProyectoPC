package com.example.proyectopc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_metas);
        //declare la bd
        DBHelper dbHelper = new DBHelper(this);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        
        ImageView m1 = findViewById(R.id.imageView5);
        ImageView m2 = findViewById(R.id.imageView6);
        ImageView m3 = findViewById(R.id.imageView7);
        ImageView m4 = findViewById(R.id.imageView8);
        ImageView m5 = findViewById(R.id.imageView9);

        //ocultarlos
        m1.setVisibility(View.INVISIBLE);
        m2.setVisibility(View.INVISIBLE);
        m3.setVisibility(View.INVISIBLE);
        m4.setVisibility(View.INVISIBLE);
        m5.setVisibility(View.INVISIBLE);
        
        //Consulta para saber numere de metas con true
        Cursor c8 = db.rawQuery("SELECT id, meta, cumple FROM metas", null);
        String meta2 = null;
        int i=0;
        int cumple2=0;
        int puntosAc=0;
        if (c8 != null) {
            c8.moveToFirst();
            do {
                meta2 = c8.getString(1);
                cumple2 = c8.getInt(2);
                if(cumple2==1){
                    i= i +1;
                }

            } while (c8.moveToNext());
        }
        //mostrar imagenes en la vista de metas
        if(i==1) {
            m1.setVisibility(View.VISIBLE);
        }
        if(i==2) {
            m2.setVisibility(View.VISIBLE);
            m1.setVisibility(View.VISIBLE);
        }
        if(i==3) {
            m1.setVisibility(View.VISIBLE);
            m2.setVisibility(View.VISIBLE);
            m3.setVisibility(View.VISIBLE);
        }
        if(i==4) {
            m1.setVisibility(View.VISIBLE);
            m2.setVisibility(View.VISIBLE);
            m3.setVisibility(View.VISIBLE);
            m5.setVisibility(View.VISIBLE);
        }
        if(i==5) {
            m1.setVisibility(View.VISIBLE);
            m2.setVisibility(View.VISIBLE);
            m3.setVisibility(View.VISIBLE);
            m4.setVisibility(View.VISIBLE);
            m5.setVisibility(View.VISIBLE);
        }

        TextView text = findViewById(R.id.textView10);
        text.setText(i+" metas cumplidas");
        Button info = findViewById(R.id.button);
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), Recompensas.class);
                startActivityForResult(intent, 0);
            }
        });


    }
}
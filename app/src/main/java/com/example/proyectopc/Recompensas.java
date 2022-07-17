package com.example.proyectopc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Recompensas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recompensas);
        //declare la bd
        DBHelper dbHelper = new DBHelper(Recompensas.this);
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        TextView puntos = (TextView) findViewById(R.id.recompensaI);
        TextView puntosmensaje = (TextView) findViewById(R.id.recompesaT);

        //recuperar variables globales de cada meta, el numero y si esta activa o no
        Boolean m1= Sugerencia.meta1;
        Boolean m2= Sugerencia.meta2;
        Boolean m3= Sugerencia.meta3;
        Boolean m4= Sugerencia.meta4;

        int nometa1= (int) Sugerencia.nometa1;
        int nometa2= (int) Sugerencia.nometa2;
        int nometa3= (int) Sugerencia.nometa3;
        int nometa4= (int) Sugerencia.nometa4;

        //obtener fecha
        Date c = Calendar.getInstance().getTime();

        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = df.format(c);


        //hacer la consulta de fecha anterior
        Cursor c5 = db.rawQuery("SELECT id, fecha, minutos FROM tiempos WHERE (fecha) < ('" + formattedDate +"')", null);
        String fecha = null;
        String minutos= null;
        int id= 0;
        if ( c5  != null) {
            c5 .moveToFirst();
            do {
                fecha =  c5 .getString(1);
                minutos =  c5 .getString(2);
            } while ( c5 .moveToNext());
        }

        //hacer la consulta de fecha hoy
        Cursor c6 = db.rawQuery("SELECT id, fecha, minutos FROM tiempos", null);
        String fecha2 = null;
        String minutos2= null;
        if ( c6  != null) {
            c6.moveToFirst();
            do {
                fecha2 =  c6.getString(1);
                minutos2 =  c6.getString(2);
            } while ( c6.moveToNext());
        }

        //comparar minutos de ayer y hoy
        int diferencia=  Math.abs(Integer. parseInt(minutos) - Integer. parseInt(minutos2));

        //hacer la consulta de metas y hacer diferencia
        Cursor c4 = db.rawQuery("SELECT id, meta, cumple FROM metas", null);
        String meta = null;
        String cumple=null;
        if (c4 != null) {
            c4.moveToFirst();
            do {
                meta = c4.getString(1);
                cumple = c4.getString(2);;
                if(cumple=="false" && diferencia>=Integer.parseInt(meta)){
                    db.execSQL("INSERT INTO metas (meta, cumple) VALUES ("+meta+", "+true+")\n");
                }

            } while (c4.moveToNext());
        }
        //hacer la consulta de metas para sumar puntos
        Cursor c7 = db.rawQuery("SELECT id, meta, cumple FROM metas", null);
        String meta2 = null;
        int cumple2=0;
        int puntosAc=0;
        if (c7 != null) {
            c7.moveToFirst();
            do {
                meta2 = c7.getString(1);
                cumple2 = c7.getInt(2);
                if(cumple2==1){
                    puntosAc=puntosAc+Integer.parseInt(meta2);
                }

            } while (c7.moveToNext());
        }



        //acumular puntos

        //mostrar puntos
        puntosmensaje.setText("Cada punto es un minuto reducido de tiempo de ocio");
        puntos.setText(""+(puntosAc));

        //Toast.makeText(this, "no"+nometa1,Toast.LENGTH_LONG).show();
        Button info = findViewById(R.id.acpetarR);
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), Sugerencia.class);
                startActivityForResult(intent, 0);
            }
        });
    }
}
package com.example.proyectopc;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.imaginativeworld.whynotimagecarousel.model.CarouselItem;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Sugerencia extends AppCompatActivity {
    public static Boolean meta1, meta2, meta3, meta4, metaG;
    public static int nometa1, nometa2, nometa3, nometa4, nometaG;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sugerencia);
        //declare la bd
        DBHelper dbHelper = new DBHelper(Sugerencia.this);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        //ImageCarousel carouselPicker = (ImageCarousel) findViewById(R.id.carousel);
        Button botonAceptar = (Button) findViewById(R.id.acpetarM);
        TextView texto = (TextView) findViewById(R.id.text_view_id);
        TextView hara = (TextView) findViewById(R.id.t_tecnicas);
        LinearLayout sugerencia = (LinearLayout) findViewById(R.id.msugerencia);
        // Case 1 : To populate the picker with images
        List<CarouselItem> imageItems = new ArrayList<>();
        imageItems.add(new CarouselItem(R.drawable.min5, "Reducir 5 minutos de uso de FACEBOOOK "));
        imageItems.add(new CarouselItem(R.drawable.min15, "Reducir 15 minutos de uso de FACEBOOOK"));
        imageItems.add(new CarouselItem(R.drawable.min35, "Reducir 35 minutos de uso de FACEBOOOK"));

        //texto de las metas
        TextView tmeta1 = (TextView) findViewById(R.id.bmeta1);
        TextView tmeta2 = (TextView) findViewById(R.id.bmeta2);
        TextView tmeta3 = (TextView) findViewById(R.id.bmeta3);
        TextView tmeta4 = (TextView) findViewById(R.id.bmeta4);

        //obtener fecha
        Date c = Calendar.getInstance().getTime();

        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = df.format(c);
        //mostrar fecha
        //tmeta1.setText(formattedDate);


        //hacer la consulta de fecha del dia
        Cursor c3 = db.rawQuery("SELECT id, fecha, minutos FROM tiempos WHERE (fecha) < ('" + formattedDate +"')", null);
        String fecha = null;
        String minutos= null;
        int id= 0;
        if (c3 != null) {
            c3.moveToFirst();
            do {
                //Asignamos el valor en nuestras variables para usarlos en lo que necesitemos
                 //id = Integer.parseInt(c3.getString(0));
                 fecha = c3.getString(1);
                 minutos = c3.getString(2);;
            } while (c3.moveToNext());
        }
        //tmeta1.setText(fecha);
        //tmeta2.setText(minutos);

        //c3.close();
        //db.close();
        int tiempog = Integer.parseInt(minutos);
        int m1 = (int) (tiempog*0.02);
        int m2 = (int) (tiempog*0.05);
        int m3 = (int) (tiempog*0.08);
        int m4 = (int) (tiempog*0.10);

        //Cursor c2 = db.rawQuery("SELECT time FROM tiempos WHERE pkg='com.whatsapp'");
        tmeta1.setText(Integer.toString(m1));
        tmeta2.setText(Integer.toString(m2));
        tmeta3.setText(Integer.toString(m3));
        tmeta4.setText(Integer.toString(m4));

        //comparar fecha obtenida con la fecha de la consulta y obtener el tiempo de la fecha



        // dar click
        LinearLayout L1 = findViewById(R.id.l1);
        LinearLayout L2 = findViewById(R.id.l2);
        LinearLayout L3 = findViewById(R.id.l3);
        LinearLayout L4 = findViewById(R.id.l4);

        tmeta1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                meta1=true;
                meta2=false;
                meta3=false;
                meta4=false;
                nometa1=m1;
                nometaG=nometa1;
                metaG=meta1;
                tmeta2.setVisibility(View.INVISIBLE);
                tmeta3.setVisibility(View.INVISIBLE);
                tmeta4.setVisibility(View.INVISIBLE);
                L2.setVisibility(View.GONE);
                L3.setVisibility(View.GONE);
                L4.setVisibility(View.GONE);
                texto.setText("¡MUY BIEN!");
                sugerencia.setVisibility(View.VISIBLE);
                hara.setText("Haz aceptado la meta de reducir: " + nometa1+ " minutos de ocio");

            }
        });
        tmeta2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                meta1=false;
                meta2=true;
                meta3=false;
                meta4=false;
                nometa2=m2;
                nometaG=nometa2;
                metaG=meta2;
                L1.setVisibility(View.GONE);
                L3.setVisibility(View.GONE);
                L4.setVisibility(View.GONE);
                texto.setText("¡MUY BIEN!");
                sugerencia.setVisibility(View.VISIBLE);
                hara.setText("Haz aceptado la meta de reducir: " + m2+ " minutos de ocio");

            }
        });
        tmeta3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                meta1=false;
                meta2=false;
                meta3=true;
                meta4=false;
                nometa3=m3;
                nometaG=nometa3;
                metaG=meta3;
                L1.setVisibility(View.GONE);
                L2.setVisibility(View.GONE);
                L4.setVisibility(View.GONE);
                texto.setText("¡MUY BIEN!");
                sugerencia.setVisibility(View.VISIBLE);
                hara.setText("Haz aceptado la meta de reducir: " + m3+ " minutos de ocio");

            }
        });
        tmeta4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                meta1=false;
                meta2=false;
                meta3=false;
                meta4=true;
                nometa4=m4;
                nometaG=nometa4;
                metaG=meta4;
                L1.setVisibility(View.GONE);
                L2.setVisibility(View.GONE);
                L3.setVisibility(View.GONE);
                texto.setText("¡MUY BIEN!");
                sugerencia.setVisibility(View.VISIBLE);
                hara.setText("Haz aceptado la meta de reducir: " + m4+ " minutos de ocio");

            }
        });

        Button info = findViewById(R.id.acpetarM);
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                texto.setText("¡MUY BIEN!");
                sugerencia.setVisibility(View.VISIBLE);
                hara.setText("Haz aceptado la meta de:");
            }
        });

        //insertar en la bse de datos metas
        db.execSQL("INSERT INTO metas (meta, cumple) VALUES ("+0+", "+false+")\n");
        if(meta1 != null && nometa1 != 0)
            db.execSQL("INSERT INTO metas (meta, cumple) VALUES ("+nometa1+", "+meta1+")\n");

        if(meta2 != null && nometa2 != 0)
            db.execSQL("INSERT INTO metas (meta, cumple) VALUES ("+nometa2+", "+meta2+")\n");
        if(meta3 != null && nometa3 != 0)
            db.execSQL("INSERT INTO metas (meta, cumple) VALUES ("+nometa3+", "+meta3+")\n");
        if(meta4 != null && nometa4 != 0)
            db.execSQL("INSERT INTO metas (meta, cumple) VALUES ("+nometa4+", "+meta4+")\n");





        //Toast.makeText(this, nometaG+ "meta" + metaG,Toast.LENGTH_LONG).show();

    }
}
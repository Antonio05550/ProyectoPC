package com.example.proyectopc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Credibilidad extends AppCompatActivity {
    private ImageView  info1;
    private String url1, url2, url3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credibilidad);


        ImageView  info1 = findViewById(R.id.sabias1I);
        url1= "https://www.infosalus.com/actualidad/noticia-oms-dice-uso-telefonos-moviles-posiblemente-cancerigeno-20110601104602.html";
        info1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(url1);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        ImageView  info2 = findViewById(R.id.sabias2I);
        url2="https://www.elcomercio.com/tendencias/salud/celulares-redes-sociales-problemas-mentales.html";
        info2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(url2);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        ImageView  info3 = findViewById(R.id.sabias3I);
        url3="https://www.unipiloto.edu.co/enfermedades-causadas-por-el-uso-excesivo-del-celular/";
        info3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(url3);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }
}
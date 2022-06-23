package com.example.proyectopc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewbinding.ViewBinding;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.imaginativeworld.whynotimagecarousel.ImageCarousel;
import org.imaginativeworld.whynotimagecarousel.listener.CarouselListener;
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import in.goodiebag.carouselpicker.CarouselPicker;

public class Sugerencia extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sugerencia);
        ImageCarousel carouselPicker = (ImageCarousel) findViewById(R.id.carousel);
        Button botonAceptar = (Button) findViewById(R.id.acpetarM);
        TextView texto = (TextView) findViewById(R.id.text_view_id);
        TextView hara = (TextView) findViewById(R.id.t_tecnicas);
        LinearLayout sugerencia = (LinearLayout) findViewById(R.id.msugerencia);
        // Case 1 : To populate the picker with images
        List<CarouselItem> imageItems = new ArrayList<>();
        imageItems.add(new CarouselItem(R.drawable.min5, "Reducir 5 minutos de uso de FACEBOOOK "));
        imageItems.add(new CarouselItem(R.drawable.min15, "Reducir 15 minutos de uso de FACEBOOOK"));
        imageItems.add(new CarouselItem(R.drawable.min35, "Reducir 35 minutos de uso de FACEBOOOK"));
        //Set the adapter
        carouselPicker.setData(imageItems);


        carouselPicker.setCarouselListener(new CarouselListener() {
            @Override
            public void onLongClick(int i, @NonNull CarouselItem carouselItem) {

            }

            @androidx.annotation.Nullable
            @Override
            public ViewBinding onCreateViewHolder(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
                return null;
            }

            @Override
            public void onBindViewHolder(@NonNull ViewBinding viewBinding, @NonNull CarouselItem carouselItem, int i) {

            }

            @Nullable
            @Override
            public void onClick(int position, @NotNull  CarouselItem carouselItem) {
                botonAceptar.setVisibility(View.VISIBLE);

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
    }
}
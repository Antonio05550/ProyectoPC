package com.example.proyectopc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;

import org.imaginativeworld.whynotimagecarousel.ImageCarousel;
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem;

import java.util.ArrayList;
import java.util.List;

import in.goodiebag.carouselpicker.CarouselPicker;

public class inicio extends AppCompatActivity {
    String prevStarted = "yes";
    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedpreferences = getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE);
        if (!sharedpreferences.getBoolean(prevStarted, false)) {
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putBoolean(prevStarted, Boolean.TRUE);
            editor.apply();
        } else {
            moveToSecondary();
        }
    }
    public void moveToSecondary(){
        // use an intent to travel from one activity to another.
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        ImageCarousel carouselPicker = (ImageCarousel) findViewById(R.id.carousel);

        // Case 1 : To populate the picker with images
        List<CarouselItem> imageItems = new ArrayList<>();
        imageItems.add(new CarouselItem(R.drawable.imagen1));
        imageItems.add(new CarouselItem(R.drawable.i1));
        imageItems.add(new CarouselItem(R.drawable.i2));
        imageItems.add(new CarouselItem(R.drawable.i3));
        imageItems.add(new CarouselItem(R.drawable.i4));
        imageItems.add(new CarouselItem(R.drawable.i5));
 //Set the adapter
        carouselPicker.setData(imageItems);

        Button info = findViewById(R.id.acpetarI);
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), MainActivity.class);
                startActivityForResult(intent, 0);
            }
        });
    }

}
package com.example.proyectopc;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.proyectopc.databinding.ActivityMainBinding;

import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DBHelper dbHelper = new DBHelper(MainActivity.this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        if(db != null){
            Toast.makeText(this, "BD CREADA",Toast.LENGTH_LONG).show();
        }

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        scheduleAlarm(binding.getRoot());
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
    }

    public void scheduleAlarm(View V)
    {
        // hora a la que se programar?? la alarma aqu?? la alarma est?? programada a 1 d??a de la hora actual,
        // buscamos la hora actual en milisegundos y agregamos 1 d??a
        // es decir, 24*60*60*1000= 86,400,000 milisegundos en un d??a
        Long time = new GregorianCalendar().getTimeInMillis()+5000;

        // crea una intenci??n y establece la clase que se ejecutar?? cuando se active la alarma, aqu?? tenemos
        // dado AlarmReciever en el Intent, el m??todo onRecieve() de esta clase se ejecutar?? cuando
        // activa la alarma y
        //Llamamos al m??todo dentro del m??todo onRecieve() de la clase Alarmreciever
        Intent intentAlarm = new Intent(this, AlarmReciever.class);

        // crea el objeto
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        //establecer la alarma para un tiempo particular
        alarmManager.set(AlarmManager.RTC_WAKEUP,time, PendingIntent.getBroadcast(this,1,  intentAlarm, PendingIntent.FLAG_UPDATE_CURRENT));
        Toast.makeText(this, "Alarma programada para ma??ana", Toast.LENGTH_LONG).show();

    }

}
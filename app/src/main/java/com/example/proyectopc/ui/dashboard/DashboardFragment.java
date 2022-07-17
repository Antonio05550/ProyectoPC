package com.example.proyectopc.ui.dashboard;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.proyectopc.R;
import com.example.proyectopc.databinding.FragmentDashboardBinding;
import com.example.proyectopc.ui.home.HomeFragment;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;
    // variable for our bar chart
    BarChart barChart;

    // variable for our bar data.
    BarData barData;

    // variable for our bar data set.
    BarDataSet barDataSet;

    // array list for storing entries.
    ArrayList barEntriesArrayList;

    TextView tiempo, fechaH;

    private SQLiteDatabase db = SQLiteDatabase.openDatabase("/data/data/com.example.proyectopc/databases/tiempo.db", null, SQLiteDatabase.OPEN_READWRITE);


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // initializing variable for bar chart.
        barChart = root.findViewById(R.id.idBarChart);

        tiempo = root.findViewById(R.id.textView5);
        fechaH = root.findViewById(R.id.textView3);

        // calling method to get bar entries.
        try {
            getBarEntries();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        barDataSet = new BarDataSet(barEntriesArrayList, "Dias de la semana");

        // creating a new bar data and
        // passing our bar data set.
        barData = new BarData(barDataSet);

        // below line is to set data
        // to our bar chart.
        barChart.setData(barData);

        // adding color to our bar data set.
        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);

        // setting text color.
        barDataSet.setValueTextColor(Color.BLACK);

        // setting text size
        barDataSet.setValueTextSize(16f);
        barChart.getDescription().setEnabled(false);

        long ahora = System.currentTimeMillis();
        Date fecha = new Date(ahora);
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String salida = df.format(fecha);
        long global = 0;
        Cursor c2 = db.rawQuery("SELECT * FROM tiempos WHERE fecha='"+salida+"'",null);
        if (c2.moveToNext()) {
            global = c2.getInt(2)*60000;
        } else {
        }

        long hours = TimeUnit.MILLISECONDS.toHours(global);
        global -= TimeUnit.HOURS.toMillis(hours);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(global);
        global -= TimeUnit.MINUTES.toMillis(minutes);
        tiempo.setText(hours + " h " +  minutes + " m ");

        Calendar ct = Calendar.getInstance();
        String dia = diaSemana(ct);
        String mes = mesAno(ct);
        fechaH.setText("Hoy " + dia + " " + ct.get(Calendar.DAY_OF_MONTH) + " de " + mes);
        return root;
    }

    String diaSemana (Calendar c)
    {
        String letraD="";
        int nD =-1;
        nD=c.get(Calendar.DAY_OF_WEEK);
        switch (nD){
            case 1: letraD = "domingo";
                break;
            case 2: letraD = "lunes";
                break;
            case 3: letraD = "martes";
                break;
            case 4: letraD = "miercoles";
                break;
            case 5: letraD = "jueves";
                break;
            case 6: letraD = "viernes";
                break;
            case 7: letraD = "sabado";
                break;
        }

        return letraD;
    }

    String mesAno (Calendar c)
    {
        String letraD="";
        int nD =0;
        nD=c.get(Calendar.MONTH);
        switch (nD){
            case 0: letraD = "Enero";
                break;
            case 1: letraD = "Febrero";
                break;
            case 2: letraD = "Marzo";
                break;
            case 3: letraD = "Abril";
                break;
            case 4: letraD = "Mayo";
                break;
            case 5: letraD = "Junio";
                break;
            case 6: letraD = "Julio";
                break;
            case 7: letraD = "Agosto";
                break;
            case 8: letraD = "Septiembre";
                break;
            case 9: letraD = "Octubre";
                break;
            case 10: letraD = "Noviembre";
                break;
            case 11: letraD = "Diciembre";
                break;
        }

        return letraD;
    }

    private void getBarEntries() throws ParseException {
        // creating a new array list
        barEntriesArrayList = new ArrayList<>();

        Cursor c2 = db.rawQuery("SELECT * FROM tiempos ORDER BY (fecha) DESC LIMIT 7",null);
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        if (c2.moveToNext()) {
            do{
                Date fecha = df.parse(c2.getString(1));
                Toast.makeText(getContext(), ""+fecha.getDay(),Toast.LENGTH_LONG).show();
                switch (fecha.getDay()){
                    case 0:
                        barEntriesArrayList.add(new BarEntry(1f, c2.getFloat(2)));
                        break;
                    case 1:
                        barEntriesArrayList.add(new BarEntry(2f, c2.getFloat(2)));
                        break;
                    case 2:
                        barEntriesArrayList.add(new BarEntry(3f, c2.getFloat(3)));
                        break;
                    case 3:
                        barEntriesArrayList.add(new BarEntry(4f, c2.getFloat(2)));
                        break;
                    case 4:
                        barEntriesArrayList.add(new BarEntry(5f, c2.getFloat(2)));
                        break;
                    case 5:
                        barEntriesArrayList.add(new BarEntry(6f, c2.getFloat(2)));
                        break;
                    case 6:
                        barEntriesArrayList.add(new BarEntry(7f, c2.getFloat(2)));
                        break;
                }
            }while (c2.moveToNext());
        } else {
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
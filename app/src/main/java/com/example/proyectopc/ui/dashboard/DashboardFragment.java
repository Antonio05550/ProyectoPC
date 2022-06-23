package com.example.proyectopc.ui.dashboard;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.proyectopc.R;
import com.example.proyectopc.databinding.FragmentDashboardBinding;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

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


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // initializing variable for bar chart.
        barChart = root.findViewById(R.id.idBarChart);

        // calling method to get bar entries.
        getBarEntries();

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
        return root;
    }

    private void getBarEntries() {
        // creating a new array list
        barEntriesArrayList = new ArrayList<>();

        // adding new entry to our array list with bar
        // entry and passing x and y axis value to it.
        barEntriesArrayList.add(new BarEntry(1f, 5.30f));
        barEntriesArrayList.add(new BarEntry(2f, 6.20f));
        barEntriesArrayList.add(new BarEntry(3f, 5.15f));
        barEntriesArrayList.add(new BarEntry(4f, 7));
        barEntriesArrayList.add(new BarEntry(5f, 5.55f));
        barEntriesArrayList.add(new BarEntry(6f, 6));
        barEntriesArrayList.add(new BarEntry(7f, 5));

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
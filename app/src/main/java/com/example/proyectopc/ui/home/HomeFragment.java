package com.example.proyectopc.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectopc.R;
import com.example.proyectopc.databinding.FragmentHomeBinding;
import com.github.mikephil.charting.charts.BarChart;

import java.util.ArrayList;
import java.util.Arrays;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    RecyclerView recyclerView, recyclerView2;

    // Using ArrayList to store images data
    ArrayList img = new ArrayList<>(Arrays.asList(R.drawable.icon1, R.drawable.icon2,
            R.drawable.icon3, R.drawable.icon4));
    ArrayList nombre = new ArrayList<>(Arrays.asList("TikTok", "Facebook", "Messenger", "WhatsApp"));
    ArrayList tiempo = new ArrayList<>(Arrays.asList("50 m", "45 m", "30 m", "20 m"));

    ArrayList img2 = new ArrayList<>(Arrays.asList(R.drawable.icon1, R.drawable.icon2,
            R.drawable.icon3, R.drawable.icon4));
    ArrayList nombre2 = new ArrayList<>(Arrays.asList("TikTok", "Facebook", "Messenger", "WhatsApp"));
    ArrayList tiempo2 = new ArrayList<>(Arrays.asList("50 m", "45 m", "30 m", "20 m"));


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        recyclerView = root.findViewById(R.id.rViewTop);

        // Setting the layout as linear
        // layout for vertical orientation

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(root.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        // Sending reference and data to Adapter
        Adapter adapter = new Adapter(root.getContext(), img, nombre, tiempo);

        // Setting Adapter to RecyclerView
        recyclerView.setAdapter(adapter);

        recyclerView2 = root.findViewById(R.id.recyclerView8);

        // Setting the layout as linear
        // layout for vertical orientation

        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(root.getContext());
        recyclerView2.setLayoutManager(linearLayoutManager2);

        // Sending reference and data to Adapter
        Adapter adapter2 = new Adapter(root.getContext(), img, nombre, tiempo);

        // Setting Adapter to RecyclerView
        recyclerView2.setAdapter(adapter2);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
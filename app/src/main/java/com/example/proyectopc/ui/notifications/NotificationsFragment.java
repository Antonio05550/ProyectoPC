package com.example.proyectopc.ui.notifications;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.proyectopc.Credibilidad;
import com.example.proyectopc.MainActivity;
import com.example.proyectopc.MainActivity3;
import com.example.proyectopc.MainActivity4;
import com.example.proyectopc.R;
import com.example.proyectopc.Recompensas;
import com.example.proyectopc.Sugerencia;
import com.example.proyectopc.databinding.ActivityCredibilidadBinding;
import com.example.proyectopc.databinding.FragmentNotificationsBinding;

public class NotificationsFragment extends Fragment {

    private FragmentNotificationsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NotificationsViewModel notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        TextView info = root.findViewById(R.id.bcredibilidad);
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), Credibilidad.class);
                startActivityForResult(intent, 0);

            }
        });

        TextView info2 = root.findViewById(R.id.bsugerencia);
        info2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), Sugerencia.class);
                startActivityForResult(intent, 0);

            }
        });

        TextView info3 = root.findViewById(R.id.brecompesa);
        info3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), Recompensas.class);
                startActivityForResult(intent, 0);

            }
        });

        TextView info4 = root.findViewById(R.id.bmetas);
        info4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), MainActivity4.class);
                startActivityForResult(intent, 0);

            }
        });

        TextView info5 = root.findViewById(R.id.baviso);
        info5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), MainActivity3.class);
                startActivityForResult(intent, 0);

            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
package com.example.lab4;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
public class FragmentOne extends Fragment {

    private TextView tv;
    private Button btn;

    public FragmentOne() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_one, container, false);

        tv = view.findViewById(R.id.tvMessage);
        btn = view.findViewById(R.id.btnHello);

        btn.setOnClickListener(v -> {
            tv.setText("Bonjour depuis Fragment 1 !");
        });

        return view;
    }
}
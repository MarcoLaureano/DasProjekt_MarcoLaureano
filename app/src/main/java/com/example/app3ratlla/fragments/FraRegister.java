package com.example.app3ratlla.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class FraRegister extends Fragment {


    public FraRegister() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(com.example.app3ratlla.R.layout.fragment_register, container, false);
        // Aquí puedes inicializar tus vistas y establecer cualquier comportamiento necesario

        return view;
    }
}
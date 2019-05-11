package com.example.taller32.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.taller32.R;
import com.example.taller32.models.Persona;

public class ResultFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_result, container, false);
        Bundle bundle = getArguments();
        Persona persona= (Persona) bundle.getSerializable("persona");
        TextView textView = (TextView) view.findViewById(R.id.textView_result);
        textView.setText("La persona ingresa es: \n"+
                "Nombre: "+persona.getName()+"\n"+
                "Apellidos: "+persona.getLastName()+"\n"+
                "Email: "+persona.getEmail()+"\n"+
                "Teléfono: "+persona.getPhoneNumber()+"\n");
        return view;
    }

}

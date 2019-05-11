package com.example.taller32.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.taller32.FormActivity;
import com.example.taller32.R;
import com.example.taller32.models.Persona;

public class FormFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_form, container, false);
        setupUI(view);
        return view;
    }

    public void setupUI(final View view){
        Button btn = (Button)  view.findViewById(R.id.btn_save);
        final EditText editName= (EditText)  view.findViewById(R.id.editText_name);
        final EditText editLast= (EditText)  view.findViewById(R.id.editText_name);
        final EditText editEmail= (EditText)  view.findViewById(R.id.editText_name);
        final EditText editPhone= (EditText)  view.findViewById(R.id.editText_name);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent= new Intent(getContext(), ResultFragment.class);
                ResultFragment nextFrag= new ResultFragment();

                Intent intent= new Intent(getContext(), ResultFragment.class);
                String strEditName = editName.getText().toString();
                String strEditLast = editLast.getText().toString();
                String strEditEmail = editEmail.getText().toString();
                String strEditPhone = editPhone.getText().toString();
                if(!strEditName.isEmpty() && !strEditLast.isEmpty() && !strEditEmail.isEmpty()&& !strEditPhone.isEmpty()){
                    Persona persona = new Persona(strEditName,strEditLast,strEditEmail,strEditPhone);
                    enviandoResultado(persona);
                }else{
                    Toast.makeText(getContext(), "FALTAN DATOS DE LA PERSONA", Toast.LENGTH_LONG).show();
                }
//                getActivity().finish();
            }
        });
    }

    public void enviandoResultado(Persona persona){

        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ResultFragment fragment2 = new ResultFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("persona", persona);
        fragment2.setArguments(bundle);
        ft.replace(android.R.id.content, fragment2);
        ft.addToBackStack(null); //Add fragment in back stack
        ft.commit();
    }

}

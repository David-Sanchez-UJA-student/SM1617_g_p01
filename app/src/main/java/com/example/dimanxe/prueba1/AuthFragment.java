package com.example.dimanxe.prueba1;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Button;
import android.content.Intent;

/**
 * Created by dimanxe on 06/10/2016.
 */

public class AuthFragment extends Fragment{
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mUser="";
    private String mPass="";

    private EditText user = null;
    private EditText pass = null;
    private EditText ip=null;

    private Autentication autent=new Autentication();

    public AuthFragment(){

    }
    public static AuthFragment newInstance(String user, String pass) {
        AuthFragment fragment = new AuthFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, user);
        args.putString(ARG_PARAM2, pass);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState==null) {
            if (getArguments() != null) {
                mUser = getArguments().getString(ARG_PARAM1);
                mPass = getArguments().getString(ARG_PARAM2);
                autent.setmUser(mUser);
                autent.setmPass(mPass);
            }
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(savedInstanceState!=null){
            autent.setmUser(savedInstanceState.getString(ARG_PARAM1));
            autent.setmPass(savedInstanceState.getString(ARG_PARAM2));
        }
        // Inflate the layout for this fragment
        final View fragmento = inflater.inflate(R.layout.autfrag, container, false);

        //redibuja(fragmento);
        user=(EditText)fragmento.findViewById(R.id.Nombre);
        pass=(EditText)fragmento.findViewById(R.id.Pass);
        user.setText(mUser);
        pass.setText(mPass);
        Button boton = (Button)fragmento.findViewById(R.id.boton1);
        boton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
               autent.setmUser(user.getText().toString());

                Intent i;
                i = new Intent(fragmento.getContext(),Activid2.class);
                i.putExtra("User",autent.getmUser());
                i.putExtra("Pass",autent.getmPass());
                i.putExtra("IP",autent.getmIP());
                startActivity(i);
            }

                                 });


        return fragmento;

    }
    private void redibuja(View fragmento){
        user=(EditText)fragmento.findViewById(R.id.Nombre);
        pass=(EditText)fragmento.findViewById(R.id.Pass);


        user.setText(autent.getmUser());
        pass.setText(autent.getmPass());

    }
    /**public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);

        outState.putString(ARG_PARAM1,autent.getmUser());
        outState.putString(ARG_PARAM2, autent.getmPass());

    }*/
}

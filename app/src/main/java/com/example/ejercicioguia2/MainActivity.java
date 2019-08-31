package com.example.ejercicioguia2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edtCorreo, edtContraseña;
    Button btnIniciarSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(getSupportActionBar()!=null){
            getSupportActionBar().hide();
        }
        edtCorreo=findViewById(R.id.edtCorreo);
        edtContraseña=findViewById(R.id.edtContraseña);
        btnIniciarSesion.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnIniciarSesion:{
                String correo=edtCorreo.getText().toString();
                String contraseña=edtContraseña.getText().toString();
                Intent in = new Intent(this, Segunda.class);
                in.putExtra("Correo", correo);
                in.putExtra("Contraseña", contraseña);
                startAtivity(in);
            }
            break;
        }
    }
}

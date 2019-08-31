package com.example.ejercicioguia2;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

//import android.support.v7.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    EditText edtCorreo, edtContraseña;
    Button btnIniciarSesion, btnDat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtCorreo = findViewById(R.id.edtCorreo);
        edtContraseña = findViewById(R.id.edtContraseña);
        btnDat = findViewById(R.id.btnDat);
        btnIniciarSesion = findViewById(R.id.btnIniciarSesion);
        btnDat.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), Segunda.class);
                startActivityForResult(i, 0);
            }
        });
        btnIniciarSesion.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View v) {
                if(Validacion()) {
                    Intent i = new Intent(v.getContext(), AutoComplete.class);
                    startActivityForResult(i, 0);
                }
                return false;
            }
        });
    }
    public boolean Validacion(){
        boolean valor=false;
        if (edtCorreo.getText().toString().isEmpty() && edtContraseña.getText().toString().isEmpty()){
            Toast.makeText(this,"No pueden quedar vacios los campos",Toast.LENGTH_SHORT).show();
        }else{
            valor=true;
        }

        return valor;
    }
}

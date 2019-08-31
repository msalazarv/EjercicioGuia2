package com.example.ejercicioguia2;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AutoComplete extends AppCompatActivity {

    AutoCompleteTextView Autos;
    AutoCompleteTextView Carrera;
    AutoCompleteTextView Comidas;
    Button Procesar;
    int Progreso=40;
    ProgressBar PBBarra;

    boolean ValidacionClick=false;
    String [] listAutos = {"BMW","Toyota","Ferrari","Aston Martin","Honda","Renault"};
    String [] listCarreras = {"Laboratorio Clinico","Administracion","Contaduria","Educacion","Sistemas","Industrial","Electrica","Agronegocios"};
    String [] listComidas = {"Espaguethi","Lasagña","Alitas Buffalo","Frijoles","Pollo","Hamburguesa"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_complete);
        Procesar = findViewById(R.id.btnProcesar);
        Autos = findViewById(R.id.txtAuto);
        Carrera = findViewById(R.id.txtCarrera);
        Comidas = findViewById(R.id.txtComida);
        PBBarra = findViewById(R.id.PBarra);
        ArrayAdapter<String> AdapterPais = new ArrayAdapter<>(this, android.R.layout.select_dialog_item, listAutos);
        Autos.setThreshold(1);
        Autos.setAdapter(AdapterPais);

        ArrayAdapter<String> AdapterCarrera = new ArrayAdapter<>(this, android.R.layout.select_dialog_item, listCarreras);
        Carrera.setThreshold(1);
        Carrera.setAdapter(AdapterCarrera);

        ArrayAdapter<String> AdapterEquipo = new ArrayAdapter<>(this, android.R.layout.select_dialog_item, listComidas);
        Comidas.setThreshold(1);
        Comidas.setAdapter(AdapterEquipo);

        Procesar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setProgressValue(0);
                MostrarToast();
            }
        });
    }
    public void MostrarToast(){
        Toast.makeText(this,"Auto Seleccionado: " + Autos.getText()+"\n"+
                "Carrera Seleccionada: " + Carrera.getText()+"\n"+"Comida Seleccionado: " + Comidas.getText(),Toast.LENGTH_SHORT).show();
    }
    private void setProgressValue(final int progress){
        PBBarra.setProgress(progress);
        Progreso = progress;
        Thread  thread=new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                setProgressValue(progress+10);
            }
        });
        thread.start();
    }
}

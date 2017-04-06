package com.oep.capacitacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    EditText txtNombre;
    Spinner txtDepa;
    Button btnEmpezar;
    String nombre;
    String datos[] = new String[]{"La Paz","Santa Cruz","Cochabamba","Oruro"};
    String depa_escogido ="";
    ArrayAdapter<String> adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referencias a los objetos
        txtNombre = (EditText) findViewById(R.id.ed_nombre);
        txtDepa = (Spinner) findViewById(R.id.sp_departamentos);
        btnEmpezar = (Button) findViewById(R.id.btn_empezar);

        // Configurar
        btnEmpezar.setOnClickListener(this);
        adaptador= new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,datos);
        txtDepa.setAdapter(adaptador);
        txtDepa.setOnItemSelectedListener(this);
        // Setear Valores

    }

    @Override
    public void onClick(View v) {
        nombre = txtNombre.getText().toString();
        Toast.makeText(this,"Hola: "+ nombre + " tu eres de " + depa_escogido,Toast.LENGTH_SHORT).show();
        Toast.makeText(this,"Exito!!!",Toast.LENGTH_LONG).show();

        Intent intent= new Intent(MainActivity.this,SupermercadoActivity.class);
        intent.putExtra("NOMBRE KEY", nombre);
        intent.putExtra("DEPA KEY", depa_escogido);
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        depa_escogido=adaptador.getItem(position);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

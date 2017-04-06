package com.oep.capacitacion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SupermercadoActivity extends AppCompatActivity {
    TextView txtNombreP;
    TextView txtDepaP;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supermercado);

        // Referenciamos
        txtNombreP = (TextView) findViewById(R.id.tv_nombre_prod);
        txtDepaP = (TextView) findViewById(R.id.tv_depa_prod);

        // Obtenemos los valores
        Bundle mochila=getIntent().getExtras();
        String nombre= mochila.getString("NOMBRE KEY");
        String depa= mochila.getString("DEPA KEY");

        // Seteamoso
        txtNombreP.setText("Bienvenido: "+nombre);
        txtDepaP.setText("departamento: "+depa);
    }
}

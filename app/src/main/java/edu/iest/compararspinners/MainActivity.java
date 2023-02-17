package edu.iest.compararspinners;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.Arrays;


import edu.iest.compararspinners.databinding.ActivityMainBinding;

public class MainActivity extends Activity {

    private Spinner spUno;
    private Spinner spDos;
    private Button bnComparar;

    private TextView mTextView;
    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        spUno = (Spinner) findViewById(R.id.spUno);
        spDos = (Spinner) findViewById(R.id.spDos);
        bnComparar = (Button) findViewById(R.id.bnComparar);

        mTextView = binding.tvTexto;

        String[] numeros = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10").toArray(new String[0]);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, numeros);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spUno.setAdapter(adapter);
        spDos.setAdapter(adapter);

        bnComparar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String seleccionUno = (String) spUno.getSelectedItem();
                String seleccionDos = (String) spDos.getSelectedItem();
                int numUno = Integer.parseInt(seleccionUno);
                int numDos = Integer.parseInt(seleccionDos);
                String mensaje;
                if (numUno > numDos) {
                    mensaje = "El spinner 1 contiene el número mayor.";
                } else if (numUno < numDos) {
                    mensaje = "El spinner 2 contiene el número mayor.";
                } else {
                    mensaje = "Ambos spinners contienen el mismo número.";
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Resultado");
                builder.setMessage(mensaje);
                builder.setPositiveButton("OK", null);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }
}

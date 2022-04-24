package com.juasori93.proyectofinalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtPrimerDato;
    EditText txtSegundoDato;
    Button btnCalcular;
    TextView lblResultado;
    RadioButton rdbSumar;
    RadioButton rdbRestar;
    RadioButton rdbMultiplicar;
    RadioButton rdbDividir;
    RadioGroup rdgCalculo;
    double resultado;
    double numero1;
    double numero2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Match del widget
        txtPrimerDato = findViewById(R.id.txtPrimerDato);
        txtSegundoDato = findViewById(R.id.txtSegundoDato);
        btnCalcular = findViewById(R.id.btn_calcular);
        lblResultado = findViewById(R.id.txtResultado);
        rdbSumar = findViewById(R.id.rdbSumar);
        rdbRestar = findViewById(R.id.rdbRestar);
        rdbMultiplicar = findViewById(R.id.rdbMultiplicar);
        rdbDividir = findViewById(R.id.rdbDividir);
        rdgCalculo = findViewById(R.id.rdgCalculo);


        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtPrimerDato.length() != 0){
                    if (txtSegundoDato.length() != 0){
                        int checkedId = rdgCalculo.getCheckedRadioButtonId();
                        if (checkedId == -1){
                            Toast.makeText(MainActivity.this,"No hay opcion seleccionada", Toast.LENGTH_LONG).show();
                        } else {
                            numero1 = Double.parseDouble(txtPrimerDato.getText().toString());
                            numero2 = Double.parseDouble(txtSegundoDato.getText().toString());
                            encuentraRadioButton(checkedId, numero1, numero2);
                        }
                    } else {
                        txtSegundoDato.requestFocus();
                        txtSegundoDato.setError("Campo no puede estar vacio!");
                    }
                } else {
                    txtPrimerDato.requestFocus();
                    txtPrimerDato.setError("Campo no puede estar vacio!");
                }
            }
        });
    }

    private void encuentraRadioButton(int checkedId, double num1, double num2) {
        double resultado;
        switch (checkedId){
            case R.id.rdbSumar:
                resultado = num1 + num2;
                lblResultado.setText(Double.toString(resultado));
                break;
            case R.id.rdbRestar:
                resultado = num1 - num2;
                lblResultado.setText(Double.toString(resultado));
                break;
            case R.id.rdbMultiplicar:
                resultado = num1 * num2;
                lblResultado.setText(Double.toString(resultado));
                break;
            case R.id.rdbDividir:
                if (num2 == 0){
                    Toast.makeText(MainActivity.this,"No se puede dividir entre 0", Toast.LENGTH_LONG).show();
                }else{
                    resultado = num1 / num2;
                    lblResultado.setText(Double.toString(resultado));
                    break;
                }
        }
    }

}
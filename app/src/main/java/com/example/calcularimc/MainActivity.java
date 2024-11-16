package com.example.calcularimc;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView textResultado;
    private EditText editPeso;
    private EditText editAltura;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

            textResultado = findViewById(R.id.textResultado);
            editPeso = findViewById(R.id.edPeso);
            editAltura = findViewById(R.id.edAltura);

    }

    public void calcularImc(View view){

        double peso = Double.parseDouble(editPeso.getText().toString());
        double altura = Double.parseDouble(editAltura.getText().toString());
        double resultado = peso / (altura*altura);

        //se
        if(resultado<19){

            textResultado.setText("Abaixo do peso");

        }else if (resultado <= 19 || resultado < 25) {

            textResultado.setText("Peso normal");
            
        } else if (resultado <= 25 || resultado < 30) {

            textResultado.setText("Sobrepeso");
            
        }else if (resultado <= 30 || resultado < 40) {

            textResultado.setText("obesidade tipo I");

        }else if (resultado >= 40) {

            textResultado.setText("obesidade tipo II");

        }



    }

}

//modificação number 1
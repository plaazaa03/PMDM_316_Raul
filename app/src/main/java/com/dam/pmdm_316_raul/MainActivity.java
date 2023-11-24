package com.dam.pmdm_316_raul;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private int infRange = 0;
    private int supRange = 0;
    private TextView msgRangeView;
    private EditText editTextNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Tratamiento para el rango inferior
        SeekBar seekBarMin = (SeekBar) findViewById(R.id.seekBar);
        TextView txtMin = (TextView) findViewById(R.id.textView6);
        EditText editTextNumber = (EditText) findViewById(R.id.editTextNumber);
        seekBarMin.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                infRange = i;
                txtMin.setText(Integer.toString(infRange));

                //Muestra el texto con el rango del juego
                showRange();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        //Tratamiento para el rango superior
        SeekBar seekBarMax = (SeekBar) findViewById(R.id.seekBar3);
        TextView txtMax = (TextView) findViewById(R.id.textView7);
        seekBarMax.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                supRange = i;
                txtMax.setText(Integer.toString(supRange));

                //Muestra el texto con el rango del juego
                showRange();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }

    // Muestra el mensaje con el texto del rango completo
    private void showRange() {
        // Enlaza con el texto de la vista
        String msgRange = "Rango de juego entre " + infRange + " y " + supRange;
        TextView msgRangeView = (TextView) findViewById(R.id.textView8);
        msgRangeView.setText(msgRange);
    }

    //Botón inicio de partida
    public void onStart(View view) {
        Toast.makeText(this, "Inicio de partida", Toast.LENGTH_SHORT).show();

        /*
        ((Button) findViewById(R.id.button)).setEnabled(false);
        ((Button) findViewById(R.id.button2)).setEnabled(false);
        ((Button) findViewById(R.id.button3)).setEnabled(false);
         */
    }

    //Botón para comprobar el valor introducido
    public void onCheck(View view) {
        Toast.makeText(this, "Inicio de partida", Toast.LENGTH_SHORT).show();
        String userInput = editTextNumber.getText().toString();

        if (!userInput.isEmpty()) {
            int userGuess = Integer.parseInt(userInput);
            Toast.makeText(this, "Adivina el numero: " + userGuess, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Porfavor inserte un numero: ", Toast.LENGTH_SHORT).show();
        }
    }


    //Botón para abortar partida
    public void onAbort(View view) {
        Toast.makeText(this, "Partida abortada", Toast.LENGTH_SHORT).show();
    }
}
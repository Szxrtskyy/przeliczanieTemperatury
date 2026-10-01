package com.example.przeliczniktemperatur;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    RadioGroup radioGroup1, radioGroup2;
    RadioButton radioButtonCg,radioButtonKg,radioButtonFg,
                radioButtonCd,radioButtonKd,radioButtonFd;
    Button button;
    TextView textViewWynik;
    double temperatura;
    char znakTemperaturyZ;
    char getZnakTemperaturyNa;
    int zmiennaPomocnicza;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editTextText);
        radioGroup1 = findViewById(R.id.radioGroup1);
        radioGroup2 = findViewById(R.id.radioGroup2);
        radioButtonCg = findViewById(R.id.radioButton);
        radioButtonKg = findViewById(R.id.radioButton2);
        radioButtonFg = findViewById(R.id.radioButton3);
        radioButtonCd = findViewById(R.id.radioButton4);
        radioButtonKd = findViewById(R.id.radioButton5);
        radioButtonFd = findViewById(R.id.radioButton6);
        button = findViewById(R.id.button);
        textViewWynik = findViewById(R.id.textView4);
        editText.addTextChangedListener(
                new TextWatcher() {
                    @Override
                    public void afterTextChanged(Editable editable) {

                    }

                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    temperatura = Double.parseDouble(charSequence.toString());
                    textViewWynik.setText(temperatura +"");
                    }
                }
        );
        radioGroup1.setOnCheckedChangeListener(
                new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(@NonNull RadioGroup radioGroup, int i) {
                       zmiennaPomocnicza = i;
                       if(i == R.id.radioButton){
                           znakTemperaturyZ = 'C';
                       }else{
                           if(i == R.id.radioButton2){
                               znakTemperaturyZ = 'K';
                           }else{
                               znakTemperaturyZ = 'F';
                           }
                       }
                    }
                }
        );
        radioGroup2.setOnCheckedChangeListener(
                new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(@NonNull RadioGroup radioGroup, int i) {

                        if(i == R.id.radioButton4){
                            znakTemperaturyZ = 'C';
                        }else {
                            if (i == R.id.radioButton5) {
                                znakTemperaturyZ = 'K';
                            } else {
                                znakTemperaturyZ = 'F';
                            }
                        }
                    }
                }
        );
        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        double temp = Double.parseDouble(editText.getText().toString());
                        if (radioButtonCg.isChecked()){
                            if(radioButtonCd.isChecked()){

                            }else {
                                if (radioButtonKd.isChecked()){
                                    temp = temp + 273.15;
                                }else{
                                    temp = temp * 1.8 + 32;
                                }
                            }
                        }else{
                            if(radioButtonKg.isChecked()){
                                if(radioButtonKd.isChecked()){

                                }else{
                                    if(radioButtonCd.isChecked()){
                                        temp = temp - 273.15;
                                    }else{
                                        temp = ((temp - 273.15)*1.8) + 32;
                                    }
                                }
                            }else{
                                if (radioButtonFg.isChecked()){
                                    if (radioButtonFd.isChecked()){

                                    }else{
                                        if(radioButtonCd.isChecked()){
                                            temp = (temp-32)/1.8;
                                        }else{
                                            temp = ((temp-32)/1.8)+273.15;
                                        }
                                    }
                                }
                            }
                        }
                        textViewWynik.setText(temp+"");
                    }
                }
        );

    }
}
package com.example.kalkulator;


import androidx.appcompat.app.AppCompatActivity;

import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        final TextView wyswietlacz=findViewById(R.id.wyswietlacz);
        final Button n0=findViewById(R.id.n0);
        final Button n1=findViewById(R.id.n1);
        final Button n2=findViewById(R.id.n2);
        final Button n3=findViewById(R.id.n3);
        final Button n4=findViewById(R.id.n4);
        final Button n5=findViewById(R.id.n5);
        final Button n6=findViewById(R.id.n6);
        final Button n7=findViewById(R.id.n7);
        final Button n8=findViewById(R.id.n8);
        final Button n9=findViewById(R.id.n9);
        final Button kropka=findViewById(R.id.kropka);
        final Button dodawanie=findViewById(R.id.dodawanie);
        final Button dzielenie=findViewById(R.id.dzielenie);
        final Button mnozenie=findViewById(R.id.mnozenie);
        final Button odejmowanie=findViewById(R.id.odejmowanie);
        final Button rownanie=findViewById(R.id.rownanie);
        final Button nawias1=findViewById(R.id.nawiasotwirajacy);
        final Button nawias2=findViewById(R.id.nawiaszamykajacy);

        final View.OnClickListener kalkulator =new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int id=v.getId();
                switch(id){
                    case R.id.n0:
                        wyswietlacz.append("0");
                        break;

                    case R.id.n1:
                        wyswietlacz.append("1");
                        break;

                    case R.id.n2:
                        wyswietlacz.append("2");
                        break;

                    case R.id.n3:
                        wyswietlacz.append("3");
                        break;

                    case R.id.n4:
                        wyswietlacz.append("4");
                        break;

                    case R.id.n5:
                        wyswietlacz.append("5");
                        break;

                    case R.id.n6:
                        wyswietlacz.append("6");
                        break;

                    case R.id.n7:
                        wyswietlacz.append("7");
                        break;

                    case R.id.n8:
                        wyswietlacz.append("8");
                        break;

                    case R.id.n9:
                        wyswietlacz.append("9");
                        break;
                    case R.id.kropka:
                        wyswietlacz.append(".");
                        break;

                        case R.id.odejmowanie:
                            wyswietlacz.append("-");
                        break;
                    case R.id.dzielenie:

                        wyswietlacz.append("/");
                        break;

                    case R.id.mnozenie:

                        wyswietlacz.append("*");
                        break;

                    case R.id.dodawanie:
                        wyswietlacz.append("+");
                        break;

                    case R.id.nawiasotwirajacy:

                        wyswietlacz.append("(");
                        break;

                    case R.id.nawiaszamykajacy:

                        wyswietlacz.append(")");
                        break;

                    case R.id.rownanie:
                        String wynik=wyswietlacz.getText().toString();
                        ScriptEngineManager manager = new ScriptEngineManager();
                        ScriptEngine engine = manager.getEngineByName("js");
                        try {

                            Object result = engine.eval(wyswietlacz.getText().toString());
                            wyswietlacz.setText(String.valueOf(result));

                        } catch (ScriptException e) {
                            e.printStackTrace();
                        }
                        break;

                }
            }
        };

        n0.setOnClickListener(kalkulator);
        n1.setOnClickListener(kalkulator);
        n2.setOnClickListener(kalkulator);
        n3.setOnClickListener(kalkulator);
        n4.setOnClickListener(kalkulator);
        n5.setOnClickListener(kalkulator);
        n6.setOnClickListener(kalkulator);
        n7.setOnClickListener(kalkulator);
        n8.setOnClickListener(kalkulator);
        n9.setOnClickListener(kalkulator);
        dodawanie.setOnClickListener(kalkulator);
        odejmowanie.setOnClickListener(kalkulator);
        dzielenie.setOnClickListener(kalkulator);
        mnozenie.setOnClickListener(kalkulator);
        kropka.setOnClickListener(kalkulator);
        rownanie.setOnClickListener(kalkulator);
        nawias1.setOnClickListener(kalkulator);
        nawias2.setOnClickListener(kalkulator);


        final Button del=findViewById(R.id.del);
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String elementy=wyswietlacz.getText().toString();

                int lenght = elementy.length();
                if (lenght>0){
                  elementy=elementy.substring(0,lenght-1);
                  wyswietlacz.setText(elementy);

                }
            }
        });

        final Button wyczysc=findViewById(R.id.ce);
        wyczysc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wyswietlacz.setText("");
            }
        });




    }
}

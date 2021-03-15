package com.app.neocalculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button nb9, nb8, nb7, nb6, nb5,nb4, nb3, nb2, nb1, nb0;
    private TextView textNumber, textResultado;
    private Button btnSomar, btnMultiplicar, btnDividir, btnIgual, btnSubtrair, btnPonto, btnLimpar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        IniciarComponentes();
        limpar();
        calcular();

        nb0.setOnClickListener(this);
        nb1.setOnClickListener(this);
        nb2.setOnClickListener(this);
        nb3.setOnClickListener(this);
        nb4.setOnClickListener(this);
        nb5.setOnClickListener(this);
        nb6.setOnClickListener(this);
        nb7.setOnClickListener(this);
        nb8.setOnClickListener(this);
        nb9.setOnClickListener(this);
        btnPonto.setOnClickListener(this);
        btnSomar.setOnClickListener(this);
        btnDividir.setOnClickListener(this);
        btnSubtrair.setOnClickListener(this);
        btnMultiplicar.setOnClickListener(this);



    }

    private void IniciarComponentes (){
        //numeros
        nb9 = findViewById(R.id.nb9);
        nb8 = findViewById(R.id.nb8);
        nb7 = findViewById(R.id.nb7);
        nb6 = findViewById(R.id.nb6);
        nb5 = findViewById(R.id.nb5);
        nb4 = findViewById(R.id.nb4);
        nb3 = findViewById(R.id.nb3);
        nb2 = findViewById(R.id.nb2);
        nb1 = findViewById(R.id.nb1);
        nb0 = findViewById(R.id.nb0);
        //btns de operação
        btnSomar = findViewById(R.id.btnSomar);
        btnDividir = findViewById(R.id.btnDividir);
        btnMultiplicar = findViewById(R.id.btnMultiplicar);
        btnSubtrair = findViewById(R.id.btnSubtrair);

        btnIgual = findViewById(R.id.btnIgual);
        btnLimpar = findViewById(R.id.btnLimpar);
        btnPonto = findViewById(R.id.btnPonto);

        //textos da tela
        textNumber = findViewById(R.id.textNumber);
        textResultado = findViewById(R.id.textResultado);

    }

    public void calcular(){
        btnIgual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    Expression expressao = new ExpressionBuilder(textNumber.getText().toString()).build();
                    double resultado = expressao.evaluate();
                    long longResult = (long) resultado;

                    if(resultado == (double) longResult){
                        textResultado.setText((CharSequence) String.valueOf(longResult));
                    }else{
                        textResultado.setText((CharSequence) String.valueOf(resultado));

                    }
                }catch(Exception e){
                    Log.i("erro:", e.getMessage());
                }


            }
        });
    }

    public void digitarNaTela(String string, Boolean limparDados){

        if(textResultado.getText().equals("")){
            textNumber.setText(" ");
        }if(limparDados){
            textResultado.setText(" ");
            textNumber.append(string);
        }else{
            textNumber.append(textResultado.getText());
            textNumber.append(string);
            textResultado.setText(" ");
        }

    }

    public void limpar(){
        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textNumber.setText("");
                textResultado.setText("");
            }
        });
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.nb0:
                digitarNaTela("0", true);
                break;

            case R.id.nb1:
                digitarNaTela("1", true);
                break;


            case R.id.nb2:
                digitarNaTela("2", true);
                break;

            case R.id.nb3:
                digitarNaTela("3", true);
                break;

            case R.id.nb4:
                digitarNaTela("4", true);
                break;

            case R.id.nb5:
                digitarNaTela("5", true);
                break;

            case R.id.nb6:
                digitarNaTela("6", true);
                break;

            case R.id.nb7:
                digitarNaTela("7", true);
                break;


            case R.id.nb8:
                digitarNaTela("8", true);
                break;


            case R.id.nb9:
                digitarNaTela("9", true);
                break;

            //operações
            case R.id.btnSomar:
                digitarNaTela("+", false);
                break;

            case R.id.btnDividir:
                digitarNaTela("/", false);
                break;

            case R.id.btnMultiplicar:
                digitarNaTela("*", false);
                break;

            case R.id.btnSubtrair:
                digitarNaTela("-", false);
                break;

            case R.id.btnPonto:
                digitarNaTela(".", true);
                break;

        }
    }
}

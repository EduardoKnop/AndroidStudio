package com.pucpr.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button button0;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button buttonAC;
    private Button buttonMoreLess;
    private Button buttonPercentage;
    private Button buttonDivision;
    private Button buttonMultiply;
    private Button buttonLess;
    private Button buttonMore;
    private Button buttonEqual;
    private Button buttonComma;
    private TextView textCalc;
    private TextView textHist;
    private String num1 = "";
    private String num2 = "0";
    private char op = '+';

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        buttonAC = findViewById(R.id.buttonAC);
        buttonDivision = findViewById(R.id.buttonDivision);
        buttonMultiply = findViewById(R.id.buttonMultiply);
        buttonLess = findViewById(R.id.buttonLess);
        buttonMore = findViewById(R.id.buttonMore);
        buttonEqual = findViewById(R.id.buttonEqual);
        buttonComma = findViewById(R.id.buttonComma);
        buttonMoreLess = findViewById(R.id.buttonMoreLess);
        buttonPercentage = findViewById(R.id.buttonPercentage);
        textCalc = findViewById(R.id.textCalc);
        textHist = findViewById(R.id.textHist);

        button0.setOnClickListener(mostraNum);
        button1.setOnClickListener(mostraNum);
        button2.setOnClickListener(mostraNum);
        button3.setOnClickListener(mostraNum);
        button4.setOnClickListener(mostraNum);
        button5.setOnClickListener(mostraNum);
        button6.setOnClickListener(mostraNum);
        button7.setOnClickListener(mostraNum);
        button8.setOnClickListener(mostraNum);
        button9.setOnClickListener(mostraNum);
        buttonAC.setOnClickListener(mostraNum);
        buttonDivision.setOnClickListener(mostraNum);
        buttonMultiply.setOnClickListener(mostraNum);
        buttonLess.setOnClickListener(mostraNum);
        buttonMore.setOnClickListener(mostraNum);
        buttonComma.setOnClickListener(mostraNum);
        buttonMoreLess.setOnClickListener(mostraNum);
        buttonPercentage.setOnClickListener(mostraNum);
        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textHist.setText(num2 + op + num1);

                switch (op) {
                    case '/':
                        num1 = "" + (Float.parseFloat(num2) / Float.parseFloat(num1));
                        break;
                    case '*':
                        num1 = "" + (Float.parseFloat(num2) * Float.parseFloat(num1));
                        break;
                    case '-':
                        num1 = "" + (Float.parseFloat(num2) - Float.parseFloat(num1));
                        break;
                    case '+':
                        num1 = "" + (Float.parseFloat(num2) + Float.parseFloat(num1));
                        break;
                }
                textCalc.setText(num1);
            }
        });
    }

    View.OnClickListener mostraNum = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.button0:
                    num1 += "0";
                    break;
                case R.id.button1:
                    num1 += "1";
                    break;
                case R.id.button2:
                    num1 += "2";
                    break;
                case R.id.button3:
                    num1 += "3";
                    break;
                case R.id.button4:
                    num1 += "4";
                    break;
                case R.id.button5:
                    num1 += "5";
                    break;
                case R.id.button6:
                    num1 += "6";
                    break;
                case R.id.button7:
                    num1 += "7";
                    break;
                case R.id.button8:
                    num1 += "8";
                    break;
                case R.id.button9:
                    num1 += "9";
                    break;
                case R.id.buttonComma:
                    int totalComma = 0;
                    for (int i = 0; i < num1.length(); i++) {
                        if (num1.charAt(i) == '.')
                            totalComma++;
                    }

                    if (totalComma == 0)
                        num1 += ".";
                    break;
                case R.id.buttonMoreLess:
                    if (num1.charAt(0) == '-')
                        num1 = num1.replace('-', '+');
                    else if (num1.charAt(0) == '+')
                        num1 = num1.replace('+', '-');
                    else
                        num1 = '-' + num1;
                    break;
                case R.id.buttonPercentage:
                    num1 = "" + (Float.parseFloat(num1) / 100);
                    break;
                case R.id.buttonAC:
                    num1 = "";
                    num2 = "";
                    break;
                case R.id.buttonDivision:
                    num2 = num1;
                    num1 = "";
                    op = '/';
                    break;
                case R.id.buttonMultiply:
                    num2 = num1;
                    num1 = "";
                    op = '*';
                    break;
                case R.id.buttonLess:
                    num2 = num1;
                    num1 = "";
                    op = '-';
                    break;
                case R.id.buttonMore:
                    num2 = num1;
                    num1 = "";
                    op = '+';
                    break;
            }
            textCalc.setText(num1);
            textHist.setText("");
        }
    };
}
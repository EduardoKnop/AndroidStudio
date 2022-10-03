package com.pucpr.urnaeletronica;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private Button buttonOk;
    private Button buttonConfirma;
    private ImageView imagePresident;
    private EditText optVote;
    private Integer numPresident;
    private Integer voteCand1 = 0;
    private Integer voteCand2 = 0;
    private Integer voteCand3 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonOk = findViewById(R.id.okButton);
        buttonConfirma = findViewById(R.id.confirmaButton);
        imagePresident = findViewById(R.id.presidentImage);

        buttonOk.setOnClickListener(view -> {
            optVote = (EditText) findViewById(R.id.editTextNumber);
            numPresident = Integer.parseInt(optVote.getText().toString());

            switch (numPresident) {
                case 10:
                    imagePresident.setImageResource(R.drawable.r10);
                    break;
                case 13:
                    imagePresident.setImageResource(R.drawable.lula);
                    break;
                case 30:
                    imagePresident.setImageResource(R.drawable.kb);
                    break;
                default:
                    imagePresident.setImageDrawable(null);
            }
        });

        buttonConfirma.setOnClickListener(view -> {
            optVote = (EditText) findViewById(R.id.editTextNumber);
            numPresident = Integer.parseInt(optVote.getText().toString());

            switch (numPresident) {
                case 10:
                    voteCand2++;
                    showMessage("R10");
                    break;
                case 13:
                    voteCand3++;
                    showMessage("Lula");
                    break;
                case 30:
                    voteCand1++;
                    showMessage("KB");
                    break;
                default:
                    AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                    dialog.setTitle("RESULTADOS");
                    String message = "Número Inválido. Por favor escolha um dos candidatos.\n\n" +
                            "RESULTADOS ATUAIS:\nKB: " + voteCand1 + "\nR10: " + voteCand2 +
                            "\nLula: " + voteCand3;
                    dialog.setMessage(message);
                    dialog.setPositiveButton("OK", null);
                    dialog.show();
            }
            imagePresident.setImageDrawable(null);
        });
    }

    void showMessage(String candName) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
        dialog.setTitle("RESULTADOS");
        String message = "Voto para " + candName + " computado!\n\nRESULTADOS ATUAIS:\nKB: " +
                voteCand1 + "\nR10: " + voteCand2 + "\nLula: " + voteCand3;
        dialog.setMessage(message);
        dialog.setPositiveButton("OK", null);
        dialog.show();
    }
}
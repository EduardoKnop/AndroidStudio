package com.pucpr.cadastropessoas.controller;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.pucpr.cadastropessoas.R;
import com.pucpr.cadastropessoas.model.Country;
import com.pucpr.cadastropessoas.model.DataStore;
import com.pucpr.cadastropessoas.model.Person;
import com.pucpr.cadastropessoas.model.persistance.PersonDAO;

import java.util.ArrayList;
import java.util.List;

public class AddEditActivity extends AppCompatActivity {

    private ImageView imagePhoto;
    private EditText textName;
    private TextView textID;
    private CalendarView calendarBirthDate;
    private EditText textCity;
    private Spinner spinnerCountry;
    private RadioGroup radioGroup;
    private RadioButton radioButtonMale;
    private RadioButton radioButtonFemale;
    private Button buttonSave;
    private Button buttonCancel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit);

        imagePhoto = findViewById(R.id.imagePhoto);
        textName = findViewById(R.id.textName);
        textID = findViewById(R.id.textID);
        calendarBirthDate = findViewById(R.id.calendarBirthDate);
        textCity = findViewById(R.id.textCity);
        spinnerCountry = findViewById(R.id.spinnerCountry);
        radioGroup = findViewById(R.id.radioGroup);
        radioButtonMale = findViewById(R.id.radioButtonMale);
        radioButtonFemale = findViewById(R.id.radioButtonFemale);
        buttonSave = findViewById(R.id.buttonSave);
        buttonCancel = findViewById(R.id.buttonCancel);


        imagePhoto.setOnClickListener(view -> {



        });

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item,
                DataStore.sharedInstance().getCountries(this));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCountry.setAdapter(adapter);

        buttonSave.setOnClickListener(view -> {
            String name = textName.getText().toString();
            long birthDate = calendarBirthDate.getDate();
            String city = textCity.getText().toString();
            char sex;

            switch (radioGroup.getCheckedRadioButtonId()) {

                case R.id.radioButtonMale:
                    sex = 'm';
                    break;

                case R.id.radioButtonFemale:
                    sex = 'f';
                    break;

                default:
                    sex = 'u';
            }


            new Person(name, birthDate, sex, city, "Country");
        });

        buttonCancel.setOnClickListener(view -> {



        });

        int type = getIntent().getIntExtra("type", -1);
    }
}

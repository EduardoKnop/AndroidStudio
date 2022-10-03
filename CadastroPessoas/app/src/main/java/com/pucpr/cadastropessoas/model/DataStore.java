package com.pucpr.cadastropessoas.model;

import android.content.Context;

import com.pucpr.cadastropessoas.model.persistance.PersonDAO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DataStore {

    private static final String FILENAME = "database.txt";

    private static DataStore instance = new DataStore();
    private List<Person> people = new ArrayList<>();
    private PersonDAO dao;

    private DataStore() {

    }

    public void setContext(Context context) {

        dao = new PersonDAO(context);
    }

    public static synchronized DataStore sharedInstance() {
        return instance;
    }

    public void addCountry(Country country, Context context) {
        country.saveCountry(country, context);
    }

    public void clearCountries() {
        //
    }

    public List<String> getCountries(Context context) {

        ArrayList<String> countryList = new ArrayList<String>();

        try {
            InputStream inputStream = context.openFileInput(FILENAME);
            InputStreamReader streamReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(streamReader);

            while (reader.readLine() != null) {
                countryList.add(reader.readLine());
            }
        }
        catch (IOException e) {
            countryList.add("Romênia\n");
            countryList.add("Lituânia\n");
            e.printStackTrace();
        }


        return countryList;
    }

    public String getFilename() {
        return FILENAME;
    }

    public void addPerson(Person person) {
        people.add(person);

        dao.addPerson(person);
    }

    public void editPerson(Person person, int position) {
        people.set(position, person);
    }

    public void removePerson(int position) {
        people.remove(position);
    }

    public void clearPeople() {
        people.clear();
    }

    public List<Person> getPeople() {
        return people;
    }
}

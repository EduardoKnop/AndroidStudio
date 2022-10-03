package com.pucpr.cadastropessoas.model;

import android.content.Context;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Country {

    private int id;
    private String name;


    public Country(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public boolean saveCountry(Country country, Context context) {

        OutputStream outputStream = null;
        try {
            outputStream = context.openFileOutput(DataStore.sharedInstance().getFilename(),
                    Context.MODE_PRIVATE|Context.MODE_APPEND);
            OutputStreamWriter writer = new OutputStreamWriter(outputStream);
            writer.write(country.getName() + "\n");
            writer.flush();
            writer.close();
            outputStream.close();

            return true;
        }
        catch (FileNotFoundException e) {

            e.printStackTrace();
        }
        catch (IOException e) {

            e.printStackTrace();
        }

        return false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

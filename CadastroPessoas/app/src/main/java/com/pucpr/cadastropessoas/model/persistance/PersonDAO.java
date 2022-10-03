package com.pucpr.cadastropessoas.model.persistance;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.pucpr.cadastropessoas.model.Person;

public class PersonDAO extends SQLiteOpenHelper {

    private final static String DB_NAME = "people.sqlite";
    private final static int DB_VERSION = 1;

    private final static String DB_TABLE = "people";
    private final static String COL_ID = "id";
    private final static String COL_NAME = "name";
    private final static String COL_BIRTHDATE = "birthdate";
    private final static String COL_SEX = "sex";
    private final static String COL_HOMETOWN = "city";
    private final static String COL_NATIONALITY = "country";
    private final static String COL_PHOTO = "photo";

    private Context context;

    public PersonDAO(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);

        this.context = context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE IF NOT EXISTS " + DB_TABLE + " (" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_NAME + " TEXT, " +
                COL_BIRTHDATE + " REAL, " +
                COL_SEX + " TEXT, " +
                COL_HOMETOWN + " TEXT, " +
                COL_NATIONALITY + " TEXT, " +
                COL_PHOTO + " BLOB);";

        db.execSQL(sql);
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    public boolean addPerson(Person person) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COL_NAME, person.getName());
        values.put(COL_BIRTHDATE, person.getBirthDate());
        values.put(COL_SEX, "" + person.getSex());
        values.put(COL_HOMETOWN, person.getHometown());
        values.put(COL_NATIONALITY, person.getNationality());
        values.put(COL_PHOTO, "" + person.getPhoto());

        long id = db.insert(DB_TABLE, null, values);
        person.setId((int) id);

        db.close();


        if (id > 0) {

            return true;
        }
        return false;
    }
}

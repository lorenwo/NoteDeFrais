package com.example.formationapp.dao;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "user.roles.db";
    private static final int DATABASE_VERSION = 1;
    private static final String CREATE_TABLE_USER =
            "CREATE TABLE User (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "nom TEXT NOT NULL," +
                    "prenom TEXT NOT NULL," +
                    "email TEXT UNIQUE NOT NULL," +
                    "password TEXT NOT NULL," +
                    "roleId INTEGER," +
                    "FOREIGN KEY(roleId) REFERENCES Role(id))";
    private static final String CREATE_TABLE_NoteDeFrais =
            "CREATE TABLE NoteDeFrais (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                    "date TEXT NOT NULL,"+
                    "montant TEXT NOT NULL," +
                    "details TEXT NOT NULL," +
                    "villeDepart TEXT," +
                    "villeArrivee TEXT," +
                    "nomClient TEXT," +
                    "distance TEXT," +
                    "lieuDepart TEXT," +
                    "lieuArrivee TEXT," +
                    "nomClient TEXT," +
                    "kilometrage TEXT," +
                    "photocopieCarteGrise TEXT," +
                    "nomSociete TEXT ," +
                    "justificatif TEXT," +
                    "FOREIGN KEY(userId) REFERENCES User(id)," +
                    "FOREIGN KEY(typeId) REFERENCES Type(id))";

    private static final String CREATE_TABLE_ROLE =
            "CREATE TABLE Role (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "roleName TEXT NOT NULL)";
    public DatabaseHelper(Context context) {
        super (context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate (SQLiteDatabase db){
        db.execSQL(CREATE_TABLE_ROLE);
        db.execSQL(CREATE_TABLE_USER);
        db.execSQL(CREATE_TABLE_NoteDeFrais);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion, int newVersion){
    }
}

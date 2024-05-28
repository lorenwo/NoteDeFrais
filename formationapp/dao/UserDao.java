package com.example.formationapp.dao;
import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.formationapp.MyApplication;
import com.example.formationapp.entity.Role;
import com.example.formationapp.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserDao {

    private static RoleDao roleDao;

    //Create
    public static void saveUser(User user) {
        SQLiteDatabase db =
                MyApplication.getDbHelper().getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("email", user.getEmail());
        values.put("password", user.getPassword());
        values.put("nom", user.getNom());
        values.put("prenom", user.getPrenom());
        values.put("roleId", user.getRole().getId());
        db.insert("User", null, values);
        //db.close();
    }

    // Read (Single User)
    @SuppressLint("Range")
    public User findUserById(int userId) {
        SQLiteDatabase db =
                MyApplication.getDbHelper().getReadableDatabase();
        Cursor cursor = db.query("User", null, "id=?", new String[]
                {String.valueOf(userId)}, null, null, null);

        User user = null;
        if (cursor.moveToFirst()) {
            user = new User();
            user.setId(cursor.getInt(cursor.getColumnIndex("id")));
            user.setEmail(cursor.getString(cursor.getColumnIndex("email")));
            user.setPassword(cursor.getString(cursor.getColumnIndex("password")));
            user.setNom(cursor.getString(cursor.getColumnIndex("nom")));
            user.setPrenom(cursor.getString(cursor.getColumnIndex("prenom")));

            int roleId = cursor.getInt(cursor.getColumnIndex("roleId"));
            Role role = RoleDao.findRoleById(roleId);
            user.setRole(role);
        }
        cursor.close();
        db.close();
        return user;
    }
    //Read (All Users)
    @SuppressLint("Range")
    public static List<User> findAllUsers() {
        List<User> users = new ArrayList<>();
        SQLiteDatabase db =
                MyApplication.getDbHelper().getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM User", null);

        if (cursor.moveToFirst()) {
            do {
                User user = new User();
                user.setId(cursor.getInt(cursor.getColumnIndex("id")));
                user.setEmail(cursor.getString(cursor.getColumnIndex("email")));
                user.setPassword(cursor.getString(cursor.getColumnIndex("password")));
                user.setNom(cursor.getString(cursor.getColumnIndex("nom")));
                user.setPrenom(cursor.getString(cursor.getColumnIndex("prenom")));

                int roleId =
                        cursor.getInt(cursor.getColumnIndex("roleId"));
                Role role = roleDao.findRoleById(roleId);
                user.setRole(role);

                users.add(user);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return users;
    }

    //Update
public static int updateUser(User user) {
    SQLiteDatabase db =
MyApplication.getDbHelper().getWritableDatabase();
    ContentValues values = new ContentValues();
    values.put("email", user.getEmail());
    values.put("password", user.getPassword());
    values.put("nom", user.getNom());
    values.put("prenom", user.getPrenom());
    values.put("roleId", user.getRole().getId());

    int rowsAffected = db.update("User", values, "id=?", new String[]
{String.valueOf(user.getId())});
    db.close();
    return rowsAffected;
    }
    //Delete
    public static void deleteUser(int userId){
        SQLiteDatabase db = MyApplication.getDbHelper().getWritableDatabase();
        db.delete("User", "id=?", new String[]{String.valueOf(userId)});
        db.close();
    }

@SuppressLint("Range")
    public static User findUserByEmailAndPassword(String email, String password){
        SQLiteDatabase db = MyApplication.getDbHelper().getReadableDatabase();

        String[] columns = new String[]{"id","email", "password",
        "nom", "prenom", "roleId"};
        String[] selectionArgs = new String[] {email, password};

    String selection = null + "=?";
    Cursor cursor = db.query("User", columns, selection, selectionArgs, null, null, null);

    User user = null;
    if (cursor.moveToFirst()) {
        user = new User();
        user.setId(cursor.getInt(cursor.getColumnIndex("id")));
        user.setEmail(cursor.getString(cursor.getColumnIndex("email")));
        user.setPassword(cursor.getString(cursor.getColumnIndex("password")));
        user.setNom(cursor.getString(cursor.getColumnIndex("nom")));
        user.setPrenom(cursor.getString(cursor.getColumnIndex("prenom")));

        int roleId = cursor.getInt(cursor.getColumnIndex("roleId"));
        Role role = RoleDao.findRoleById(roleId);
        user.setRole(role);
    }
    cursor.close();
    db.close();
    return user;
}

}





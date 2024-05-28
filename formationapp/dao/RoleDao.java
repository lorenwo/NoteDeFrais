package com.example.formationapp.dao;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.formationapp.MyApplication;
import com.example.formationapp.entity.Role;

public class RoleDao {
    public static void saveRole(Role role) {
        SQLiteDatabase db =
                MyApplication.getDbHelper().getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("roleName", role.getRoleName());
        db.insert("Role", null, values);
        db.close();
    }

    @SuppressLint("Range")
    public static Role findRoleById(int roleId) {
        SQLiteDatabase db =
                MyApplication.getDbHelper().getReadableDatabase();
        Cursor cursor = db.query("Role", new String[]{"id", "roleName"},
                "id=?", new String[]{String.valueOf(roleId)}, null, null, null);
        Role role = null;
        if (cursor.moveToFirst()) {
            role = new Role();
            role.setId(cursor.getInt(cursor.getColumnIndex("id")));

            role.setRoleName(cursor.getString(cursor.getColumnIndex("roleName")));
        }

        cursor.close();
      //  db.close();
        return role;
    }

    public int updateRole(Role role) {
        SQLiteDatabase db =
                MyApplication.getDbHelper().getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("roleName", role.getRoleName());

        int rowsAffected = db.update("Role", values, "id=?", new String[]
                {String.valueOf(role.getId())});
        db.close();
        return rowsAffected;
    }

    //Delete
    public void deleteRole(int roleId) {
        SQLiteDatabase db =
MyApplication.getDbHelper().getWritableDatabase();
        db.delete("Role","id=?", new String[]{String.valueOf(roleId)});
        db.close();
        }
}

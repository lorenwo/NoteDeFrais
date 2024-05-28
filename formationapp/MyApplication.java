package com.example.formationapp;


import android.app.Application;
import com.example.formationapp.dao.DatabaseHelper;
import com.example.formationapp.dao.RoleDao;
import com.example.formationapp.entity.Role;


public class MyApplication extends Application {
    private static DatabaseHelper dbHelper;


    @Override
    public void onCreate(){
        super.onCreate();

        dbHelper = new DatabaseHelper(getApplicationContext());

        /* Role role1 = new Role();
        role1.setRoleName("ROLE_USER");
        Role role2 = new Role();
        role2.setRoleName("ROLE_ADMIN");

        RoleDao.saveRole(role1);
        RoleDao.saveRole(role2);*/

        dbHelper.getWritableDatabase();


    }
    public static DatabaseHelper getDbHelper(){
        return dbHelper;
    }
    public static void setDbHelper(DatabaseHelper dbHelper){
        MyApplication.dbHelper = dbHelper;
    }

}

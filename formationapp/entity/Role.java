package com.example.formationapp.entity;

import com.example.formationapp.Sérialisable;

public class Role implements Sérialisable {
    private int id;
    private String roleName;
//getters et setters
public int getId() {
    return id;
}
    public void setId(int id) {
        this.id = id;
    }
public String getRoleName() {
    return roleName;
}
public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}

package com.example.formationapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.example.formationapp.dao.RoleDao;
import com.example.formationapp.dao.UserDao;
import com.example.formationapp.entity.User;
public class RegisterActivity extends AppCompatActivity {
    private EditText editTextEmail, editTextPassword, editTextNom, editTextPrenom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextNom = findViewById(R.id.editTextNom);
        editTextPrenom = findViewById(R.id.editTextPrenom);
        Button buttonRegister = findViewById(R.id.buttonRegister);

        buttonRegister.setOnClickListener(view -> registerUser());
    }
    private void registerUser() {
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        String nom = editTextNom.getText().toString().trim();
        String prenom = editTextPrenom.getText().toString().trim();
        // Validation des champs (à implémenter)

        User newUser = new User();
        newUser.setEmail(email);
        newUser.setPassword(password);
        newUser.setNom(nom);
        newUser.setPrenom(prenom);
        newUser.setRole(RoleDao.findRoleById(1));

        UserDao.saveUser(newUser);



        Toast.makeText(this, "Utilisateur enregistré avec succès", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();

    }
}

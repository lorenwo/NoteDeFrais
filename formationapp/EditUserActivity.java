package com.example.formationapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.formationapp.R;
import com.example.formationapp.entity.User;
import com.example.formationapp.dao.UserDao;

public class EditUserActivity extends AppCompatActivity {
    private EditText editTextNom, editTextPrenom , editTextEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user);
        editTextNom = findViewById(R.id.editTextEditNom);
        editTextPrenom = findViewById(R.id.editTextEditPrenom);
        editTextEmail = findViewById(R.id.editTextEditEmail);
        Button buttonSaveChanges = findViewById(R.id.buttonUpdate);
        User user =  (User) getIntent().getSerializableExtra("user_id");
        editTextEmail.setText(user.getEmail());
        editTextNom.setText(user.getNom());
        editTextPrenom.setText(user.getPrenom());
        buttonSaveChanges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nom = editTextNom.getText().toString().trim();
                String prenom = editTextPrenom.getText().toString().trim();
                String email = editTextEmail.getText().toString().trim();
                user.setEmail(nom);
                user.setPrenom(prenom);
                user.setEmail(email);
                UserDao.updateUser(user);
                Intent intent = new Intent(EditUserActivity.this,   ListUserActivity.class);
                setResult(RESULT_OK);
                startActivity(intent);

                finish();
            }
        });
    }
}
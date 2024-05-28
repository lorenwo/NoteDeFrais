package com.example.formationapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.formationapp.dao.UserDao;
import com.example.formationapp.entity.User;

public class MainActivity extends AppCompatActivity {
    private EditText emailEditText;
    private EditText passwordEditText;

    Button loginButton ;
    private Button buttonRegister;
    @SuppressLint("MissingInflatedId")
    @Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        emailEditText = findViewById(R.id.email);
        passwordEditText = findViewById(R.id.password);
        loginButton = findViewById(R.id.login_button);
        buttonRegister = findViewById(R.id.buttonRegisterM);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               login();
            }
        });

        buttonRegister.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
    Intent intent = new Intent(MainActivity.this,RegisterActivity.class);
    startActivity(intent);
    finish();
        }
        });
}
private void login() {
    String email = emailEditText.getText().toString().trim();
    String password = passwordEditText.getText().toString().trim();

    if (email.isEmpty() || password.isEmpty()) {
        Toast.makeText(this, "Veuillez remplir tous les champs.",
Toast.LENGTH_SHORT).show();
    return; // Arrêtez la méthode ici si les champs sont vides
}
     User user = UserDao.findUserByEmailAndPassword(email, password);

        if (user != null) {
Intent intent = new Intent(MainActivity.this, HomeActivity.class);
        startActivity(intent);
        finish();
        } else {
        Toast.makeText(this, "Informations d'identification " +
                "invalides.", Toast.LENGTH_SHORT).show();
        }
}
}

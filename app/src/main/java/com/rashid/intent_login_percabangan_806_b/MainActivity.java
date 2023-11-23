package com.rashid.intent_login_percabangan_806_b;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    EditText userName, password;
    Button login, batal;
    CheckBox showPassword;
    String usernameLogin, passwordLogin, userDefault, passwordDefault;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userName = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        batal = findViewById(R.id.batal);
        showPassword = findViewById(R.id.showPassword);

        showPassword.setOnClickListener(v -> {
            if (showPassword.isChecked()) {
                password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            } else {
                password.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        });

        batal.setOnClickListener(v -> {
            userName.setText(null);
            password.setText(null);
            if (showPassword.isChecked()) showPassword.setChecked(false);
        });

        login.setOnClickListener(v -> {
            usernameLogin = userName.getText().toString();
            passwordLogin = password.getText().toString();

            if (usernameLogin.isEmpty() || passwordLogin.isEmpty()) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage(getString(R.string.emptyUserPass)).setNegativeButton(getString(R.string.wrong), null).create().show();
            } else {
                userDefault = "admin";
                passwordDefault = "1234";
                if (Objects.equals(usernameLogin, userDefault) && Objects.equals(passwordLogin, passwordDefault)) {
                    Intent intent = new Intent(this, biodataActivity.class);
                    this.startActivity(intent);
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage(getString(R.string.wrongUserPass)).setNegativeButton(getString(R.string.wrong), null).create().show();

                }
            }
        });

    }
}
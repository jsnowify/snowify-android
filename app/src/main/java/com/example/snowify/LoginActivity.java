package com.example.snowify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText username, password;
    Button btnLogin;
    UserDataBase snowifyDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        // LOGIN INPUT FIELDS
        username = findViewById(R.id.userNameLogin);
        password = findViewById(R.id.passwordLogin);

        // DATABASE
        snowifyDB = new UserDataBase(this);

        // BUTTON
        btnLogin = findViewById(R.id.loginBtn);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                String usernameLogin = username.getText().toString();
                String passwordLogin = password.getText().toString();

                if(usernameLogin.equals("") || passwordLogin.equals("")){
                    Toast.makeText(LoginActivity.this, "Please Enter all the Fields!", Toast.LENGTH_SHORT).show();
                }else {
                    Boolean checkUserNamePassword = snowifyDB.checkUserNamePassword(usernameLogin, passwordLogin);
                    if (checkUserNamePassword == true) {
                        Toast.makeText(LoginActivity.this, "Successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this, Welcome.class);
                        intent.putExtra("username", usernameLogin);
                        startActivity(intent);
                    } else {
                        Toast.makeText(LoginActivity.this, "Invalid Password or Email", Toast.LENGTH_SHORT).show();
                    }

                }


            }
        });

        TextView createAccount = findViewById(R.id.createAccountHyper);
        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle the click event here, i.e., start SignUpActivity
                Intent intent = new Intent(LoginActivity.this, SignUp.class);
                startActivity(intent);
            }
        });
    }
    }
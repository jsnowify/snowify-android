package com.example.snowify;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

    // Buttons and EditText
    Button btnSignUp;
    EditText username, email ,password, repassword;
    UserDataBase snowifyDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        // INPUT FIELDS ID:
        username = findViewById(R.id.usernameSign);
        email = findViewById(R.id.emailSign);
        password = findViewById(R.id.passwordSign);
        repassword = findViewById(R.id.repasswordSign);

        // DATABASE INITIALIZATION
        snowifyDB = new UserDataBase(this);

        // BUTTON
        btnSignUp = findViewById(R.id.signUpBtn);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            String usernamesign = username.getText().toString();
            String emailsign = email.getText().toString();
            String passwordsign = password.getText().toString();
            String repasswordsign = repassword.getText().toString();

            if(usernamesign.equals("") || emailsign.equals("") ||passwordsign.equals("") ||repasswordsign.equals("") ){
                Toast.makeText(SignUp.this, "Enter all the fields!", Toast.LENGTH_SHORT).show();
            }else {
                if(passwordsign.equals(repasswordsign)) {
                    Boolean checkuser =snowifyDB.checkUserName(usernamesign);
                    if (checkuser == false){
                        Boolean insert = snowifyDB.insertData(usernamesign, emailsign, passwordsign);
                        if(insert==true){
                            Intent intent = new Intent(SignUp.this, LoginActivity.class);
                            Toast.makeText(SignUp.this, "Account Created Successfully", Toast.LENGTH_SHORT).show();
                            startActivity(intent);
                        }else {
                            Toast.makeText(SignUp.this, "Registration Failed", Toast.LENGTH_SHORT).show();

                        }
                    }
                    else{
                        Toast.makeText(SignUp.this, "Username Already Exist", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(SignUp.this, "Password Doesn't Make", Toast.LENGTH_SHORT).show();
                }
            }
            }
        });

        TextView hyperTxt = findViewById(R.id.hyperTxt);
        hyperTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle the click event here, i.e., start LoginActivity
                Intent intent = new Intent(SignUp.this, LoginActivity.class);
                startActivity(intent);
            }
        });


    }
}

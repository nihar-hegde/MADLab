package com.example.signupactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText emailEditText,passwordEditText;
    Button signBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        emailEditText=findViewById(R.id.emailEditText);
        passwordEditText=findViewById(R.id.passwordEditText);
        signBtn=findViewById(R.id.signBtn);
        signBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email =emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                if(!isValidPassword(password)){
                    Toast.makeText(MainActivity.this,"Password do not match the rules",Toast.LENGTH_LONG).show();
                    return;
                }
                Intent intent = new Intent(MainActivity.this,LogInActivity.class);
                intent.putExtra("email",email);
                intent.putExtra("password",password);
                startActivity(intent);
            }
        });
    }
    Pattern lowerCase = Pattern.compile("^.*[a-z].*$");
    Pattern upperCase = Pattern.compile("^.*[A-Z].*$");
    Pattern number = Pattern.compile("^.*[0-9].*$");
    Pattern specialCharacters = Pattern.compile("^.*[a-zA-Z0-9].*$");
    private Boolean isValidPassword(String password){
        if(password.length()<8){
            return false;
        }
        if(!lowerCase.matcher(password).matches()){
            return false;
        }
        if(!upperCase.matcher(password).matches()){
            return false;
        }
        if(!number.matcher(password).matches()){
            return false;
        }
        if(!specialCharacters.matcher(password).matches()){
            return false;
        }
        return true;
    }
}
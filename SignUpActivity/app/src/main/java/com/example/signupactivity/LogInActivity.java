package com.example.signupactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LogInActivity extends AppCompatActivity {
    EditText emailEditText,passwordEditText;
    Button loginBtn;
    int counter = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        emailEditText=findViewById(R.id.emailEditText);
        passwordEditText=findViewById(R.id.passwordEditText);
        loginBtn=findViewById(R.id.loginBtn);
        String registeredEmail=getIntent().getStringExtra("email");
        String registeredPassword=getIntent().getStringExtra("password");
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=emailEditText.getText().toString();
                String password=passwordEditText.getText().toString();
                if(registeredEmail.equals(email)&&registeredPassword.equals(password)){
                    Intent intent=new Intent(LogInActivity.this,SuccessfulLogin.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(LogInActivity.this,"Invalid Credentials",Toast.LENGTH_LONG).show();
                }
                counter--;
                if(counter==0){
                    Toast.makeText(getBaseContext(),"Failed Login Attempts",Toast.LENGTH_LONG).show();
                    loginBtn.setEnabled(false);
                }
            }
        });
    }
}
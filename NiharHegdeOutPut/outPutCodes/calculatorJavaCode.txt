package com.example.calculator1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText e1,e2;
    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=findViewById(R.id.e1);
        e2=findViewById(R.id.e2);
        tv1=findViewById(R.id.tv1);
    }
    public void ADD(View V){
        int a1 = Integer.parseInt(e1.getText().toString());
        int a2 = Integer.parseInt(e2.getText().toString());
        int result = a1+a2;
        tv1.setText(""+result);
    }
    public void SUB(View V){
        int a1 = Integer.parseInt(e1.getText().toString());
        int a2 = Integer.parseInt(e2.getText().toString());
        int result = a1-a2;
        tv1.setText(""+result);
    }
    public void MUL(View V){
        int a1 = Integer.parseInt(e1.getText().toString());
        int a2 = Integer.parseInt(e2.getText().toString());
        int result = a1*a2;
        tv1.setText(""+result);
    }
    public void DIV(View V){
        int a1 = Integer.parseInt(e1.getText().toString());
        int a2 = Integer.parseInt(e2.getText().toString());
        if(a2==0){
            Toast.makeText(getApplicationContext(),"Cannot Divide By Zero!!!",Toast.LENGTH_LONG).show();
        }else {
            int result = a1 / a2;
            tv1.setText("" + result);
        }
    }
}
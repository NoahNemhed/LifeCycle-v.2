package com.example.uppgift2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText username,password;
    Button submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Declaring variables.
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        submit = (Button) findViewById(R.id.submit);


        //Onclick
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkCredentials(username.getText().toString(), password.getText().toString())){
                    switchActivity();
                }else{
                    username.setText("");
                    password.setText("");
                }
            }
        });


    }


    public boolean checkCredentials(String uName, String pWord){
        if(uName.toLowerCase().equals("admin") && pWord.toLowerCase().equals("admin")){
            return true;
        }
        return false;
    }

    public void switchActivity(){
        Intent intent = new Intent(this,MainActivity2.class);
        startActivity(intent);

    }









}
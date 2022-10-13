package com.example.uppgift2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity3 extends AppCompatActivity {

    private TextView fname,lname,age,city,license;
    private Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        fname = findViewById(R.id.fname);
        if (fname == null) { Log.w("", "TextView is null"); }
        lname = findViewById(R.id.lname);
        if (lname == null) { Log.w("", "TextView is null"); }
        age = findViewById(R.id.age);
        if (age == null) { Log.w("", "TextView is null"); }
        city = findViewById(R.id.city);
        if (city == null) { Log.w("", "TextView is null"); }
        license = findViewById(R.id.license);
        if (license == null) { Log.w("", "TextView is null"); }
        logout = findViewById(R.id.logout);


        //Sparar ner värdena som skickades ifrån activity2
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String firstName = getIntent().getStringExtra("fname");
            String lastName = getIntent().getStringExtra("lname");
            String city1 = getIntent().getStringExtra("city");
            String age1 = getIntent().getStringExtra("age");
            boolean license1 = Boolean.parseBoolean(getIntent().getStringExtra("license"));
            fname.setText("Firstname - " + firstName);
            lname.setText("Lastname - " + lastName);
            age.setText("Age - " + age1);
            city.setText("City - " + city1);
            license.setText("Has driver license - " + license1);
        }

        logout.setOnClickListener(view -> setLogout());
    }

    public void setLogout(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

}
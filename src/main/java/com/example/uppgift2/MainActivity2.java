package com.example.uppgift2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {

    private EditText fname,lname,age,city;
    private CheckBox driverLicense;
    private Button submit,logout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //Declaring variables.
        fname = findViewById(R.id.fname);
        if (fname == null) { Log.w("", "TextView is null"); }
        lname = findViewById(R.id.lname);
        if (lname == null) { Log.w("", "TextView is null"); }
        age = findViewById(R.id.age);
        if (age == null) { Log.w("", "TextView is null"); }
        city = findViewById(R.id.city);
        if (city == null) { Log.w("", "TextView is null"); }
        driverLicense = findViewById(R.id.yes);
        if (driverLicense == null) { Log.w("", "TextView is null"); }

        submit = findViewById(R.id.submit);
        logout = findViewById(R.id.logout);


        //Onclick
        submit.setOnClickListener(view -> {
              if(checkForm(fname.getText().toString(), lname.getText().toString(), city.getText().toString())){

            driverLicense.setChecked(true);
                  //Skickar vidare till acitivity 3 och lägger in värdena från formuläret
               Intent intent = new Intent(this,MainActivity3.class);
               intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
               intent.putExtra("fname", fname.getText().toString());
               intent.putExtra("lname", lname.getText().toString());
               intent.putExtra("city", city.getText().toString());
               intent.putExtra("license", driverLicense.isChecked());
               intent.putExtra("age", age.getText().toString());

               startActivity(intent);
           }
        });

        logout.setOnClickListener(view -> setLogout());


    }


    public void setLogout(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }


    public boolean checkForm(String fname, String lname, String city){
        if(!fname.equals("") && !lname.equals("") && !city.equals("")){
            return true;
        }
        return false;

    }






}
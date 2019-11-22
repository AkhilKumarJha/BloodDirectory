package com.example.ashish.blooddonation;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class SignUp extends AppCompatActivity {


    EditText e1, e2, e3, e4, e5, e6, e7;
    AutoCompleteTextView actv;
    Button b1;
    RadioButton r1, r2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        e1 = (EditText) findViewById(R.id.e1);
        e2 = (EditText) findViewById(R.id.e2);
       // e3 = (EditText) findViewById(R.id.e3);

        actv = (AutoCompleteTextView)findViewById(R.id.autotextid);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.Bgroup));

        actv.setAdapter(adapter);
        actv.setThreshold(1);

        r1 = (RadioButton) findViewById(R.id.rb1);
        r2 = (RadioButton) findViewById(R.id.rb2);
        e4 = (EditText) findViewById(R.id.e4);
        e5 = (EditText) findViewById(R.id.e5);
        e6 = (EditText) findViewById(R.id.e6);
        e7 = (EditText) findViewById(R.id.e7);
        b1 = (Button) findViewById(R.id.create);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name=e1.getText().toString();
                String age=e2.getText().toString();
                String bgroup=actv.getText().toString();
                String gender;
                String mobile=e4.getText().toString();
                String address=e5.getText().toString();
                String password=e6.getText().toString();
                String cpassword=e7.getText().toString();
                if(r1.isChecked()){
                    gender="male";
                }
                else
                {
                    gender="female";
                }

                if(name.length()==0)
                {
                    e1.requestFocus();
                    e1.setError("Field can not be Empty");
                }
              else if(age.length()==0||Integer.parseInt(age)<18)
                {
                    e2.requestFocus();
                    e2.setError("Enter the correct age");
                }
                else if(bgroup.length()==0)
                {
                    actv.requestFocus();
                    actv.setError("Field can not be Empty");

                }
                else if(!r1.isChecked()&&!r2.isChecked())
                {   r1.requestFocus();
                    r1.setError("Select the gender");
                }
                else if(mobile.length()!=10){
                    e4.requestFocus();
                    e4.setError("Mobile NO. is either empty or wrong");
                }

                else if(address.length()==0)
                {
                    e5.requestFocus();
                    e5.setError("This field can not Empty");
                }
                else if(password.length()<8){
                    e6.setText("");
                    e7.setText("");
                    e6.requestFocus();
                    e6.setError("Password must be length of 8");
                }
                else if(cpassword.length()<8&&password!=cpassword)
                {
                    e6.setText("");
                    e6.requestFocus();
                    e7.setText("");
                    e6.setError("Password is not matched");
                }
                else
                {
                    AppDataBase dataBase = new AppDataBase(SignUp.this);
                    dataBase.insertData(name,age,bgroup,gender,mobile,address,password);
                    Toast.makeText(SignUp.this, "Create account successfully", Toast.LENGTH_SHORT).show();
                   Intent intent=new Intent(SignUp.this,Login.class);
                    startActivity(intent);
                    e1.setText("");e2.setText("");actv.setText("");e4.setText("");e5.setText("");e6.setText("");e7.setText("");
                }
            }
        });
    }
}





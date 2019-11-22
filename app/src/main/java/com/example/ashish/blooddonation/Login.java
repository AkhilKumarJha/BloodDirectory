package com.example.ashish.blooddonation;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Login extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void Select(View v) {
        EditText number = (EditText) findViewById(R.id.mno);
        EditText pass = (EditText) findViewById(R.id.password);
        String a = number.getText().toString();
        String b = pass.getText().toString();
        AppDataBase database = new AppDataBase(Login.this);

            if(database.checkMobile(a)&&database.checkPassword(b)){
            Intent intent=new Intent(this,SearchPage.class);
                startActivity(intent);
                number.setText("");
                pass.setText("");
            }

            else
            {    number.setText("");
                pass.setText("");
                number.requestFocus();
                Toast.makeText(this,"Either Mobile no. or Password is wrong",Toast.LENGTH_SHORT).show();

            }
        number.requestFocus();

    }
    }

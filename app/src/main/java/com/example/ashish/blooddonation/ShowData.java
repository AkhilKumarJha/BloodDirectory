package com.example.ashish.blooddonation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ShowData extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);
        Log.v("heollo2","sdfsfds");
         final ListView list = (ListView) findViewById(R.id.listView);
        final ArrayList<Person> filelist =  (ArrayList<Person>)getIntent().getSerializableExtra("FILES_TO_SEND");
        customAdopter cc =new customAdopter(ShowData.this,R.layout.layoutforperson,filelist);
        list.setAdapter(cc);
       list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               customAdopter cc =new customAdopter(ShowData.this,R.layout.layoutforperson,filelist);
                String value=cc.getMobile(position);
                Intent intent=new Intent(ShowData.this,Message.class);
                intent.putExtra("Mobile",value);
                startActivity(intent);

         }
        });



    }
}

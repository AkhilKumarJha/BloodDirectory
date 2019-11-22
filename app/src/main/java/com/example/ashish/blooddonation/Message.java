package com.example.ashish.blooddonation;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Message extends AppCompatActivity {

    String mobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        Intent rint=getIntent();

        mobile=rint.getStringExtra("Mobile").toString();



        }

    public void send(View view) {
        EditText editText=(EditText)findViewById(R.id.message);
        String msg = " "+editText.getText().toString();
        Log.v("test", msg);
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:" + mobile));
            intent.putExtra("sms_body", msg);
            startActivity(intent);

            Toast.makeText(getApplicationContext(), "SMS Sent!",
                    Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(),
                    "SMS faild, please try again later!",
                    Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
        editText.setText("");
    }

}

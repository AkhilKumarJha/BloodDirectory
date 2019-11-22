package com.example.ashish.blooddonation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ashish on 10/4/17.
 */

public class customAdopter extends ArrayAdapter<Person> {
    ArrayList<Person> personArrayList = new ArrayList<>();
    public customAdopter(Context context, int textViewResourceId, ArrayList<Person> objects) {
        super(context, textViewResourceId, objects);
        personArrayList = objects;
    }
    public int getCount() {
        return super.getCount();
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.layoutforperson, null);
        TextView textView1 = (TextView) v.findViewById(R.id.text1);
         textView1.setText("Name : "+personArrayList.get(position).getName());
        TextView textView2 = (TextView) v.findViewById(R.id.text2);
        textView2.setText("Age : "+personArrayList.get(position).getAge());
        TextView textView3 = (TextView) v.findViewById(R.id.text3);
        textView3.setText("Blood Group : "+personArrayList.get(position).getBgroup());
        TextView textView4 = (TextView) v.findViewById(R.id.text4);
        textView4.setText("Gender : "+personArrayList.get(position).getGender());
        TextView textView5 = (TextView) v.findViewById(R.id.text5);
        textView5.setText("Mobile No. : "+personArrayList.get(position).getMobiNo());
        TextView textView6 = (TextView) v.findViewById(R.id.text6);
        textView6.setText("Adress : "+personArrayList.get(position).getAddress());

        return v;
    }
    public String getMobile(int position){
        String mobile = "";
        if(personArrayList.size() >0){
            mobile = personArrayList.get(position).getMobiNo();
        }
        return mobile;
    }
}

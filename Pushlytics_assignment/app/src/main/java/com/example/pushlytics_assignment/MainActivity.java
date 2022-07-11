package com.example.pushlytics_assignment;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    Spinner sp1,sp2,sp3,sp4;
    private AutoCompleteTextView country,state,district,center;
    ListView list;
    String [] Country = {"India","USA","Canada","Great Britan","New Zealand"};
    String [] State = {"Maharashtra","Karnataka","California","New York","Ontario","Manitoba","Greater London","Hampshire","Northland","Auckland"};
    String [] Districts = {"Mumbai","Bengaluru","San Fransisco","New York","Toronto","Winnipeg","Interlake","London","East Hampshire","New Forest","Auckland","Franklin"};
    String [] Center = {"Mumbai","Bengaluru","San Fransisco","New York","Toronto","Winnipeg","London","East Hampshire","Auckland","Franklin"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp1 = (Spinner) findViewById(R.id.countryspinner1);
        sp2 = (Spinner) findViewById(R.id.statespinner2);
        sp3 = (Spinner) findViewById(R.id.districtspinner3);
        sp4 = (Spinner) findViewById(R.id.centerspinner4);

        sp1.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,Country));
        sp2.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,State));
        sp3.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,Districts));
        sp4.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,Center));

      //  country = (AutoCompleteTextView) findViewById(R.id.countrytextview1);
        //state = (AutoCompleteTextView) findViewById(R.id.statetextview2);
       // district = (AutoCompleteTextView) findViewById(R.id.districttextview3);
       // center = (AutoCompleteTextView) findViewById(R.id.centertextview4);

    }
}
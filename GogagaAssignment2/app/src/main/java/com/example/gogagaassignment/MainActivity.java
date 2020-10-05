package com.example.gogagaassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    Button request,offering,recommend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        request = (Button) findViewById(R.id.btn_request);
        offering = (Button)findViewById(R.id.btn_offerings);
        recommend = (Button)findViewById(R.id.btn_recommends);

        request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FirstFragment firstFragment = new FirstFragment();
                FragmentManager manager = getSupportFragmentManager();
                manager.beginTransaction().add(R.id.mainlayout,firstFragment).commit();

            }
        });

        offering.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SecondFragment secondFragment = new SecondFragment();
                FragmentManager manager = getSupportFragmentManager();
                manager.beginTransaction().add(R.id.mainlayout,secondFragment).commit();

            }
        });

        recommend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Third_Fragment third_fragment = new Third_Fragment();
                FragmentManager manager = getSupportFragmentManager();
                manager.beginTransaction().add(R.id.mainlayout,third_fragment).commit();

            }
        });
    }
}

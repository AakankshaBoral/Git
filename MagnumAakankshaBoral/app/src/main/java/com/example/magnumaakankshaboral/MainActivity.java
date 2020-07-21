package com.example.magnumaakankshaboral;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText search_text;
    Button search;
    String search_string;
    private static final String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        search_text = findViewById(R.id.search_edittext);
        search = findViewById(R.id.search_b);





        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                search_string = search_text.getText().toString();

                Intent i = new Intent(getApplicationContext(),UserList.class);
                i.putExtra("github_Search_string",search_string);
                startActivity(i);

                Log.e(TAG,"Github Search String is :- "+search_string);

                Toast.makeText(getApplicationContext(),"Github Search string in edit text is " + search_string,Toast.LENGTH_LONG).show();
            }
        });
    }
}

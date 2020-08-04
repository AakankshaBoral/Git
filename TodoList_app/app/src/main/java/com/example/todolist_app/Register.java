package com.example.todolist_app;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register extends AppCompatActivity {

    Button register;
    EditText name,number,email,pass,dob,gender;
    String str_name,str_number,str_email,str_pass,str_dob,str_gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        register = (Button)findViewById(R.id.register_btn_2);
        name = (EditText)findViewById(R.id.name_edittext);
        number = (EditText)findViewById(R.id.number_edittext);
        email = (EditText)findViewById(R.id.email_edittext);
        pass = (EditText)findViewById(R.id.password_edittext);
        dob = (EditText)findViewById(R.id.dob_edittext);
        gender = (EditText)findViewById(R.id.gender_edittext);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                str_name = name.getText().toString();
                str_email = email.getText().toString();
                str_gender = gender.getText().toString();
                str_pass = pass.getText().toString();
                str_number = number.getText().toString();
                str_dob = dob.getText().toString();

                name.setText("");
                number.setText("");
                email.setText("");
                pass.setText("");
                dob.setText("");
                gender.setText("");


            }
        });

    }
}

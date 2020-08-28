package com.example.todolist_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TodoList extends AppCompatActivity {

    EditText add_task;
    Button task_btn;
    String task_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_list);

        add_task = (EditText)findViewById(R.id.add_task_edittext);
        task_btn = (Button)findViewById(R.id.add_task_btn);


        task_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                task_name = add_task.getText().toString();
                add_task.setText("");

                Toast.makeText(getApplicationContext(),"Task added to database",Toast.LENGTH_LONG).show();

            }
        });
    }
}

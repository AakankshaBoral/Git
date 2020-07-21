package com.example.magnumaakankshaboral;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class UserList extends AppCompatActivity {

    String Search_string_user_name;
    private ProgressBar progressBar;
    private ListView lv;
    private static String url = "https://api.github.com/search/users?q=saransh&page=2";
    ArrayList<ArrayList<String>> github_list;
    List<String> Gitlist_login_name;
    ArrayList<String> Image_name;
    private RecyclerView recyclerView;
    private Github_Adapter github_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerview);
        github_list = new ArrayList<ArrayList<String>>();

        Search_string_user_name = getIntent().getStringExtra("github_Search_string");
        Log.i("Github Search String is",Search_string_user_name);

        Toast.makeText(this, "Github Search String Is :-  " + Search_string_user_name,Toast.LENGTH_LONG).show();

        github_list = new GetGithubList().return_arraylist();
        github_adapter = new Github_Adapter(github_list);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(github_adapter);
        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
                return false;
            }

            @Override
            public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });




    }
}

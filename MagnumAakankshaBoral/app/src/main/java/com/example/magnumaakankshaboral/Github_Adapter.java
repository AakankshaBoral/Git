package com.example.magnumaakankshaboral;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;

class Github_Adapter extends RecyclerView.Adapter<Github_Adapter.MyViewHolder> {

    public TextView Login_name;
    public ImageView avatar_image_view;
    ArrayList<ArrayList<String>> github_list;

    ArrayList<GitList> new_list = new ArrayList<>();
    public Github_Adapter(ArrayList<ArrayList<String>> github_list) {
    this.github_list = github_list;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            Login_name = itemView.findViewById(R.id.login_name_display);
            avatar_image_view = itemView.findViewById(R.id.avatar_image_view_display);
        }
    }

    @NonNull
    @Override
    public Github_Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Github_Adapter.MyViewHolder holder, int position) {




    }

    @Override
    public int getItemCount() {
        return 0;
    }


}

package com.example.golearn.myAdapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.golearn.R;
import com.example.golearn.myActivities.ContentActivity;
import com.example.golearn.myActivities.HomeActivity;

import java.util.ArrayList;

public class RecyclerTopicNamesAdapter extends RecyclerView.Adapter<RecyclerTopicNamesAdapter.MyViewHolder> {

    public ArrayList<String> courseList;

    public RecyclerTopicNamesAdapter(ArrayList<String> courseList) {
        this.courseList=courseList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_item,viewGroup,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.topicTitle.setText(courseList.get(i).trim());
    }

    @Override
    public int getItemCount() {
        return courseList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public AppCompatTextView topicTitle;
        public Context context;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            topicTitle = itemView.findViewById(R.id.topic_name);
            context = itemView.getContext();

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    Bundle bundle = new Bundle();

                    context.startActivity(new Intent(context, ContentActivity.class));
                }
            });
        }


    }
}


package com.example.golearn.myActivities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.golearn.R;
import com.example.golearn.myAdapters.RecyclerTopicNamesAdapter;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    public ArrayList<String> courseTopics;
    public RecyclerView recyclerView;
    public RecyclerTopicNamesAdapter recyclerTopicNamesAdapter;
    public LinearLayoutManager linearLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_home);

        recyclerView = findViewById(R.id.recyclerView);

        courseTopics = new ArrayList<>();

        courseTopicsSetter(courseTopics);

        recyclerTopicNamesAdapter = new RecyclerTopicNamesAdapter(courseTopics);

        linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);

        recyclerView.setAdapter(recyclerTopicNamesAdapter);

        recyclerView.setLayoutManager(linearLayoutManager);


    }

    public void courseTopicsSetter(ArrayList<String> arrayList){
        //Write JSON parser here to read the json from firebase and append the data to arrayList
        for (int i=0;i<25;i++){
            int k=i+1;
            arrayList.add("Manual Topic "+k);
        }
    }
}

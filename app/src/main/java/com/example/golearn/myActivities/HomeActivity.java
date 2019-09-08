package com.example.golearn.myActivities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.golearn.R;
import com.example.golearn.myAdapters.RecyclerTopicNamesAdapter;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
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

        courseTopics = courseTopicsSetter(topicSetter());

        recyclerTopicNamesAdapter = new RecyclerTopicNamesAdapter(courseTopics);

        linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);

        recyclerView.setAdapter(recyclerTopicNamesAdapter);

        recyclerView.setLayoutManager(linearLayoutManager);


    }

    public ArrayList<String> courseTopicsSetter(String topicSetter){
        //Write JSON parser here to read the json from firebase and append the data to arrayList
//        for (int i=0;i<25;i++){
//            int k=i+1;
//            arrayList.add("Manual Topic "+k);
        //}
    if(topicSetter!=null){
        try{
            JSONObject jsonObject = new JSONObject(topicSetter);
            JSONArray myManualTestingArray = jsonObject.getJSONArray("manual_testing");
            ArrayList<String> listdata = new ArrayList();
            if (myManualTestingArray != null) {
                for (int i=0;i<myManualTestingArray.length();i++){
                    listdata.add(myManualTestingArray.getString(i));
                }
            }
            return listdata;
        }catch (Exception e){
            System.out.println("JsonObject Exception");
        }

    }else{
        System.out.println("TopicSetter is null");
        return null;
    }
    return null;
    }

    public String topicSetter(){
        String json = null;
        try{
            InputStream inputStream = getResources().openRawResource(R.raw.topics_list);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, "UTF-8");
            return json;
        }catch (Exception e){

        }
        return null;
    }
}

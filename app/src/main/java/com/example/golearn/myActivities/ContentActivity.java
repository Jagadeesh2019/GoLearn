package com.example.golearn.myActivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.golearn.R;
public class ContentActivity extends AppCompatActivity {

    public TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
           textView = findViewById(R.id.topicTitleHolder);

           //Catch the bundle and display the test in textView

        Bundle bundle = getIntent().getExtras();
        String topicKeyIndex = bundle.getString("TopicIndex");
        textView.setText(topicKeyIndex);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
    }
}

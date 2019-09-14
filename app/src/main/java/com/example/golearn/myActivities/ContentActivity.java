package com.example.golearn.myActivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.golearn.R;
public class ContentActivity extends AppCompatActivity {

    public TextView topicTitleHolder;
    public TextView definitionHeader,definitionContent;
    public TextView analogyHeader,analogyContent;
    public TextView expHeader,expContent;
    public TextView impPointsHeader,impPointsContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        topicTitleHolder = findViewById(R.id.topicTitleHolder);
        definitionHeader = findViewById(R.id.definitionHeader);
        definitionContent = findViewById(R.id.definitionContent);
        analogyHeader = findViewById(R.id.analogyHeader);
        analogyContent = findViewById(R.id.analogyContent);
        expHeader = findViewById(R.id.expHeader);
        expContent = findViewById(R.id.expContent);
        impPointsHeader = findViewById(R.id.impPointsHeader);
        impPointsContent = findViewById(R.id.impPointsContent);


           //Catch the bundle and display the text in textView

        Bundle bundle = getIntent().getExtras();
        String topicKeyIndex = bundle.getString("TopicIndex");
        topicTitleHolder.setText(topicKeyIndex);
        definitionContent.setText("\t \t Topic Definition Goes Here");
        analogyContent.setText("\t \t Topic Analogy Goes Here");
        expContent.setText("\t \t Topic Explanation Goes Here");
        impPointsContent.setText("\t \t -Topic Important Points Goes Here");

    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
    }
}

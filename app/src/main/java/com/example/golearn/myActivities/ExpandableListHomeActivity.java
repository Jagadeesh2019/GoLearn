package com.example.golearn.myActivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;

import com.example.golearn.R;
import com.example.golearn.myAdapters.ExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class ExpandableListHomeActivity extends AppCompatActivity {

    ExpandableListAdapter expandableListAdapter;
    ExpandableListView expandableListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable_list_home);

        //get the expandable list view
        expandableListView = (ExpandableListView)findViewById(R.id.expandableListView);

        //prepare list data
        prepareListData();

        //preparing Adapter
        expandableListAdapter = new ExpandableListAdapter(this,listDataHeader,listDataChild);

        //setting listAdapter
        expandableListView.setAdapter(expandableListAdapter);


        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                return false;
            }
        });


        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Intent intent = new Intent(getApplicationContext(),ContentActivity.class);
                Bundle bundle = new Bundle();
                String data = listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition);
                bundle.putString("TopicIndex",data);
                intent.putExtras(bundle);
                startActivity(intent);
                return false;
            }
        });


    }

    private void prepareListData(){
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String,List<String>>();

        //Adding Group Data
        listDataHeader.add("Header 1");
        listDataHeader.add("Header 2");
        listDataHeader.add("Header 3");
        listDataHeader.add("Header 4");


        //Adding Child Data
        List<String> header1 = new ArrayList<>();
        header1.add("Sub Topic 1");
        header1.add("Sub Topic 2");
        header1.add("Sub Topic 3");
        header1.add("Sub Topic 4");
        header1.add("Sub Topic 5");
        header1.add("Sub Topic 6");


        //Adding Child Data
        List<String> header2 = new ArrayList<>();
        header2.add("Sub Topic 1");
        header2.add("Sub Topic 2");
        header2.add("Sub Topic 3");
        header2.add("Sub Topic 4");
        header2.add("Sub Topic 5");
        header2.add("Sub Topic 6");


        //Adding Child Data
        List<String> header3 = new ArrayList<>();
        header3.add("Sub Topic 1");
        header3.add("Sub Topic 2");
        header3.add("Sub Topic 3");
        header3.add("Sub Topic 4");
        header3.add("Sub Topic 5");
        header3.add("Sub Topic 6");


        //Adding Child Data
        List<String> header4 = new ArrayList<>();
        header4.add("Sub Topic 1");
        header4.add("Sub Topic 2");
        header4.add("Sub Topic 3");
        header4.add("Sub Topic 4");
        header4.add("Sub Topic 5");
        header4.add("Sub Topic 6");


        listDataChild.put(listDataHeader.get(0),header1);
        listDataChild.put(listDataHeader.get(1),header2);
        listDataChild.put(listDataHeader.get(2),header3);
        listDataChild.put(listDataHeader.get(3),header4);

    }

}

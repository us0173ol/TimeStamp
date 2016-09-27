package com.bignerdranch.android.timestamp;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    Date created;

    public void timeItem(){
        this.created = new Date();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //create button to add an item to the listview
        Button addTime = (Button) findViewById(R.id.add_time_button);
        //create listview for displaying items and time
        ListView timeListView = (ListView) findViewById(R.id.time_added_listview);
        //Array adapter to manage the array list
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.time_list_adapter, R.id.time_list_item, new ArrayList<String>());
        //set the adapter to the listview
        timeListView.setAdapter(arrayAdapter);
        //what to do when the addtime button is clicked
        addTime.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //call method to create a new time/date
                timeItem();
                //convert time/date to string for display
                String timeText = created.toString();
                //add the time to the list
                arrayAdapter.add(timeText);
                //update the UI
                arrayAdapter.notifyDataSetChanged();
            }
        });
    }
}

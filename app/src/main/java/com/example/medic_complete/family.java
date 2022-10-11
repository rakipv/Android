package com.example.medic_complete;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.LinkedList;
import java.util.List;

public class family extends AppCompatActivity {
String[] data={" Ramesh","Suresh","Vani"};
int counter=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);
        List<String> items= new LinkedList<>();
        items.add("rakesh");
        RecyclerView recyclerView=findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        DemoAdapter adapter=new DemoAdapter(items);
        recyclerView.setAdapter(adapter);
        findViewById(R.id.addMembers).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                items.add(data[counter%3]);
                counter++;
                adapter.notifyItemInserted(items.size()-1
                );
            }
        });

    }
}
package com.example.medic_complete;

import android.app.Activity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;



import java.util.ArrayList;

public class Recycle extends Activity implements RemoveClickListner{
    private RecyclerView mRecyclerView;
    private RecyclerAdapter mRecyclerAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    Button btnAddItem;
    ArrayList<RecyclerData> myList = new ArrayList<>();
    EditText etTitle, etDescription;
    String title = "",description = "";
    ImageView crossImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerAdapter = new RecyclerAdapter(myList,this);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mRecyclerAdapter);
        etTitle = (EditText) findViewById(R.id.etTitle);
        etDescription = (EditText) findViewById(R.id.etDescription);
        btnAddItem = (Button) findViewById(R.id.btnAddItem);
        btnAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title = etTitle.getText().toString();
                description = etDescription.getText().toString();
                if (title.matches("")) {
                    Toast.makeText(v.getContext(), "You did not enter a Title", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (description.matches("")) {
                    Toast.makeText(v.getContext(), "You did not enter a description", Toast.LENGTH_SHORT).show();
                    return;
                }

                RecyclerData mLog = new RecyclerData();
                mLog.setTitle(title);
                mLog.setDescription(description);
                myList.add(mLog);
                mRecyclerAdapter.notifyData(myList);
                etTitle.setText("");
                etDescription.setText("");
            }
        });
    }
    @Override
    public void OnRemoveClick(int index) {
        myList.remove(index);
        mRecyclerAdapter.notifyData(myList);
    }
}
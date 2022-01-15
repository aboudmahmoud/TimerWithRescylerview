package com.example.qiwazapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.qiwazapp.moudle.datamoudle;

import java.util.ArrayList;

public class Winlattery extends AppCompatActivity {
RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winlattery);
        rv=(RecyclerView)findViewById(R.id.resveiw);
        ArrayList<datamoudle> data =new ArrayList();
        data.add(new datamoudle(R.drawable.ainme));
        data.add(new datamoudle(R.drawable.jacket));
        data.add(new datamoudle(R.drawable.cd));
        data.add(new datamoudle(R.drawable.pcgameing));

        ResclerViewAdpeter viewAdpeter = new ResclerViewAdpeter(data);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(layoutManager);
        rv.setAdapter(viewAdpeter);
    }
}
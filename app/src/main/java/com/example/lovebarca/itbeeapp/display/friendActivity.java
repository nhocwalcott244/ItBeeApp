package com.example.lovebarca.itbeeapp.display;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.lovebarca.itbeeapp.Adapter.beeadapter;
import com.example.lovebarca.itbeeapp.R;
import com.example.lovebarca.itbeeapp.object.bee;

import java.util.ArrayList;

public class friendActivity extends AppCompatActivity {
    ArrayList<bee> arrBee = new ArrayList<bee>();
    beeadapter adapter = null;
    ListView lvBee = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend);
        lvBee = (ListView)findViewById(R.id.lvBee);
        arrBee = new ArrayList<bee>();
        bee bee1 = new bee();
        bee1.setName("Do Nguyet Anh");
        bee bee2 = new bee();
        bee2.setName("Doan Hoa Khiem");
        arrBee.add(bee1);
        arrBee.add(bee2);
        adapter = new beeadapter(this, R.layout.my_bee_layout,arrBee);
        lvBee.setAdapter(adapter);
    }
}

package com.example.lovebarca.itbeeapp.display;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.lovebarca.itbeeapp.Adapter.jobadapter;
import com.example.lovebarca.itbeeapp.R;
import com.example.lovebarca.itbeeapp.object.job;

import java.util.ArrayList;

public class suggestionJobActivity extends AppCompatActivity {
    ArrayList<job> arrJob = new ArrayList<job>();
    jobadapter adapter = null;
    ListView lvJob = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggestion_job);
        lvJob = (ListView)findViewById(R.id.lvJob);
        arrJob = new ArrayList<job>();
        job j1 = new job();
        j1.setNameofjob("Lap trinh vien PHP");
        j1.setSalaryofjob("9-12 tr");
        j1.setAddressofjob("Ba Trieu Ha Noi");
        job j2 = new job();
        j2.setNameofjob("Lap trinh vien Android");
        j2.setAddressofjob("Hoan Kiem Ha Noi");
        j2.setSalaryofjob("10-20 tr tuy nawng luc");
        arrJob.add(j1);
        arrJob.add(j2);
        adapter = new jobadapter(this, R.layout.my_job_layout,arrJob);
        lvJob.setAdapter(adapter);
    }
}

package com.example.lovebarca.itbeeapp.display;

import android.app.Activity;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;
import android.widget.Toast;

import com.example.lovebarca.itbeeapp.Adapter.beeadapter;
import com.example.lovebarca.itbeeapp.Adapter.jobadapter;
import com.example.lovebarca.itbeeapp.MyJsonReader;
import com.example.lovebarca.itbeeapp.R;
import com.example.lovebarca.itbeeapp.object.job;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class goodJobActivity extends Activity {
    ArrayList<job> arrJob = new ArrayList<job>();
    jobadapter adapter = null;
    ListView lvJob = null;
    job j1 = new job();
    job j2 = new job();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_good_job);
        lvJob = (ListView)findViewById(R.id.lvJob);
    }
    protected void onResume() {
// TODO Auto-generated method stub
        super.onResume();
        new MyJsonTask().execute("http://itbee.vn/getjobinfo/40964216");
//new MyJsonTask().execute("http://graph.facebook.com/barackobama");
//new MyJsonTask().execute("http://graph.facebook.com/kyduyenhoahau");
    }
    //Lớp xử lý đa tiến trình:
    public class MyJsonTask extends AsyncTask<String, JSONObject, Void>
    {
        @Override
        protected void onPreExecute() {
// TODO Auto-generated method stub
            super.onPreExecute();
        }
        @Override
        protected Void doInBackground(String... params) {
//Lấy URL truyền vào
            String url=params[0];
            JSONObject jsonObj;
            try {
//đọc và chuyển về JSONObject
                jsonObj = MyJsonReader.readJsonFromUrl(url);
                publishProgress(jsonObj);
            } catch (IOException e) {
// TODO Auto-generated catch block
                e.printStackTrace();
            } catch (JSONException e) {
// TODO Auto-generated catch block
                e.printStackTrace();
            }
            return null;
        }
        @Override
        protected void onProgressUpdate(JSONObject... values) {
            super.onProgressUpdate(values);
//ta cập nhật giao diện ở đây:
            JSONObject jsonObj=values[0];
            try {

                if(jsonObj.has("job_name")){
                    j1.setNameofjob(jsonObj.getString("job_name"));
//                    Toast t = Toast.makeText(topBeeActivity.this,bee1.getName(),Toast.LENGTH_SHORT);
//                    t.show();
                    if (jsonObj.has("job_min_salary")){
                        j1.setSalaryofjob(jsonObj.getString("job_min_salary"));
                    }
                    if (jsonObj.has("job_address")){
                        j1.setAddressofjob(jsonObj.getString("job_address"));
                    }
                    arrJob.add(j1);
                    adapter = new jobadapter(goodJobActivity.this, R.layout.my_job_layout,arrJob);
                    lvJob.setAdapter(adapter);

                }



            } catch (JSONException e) {
                Toast.makeText(goodJobActivity.this, e.toString(),
                        Toast.LENGTH_LONG).show();
                e.printStackTrace();
            }
        }
        @Override
        protected void onPostExecute(Void result) {
// TODO Auto-generated method stub
            super.onPostExecute(result);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}

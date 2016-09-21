package com.example.lovebarca.itbeeapp.display;

import android.app.Activity;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;
import android.widget.Toast;

import com.example.lovebarca.itbeeapp.Adapter.beeadapter;
import com.example.lovebarca.itbeeapp.MyJsonReader;
import com.example.lovebarca.itbeeapp.R;
import com.example.lovebarca.itbeeapp.object.bee;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class topBeeActivity extends Activity {
    ArrayList<bee> arrBee = new ArrayList<bee>();
    beeadapter adapter = null;
    ListView lvBee = null;
    bee bee1 = new bee();
    bee bee2 = new bee();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_bee);
        lvBee = (ListView)findViewById(R.id.lvBee);
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

                if(jsonObj.has("bee_name")){
                   bee1.setName(jsonObj.getString("bee_name"));
//                    Toast t = Toast.makeText(topBeeActivity.this,bee1.getName(),Toast.LENGTH_SHORT);
//                    t.show();
                    arrBee.add(bee1);
                    adapter = new beeadapter(topBeeActivity.this, R.layout.my_bee_layout,arrBee);
                    lvBee.setAdapter(adapter);

                }



            } catch (JSONException e) {
                Toast.makeText(topBeeActivity.this, e.toString(),
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

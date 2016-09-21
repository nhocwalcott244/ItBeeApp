package com.example.lovebarca.itbeeapp.display;

import android.app.Activity;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.ListView;
import android.widget.Toast;

import com.example.lovebarca.itbeeapp.Adapter.companyadapter;
import com.example.lovebarca.itbeeapp.Adapter.jobadapter;
import com.example.lovebarca.itbeeapp.MyJsonReader;
import com.example.lovebarca.itbeeapp.R;
import com.example.lovebarca.itbeeapp.object.company;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class topCompanyActivity extends Activity {
    ArrayList<company> arrCompany = new ArrayList<company>();
    companyadapter adapter = null;
    ListView lvCompany = null;
    company c1 = new company();
    company c2 = new company();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_company);
        lvCompany = (ListView) findViewById(R.id.lvCompany);

    }
    protected void onResume() {
// TODO Auto-generated method stub
        super.onResume();
        new MyJsonTask().execute("http://itbee.vn/getcom/4192");
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

                if(true){
                    c1.setNameOfCompany(jsonObj.getJSONObject("boss").getString("boss_name"));
                    Toast t = Toast.makeText(topCompanyActivity.this,"nguyetAnh",Toast.LENGTH_SHORT);
                    t.show();
                    if (true){
                        c1.setAddressOfCompany(jsonObj.getJSONObject("boss").getString("boss_headquater"));
                    }
                    if (true){
                        c1.setTimeOfCreate(jsonObj.getJSONObject("boss").getString("boss_phone"));
                    }
                    arrCompany.add(c1);
                    adapter = new companyadapter(topCompanyActivity.this, R.layout.my_company_layout,arrCompany);
                    lvCompany.setAdapter(adapter);

                }



            } catch (JSONException e) {
                Toast.makeText(topCompanyActivity.this, e.toString(),
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

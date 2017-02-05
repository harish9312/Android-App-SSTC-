package com.example.harishsoni.finalproject2.Notice;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.harishsoni.finalproject2.R;

/**
 * Created by Harish Soni on 10-Jul-16.
 */
public class NoticeActivity extends Activity {
    //JSON_URL Defines the URL to fetch the data
    public static final String JSON_URL = "http://ssgiedrp.pe.hu/fetch_notice.php";
    ListView lvNotices;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notice_layout);
        lvNotices = (ListView) findViewById(R.id.lvNotices);
        sendRequest();

    }
    private void sendRequest(){

        StringRequest stringRequest = new StringRequest(JSON_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        showJSON(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(NoticeActivity.this,error.getMessage(),Toast.LENGTH_LONG).show();

                    }

                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void showJSON(String json){
        ParseJSON pj = new ParseJSON(json);
        pj.parseJSON();
        CustomList cl = new CustomList(this, ParseJSON.notice_title,ParseJSON.notice_body,ParseJSON.notice_by,ParseJSON.notice_date);
        lvNotices.setAdapter(cl);
    }

    }
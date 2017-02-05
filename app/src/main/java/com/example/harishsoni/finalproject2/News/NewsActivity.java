package com.example.harishsoni.finalproject2.News;

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
public class NewsActivity extends Activity {

    public static final String JSON_URL = "http://ssgiedrp.pe.hu/fetch_news.php";
    ListView lvNews;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_layout);
        lvNews = (ListView) findViewById(R.id.lvNews);
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
                        Toast.makeText(NewsActivity.this,error.getMessage(),Toast.LENGTH_LONG).show();

                    }

                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void showJSON(String json){
        ParseJSONForNews pj = new ParseJSONForNews(json);
        pj.parseJSONForNews();
        CustomListForNews cl = new CustomListForNews(this, ParseJSONForNews.news_title,ParseJSONForNews.news_body);
        lvNews.setAdapter(cl);
    }

    }
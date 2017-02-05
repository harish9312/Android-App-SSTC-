package com.example.harishsoni.finalproject2.CT1Results;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.harishsoni.finalproject2.R;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class CT1ResultsActivity extends AppCompatActivity{
    SharedPreferences sharedPreferences,sharedPreferences1;
    SharedPreferences.Editor editor,editor1;
    ListView lvTestResults;
    String stdId,stdPass;
    int resCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_results);
        lvTestResults = (ListView) findViewById(R.id.lvTestResults);
        sharedPreferences = getSharedPreferences("prefName",MODE_APPEND);
        sharedPreferences1 = getSharedPreferences("checkRes",MODE_APPEND);
        editor = sharedPreferences.edit();
        editor1 = sharedPreferences1.edit();

        stdId = sharedPreferences.getString("stdID",null);
        resCode = sharedPreferences1.getInt("CT",0);


        showResults();


    }

    public void showResults() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);

try{
    String link;

    if(resCode ==1)
    {
        link = "http://ssgiedrp.pe.hu/ct1_results.php";;
    }
    else
    {
        link = "http://ssgiedrp.pe.hu/ct2_results.php";;
    }
    String data  = URLEncoder.encode("std_id", "UTF-8") + "=" + URLEncoder.encode(stdId, "UTF-8");

        URL url = new URL(link);
        URLConnection conn = url.openConnection();

        conn.setDoOutput(true);
        OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());

        wr.write( data );
        wr.flush();

        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

//        StringBuilder sb = new StringBuilder();
  String res="";

        String line = null;

        // Read Server Response
        while((line = reader.readLine()) != null)
        {
           res+=line;
        }

    showJSON(res);
    }
    catch(Exception e){

        String ex = e.toString();
    }


}

    public void showJSON(String res) {
        ParseJSONForCT1Results parseJSON = new ParseJSONForCT1Results(res);
        parseJSON.ParseJSON1();
        ListDataForCT list = new ListDataForCT(this, ParseJSONForCT1Results.sub1, ParseJSONForCT1Results.sub2,ParseJSONForCT1Results.sub3,ParseJSONForCT1Results.sub4,ParseJSONForCT1Results.sub5,ParseJSONForCT1Results.sub6);
        lvTestResults.setAdapter(list);


    }

}


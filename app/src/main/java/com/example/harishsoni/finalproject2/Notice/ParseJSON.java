package com.example.harishsoni.finalproject2.Notice;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Belal on 9/22/2015.
 */
public class ParseJSON {
    public static String[] notice_title;
    public static String[] notice_body;
    public static String[] notice_by;
    public static String[] notice_date;


    public static final String JSON_ARRAY = "notices";
    public static final String KEY_NOTICE_TITLE = "notice_title";
    public static final String KEY_NOTICE_BODY = "notice_body";
    public static final String KEY_NOTICE_BY = "notice_by";
    public static final String KEY_NOTICE_DATE = "notice_date";



    private JSONArray notices = null;

    private String json;

    public ParseJSON(String json){
        this.json = json;
    }

    public void parseJSON(){
        JSONObject jsonObject=null;
        try {
            jsonObject = new JSONObject(json);
            notices = jsonObject.getJSONArray(JSON_ARRAY);

            notice_body = new String[notices.length()];
            notice_title = new String[notices.length()];
            notice_by = new String[notices.length()];
            notice_date = new String[notices.length()];
           
            for(int i=0;i<notices.length();i++){
                JSONObject jo = notices.getJSONObject(i);
                notice_title[i] = jo.getString(KEY_NOTICE_TITLE);
                notice_body[i] = jo.getString(KEY_NOTICE_BODY);
                notice_by[i] = jo.getString(KEY_NOTICE_BY);
                notice_date[i] = jo.getString(KEY_NOTICE_DATE);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}

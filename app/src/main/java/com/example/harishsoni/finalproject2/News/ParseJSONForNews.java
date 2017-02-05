package com.example.harishsoni.finalproject2.News;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Belal on 9/22/2015.
 */
public class ParseJSONForNews {
    public static String[] news_title;
    public static String[] news_body;


    public static final String JSON_ARRAY = "news";
    public static final String KEY_NEWS_TITLE = "news_title";
    public static final String KEY_NEWS_BODY = "news_body";
    


    private JSONArray news = null;

    private String json;

    public ParseJSONForNews(String json){
        this.json = json;
    }

    protected void parseJSONForNews(){
        JSONObject jsonObject=null;
        try {
            jsonObject = new JSONObject(json);
            news = jsonObject.getJSONArray(JSON_ARRAY);

            news_title = new String[news.length()];
            news_body = new String[news.length()];
           
            for(int i=0;i<news.length();i++){
                JSONObject jo = news
                        .getJSONObject(i);
                news_title[i] = jo.getString(KEY_NEWS_TITLE);
                news_body[i] = jo.getString(KEY_NEWS_BODY);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}

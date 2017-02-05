package com.example.harishsoni.finalproject2.CT1Results;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Harish Soni on 08-Jul-16.
 */
public class ParseJSONForCT1Results {

    public static String[] sub1;
    public static String[] sub2;
    public static String[] sub3;
    public static String[] sub4;
    public static String[] sub5;
    public static String[] sub6;

    public static final String JSON_ARRAY = "ct1_results";
    public static final String KEY_SUB1 = "sub1";
    public static final String KEY_SUB2 = "sub2";
    public static final String KEY_SUB3 = "sub3";
    public static final String KEY_SUB4 = "sub4";
    public static final String KEY_SUB5 = "sub5";
    public static final String KEY_SUB6 = "sub6";

    private JSONArray ct1_results = null;
    private String json;

    public ParseJSONForCT1Results(String json) {
        this.json = json;
    }

    void ParseJSON1() {

        JSONObject jsonObject = null;

        try {
            jsonObject = new JSONObject(json);
            ct1_results = jsonObject.getJSONArray(JSON_ARRAY);

            sub1 = new String[ct1_results.length()];
            sub2 = new String[ct1_results.length()];
            sub3 = new String[ct1_results.length()];
            sub4 = new String[ct1_results.length()];
            sub5 = new String[ct1_results.length()];
            sub6 = new String[ct1_results.length()];





            for (int i = 0; i < ct1_results.length(); i++) {

                JSONObject jo = ct1_results.getJSONObject(i);

                sub1[i] = jo.getString(KEY_SUB1);
                sub2[i] = jo.getString(KEY_SUB2);
                sub3[i] = jo.getString(KEY_SUB3);
                sub4[i] = jo.getString(KEY_SUB4);
                sub5[i] = jo.getString(KEY_SUB5);
                sub6[i] = jo.getString(KEY_SUB6);
                
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}

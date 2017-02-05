package com.example.harishsoni.finalproject2.StudentLogin;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by Harish on 02-Jul-16.
 */
public class BackgroundTasks extends AsyncTask<String, Void, String> {

    Context context;
    AlertDialog alertDialog;

    BackgroundTasks(Context context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Login Information");

    }

    @Override
    protected String doInBackground(String... params) {

        String login_url = "http://ssgiedrp.pe.hu/std_login.php";
        String stdID = params[0];
        String stdPass = params[1];


        try {
                URL url = new URL(login_url);
                HttpURLConnection http = (HttpURLConnection) url.openConnection();
                http.setRequestMethod("POST");
                http.setDoOutput(true);
                http.setDoInput(true);
                OutputStream OSt = http.getOutputStream();
                BufferedWriter buff = new BufferedWriter(new OutputStreamWriter(OSt, "UTF-8"));
                String data = URLEncoder.encode("login", "UTF-8") +"="+ URLEncoder.encode(stdID, "UTF-8")+"&"+
                        URLEncoder.encode("pass", "UTF-8") +"="+ URLEncoder.encode(stdPass, "UTF-8");

                buff.write(data);
                buff.flush();
                buff.close();
                OSt.close();

                InputStream inputStream = http.getInputStream();
                BufferedReader buffReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));

                String responseData = "";
                String line =  "";
                while ((line = buffReader.readLine())!=null)
                {
                    responseData+= line;
                }


                buffReader.close();
                inputStream.close();
                http.disconnect();


                return responseData;



            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String result) {
//        Toast.makeText(context,result, Toast.LENGTH_SHORT).show();
            String re = result;

            if (result.equals("LOGIN")) {

                Intent i = new Intent(context, StudentHomeActivity.class);
               context.startActivity(i);
            }

            else if (result.equals("Login Failed")) {

                //       alertDialog.setMessage(result);
                //     alertDialog.show();
                Toast.makeText(context, "Login Failed", Toast.LENGTH_SHORT).show();
            }
        }



    }

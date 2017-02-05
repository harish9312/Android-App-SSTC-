package com.example.harishsoni.finalproject2.StudentLogin;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.harishsoni.finalproject2.R;

/**
 * Created by Harish Soni on 07-Jul-16.
 */
public class LoginActivity extends Activity implements View.OnClickListener {
    EditText etStdID,etStdPass;
    TextView tvLogin,tvClear;
    String stdID,stdPass;
    Context context;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);


        sharedPreferences = getSharedPreferences("prefName",MODE_APPEND);
        editor = sharedPreferences.edit();

        etStdID = (EditText) findViewById(R.id.etStudentID);
        etStdPass = (EditText) findViewById(R.id.etPassword);

        tvLogin = (TextView) findViewById(R.id.tvStdLogin2);
        tvClear = (TextView) findViewById(R.id.tvClear);


        tvLogin.setOnClickListener(this);
        tvClear.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        stdID = etStdID.getText().toString();
        stdPass = etStdPass.getText().toString();

        editor.putString("stdID",stdID);
        editor.putString("stdPass",stdPass);
        editor.commit();


        switch (view.getId()){

            case R.id.tvStdLogin2:
                BackgroundTasks bs = new BackgroundTasks(this);
                bs.execute(stdID,stdPass);

            break;

            case R.id.tvClear:
                etStdID.getText().clear();
                etStdPass.getText().clear();
            break;
        }

    }
}

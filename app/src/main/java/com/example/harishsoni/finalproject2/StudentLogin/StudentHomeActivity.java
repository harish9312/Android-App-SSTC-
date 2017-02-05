package com.example.harishsoni.finalproject2.StudentLogin;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.harishsoni.finalproject2.CT1Results.CT1ResultsActivity;
import com.example.harishsoni.finalproject2.HomeActivity;
import com.example.harishsoni.finalproject2.MTResult.MTResultsActivity;
import com.example.harishsoni.finalproject2.R;

/**
 * Created by Harish Soni on 07-Jul-16.
 */
public class StudentHomeActivity extends Activity implements View.OnClickListener
{
    SharedPreferences sharedPreferences1;
    SharedPreferences.Editor editor1;
    String stdId,stdPass;
    String CT1="ct1",CT2="ct2",MT1="mt1",MT2="mt2";
    ImageView ivMt1Res,ivMT2Res,ivCT1Res,ivCT2Res,ivLogout;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_home_layout);

        sharedPreferences1 = getSharedPreferences("checkRes",MODE_APPEND);
        editor1 = sharedPreferences1.edit();
        ivMt1Res = (ImageView) findViewById(R.id.ivMT1Res);
        ivMT2Res = (ImageView) findViewById(R.id.ivMT2Res);
        ivCT1Res = (ImageView) findViewById(R.id.ivCT1Res);
        ivCT2Res = (ImageView) findViewById(R.id.ivCT2Res);
        ivLogout = (ImageView) findViewById(R.id.ivLogout);

        ivMt1Res.setOnClickListener(this);
        ivMT2Res.setOnClickListener(this);
        ivCT1Res.setOnClickListener(this);
        ivCT2Res.setOnClickListener(this);
        ivLogout.setOnClickListener(this);

    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.ivCT1Res:
                editor1.putInt("CT",1);
                editor1.commit();
                Intent i = new Intent(StudentHomeActivity.this, CT1ResultsActivity.class);
                startActivity(i);
                break;
            case R.id.ivMT1Res:
                editor1.putInt("MT",1);
                editor1.commit();
                i = new Intent(StudentHomeActivity.this, MTResultsActivity.class);
                startActivity(i);
                break;
            case R.id.ivCT2Res:
                editor1.putInt("CT",2);
                editor1.commit();
                i = new Intent(StudentHomeActivity.this,CT1ResultsActivity.class);
                startActivity(i);
                break;
            case R.id.ivMT2Res:
                editor1.putInt("MT",2);
                editor1.commit();
                i = new Intent(StudentHomeActivity.this, MTResultsActivity.class);
                startActivity(i);
                break;
            case R.id.ivLogout:
                i = new Intent(StudentHomeActivity.this, HomeActivity.class);
                startActivity(i);
                finish();
                break;

        }

    }
}

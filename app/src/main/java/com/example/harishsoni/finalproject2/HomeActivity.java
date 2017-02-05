//Class File For Home Activity View
package com.example.harishsoni.finalproject2;
//Importing Used Packages
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.harishsoni.finalproject2.News.NewsActivity;
import com.example.harishsoni.finalproject2.Notice.NoticeActivity;
import com.example.harishsoni.finalproject2.StudentLogin.LoginActivity;
import com.example.harishsoni.finalproject2.TNPNotice.TNPNoticeActivity;

/**
 * Created by Harish Soni on 07-Jul-16.
 */
public class HomeActivity extends Activity implements View.OnClickListener
{
//Declaring View Components
    TextView tvClgNotice, tvTNPNotice, tvResults, tvNews, tvStdLogin, ivStdLogin,tvDeve;
    ImageView ivClgNotice, ivTNPNotice, ivResults, ivNews;
//onCreate is the method which executes when the Activity is created
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//setContentLayout sets the View Layout for The Acticity
        setContentView(R.layout.home_layout);
        //method for Initializing the View Controllers
        intializeViewControls();

        //Apllying Events(onClickListener So That Can React on Click
        ivStdLogin.setOnClickListener(this);
        ivClgNotice.setOnClickListener(this);
        ivTNPNotice.setOnClickListener(this);
        ivNews.setOnClickListener(this);
        ivResults.setOnClickListener(this);
    }//onCreate Closed

    //Body of the initializeViewControl method
    private void intializeViewControls() {

        ivClgNotice = (ImageView) findViewById(R.id.ivNotice);
        ivTNPNotice = (ImageView) findViewById(R.id.ivTNPNotice);
        ivResults = (ImageView) findViewById(R.id.ivResults);
        ivNews = (ImageView) findViewById(R.id.ivNews);
        ivStdLogin = (TextView) findViewById(R.id.tvStdLogin1);

        tvDeve = (TextView) findViewById(R.id.tvDevH);
        tvClgNotice = (TextView) findViewById(R.id.tvClgNotice);
        tvTNPNotice = (TextView) findViewById(R.id.tvTNPNotice);
        tvResults = (TextView) findViewById(R.id.tvResults);
        tvNews = (TextView) findViewById(R.id.tvNews);
        tvStdLogin = (TextView) findViewById(R.id.tvStdLogin);

        //TypeFace is a class whihc is used to apply the Font Style For The TextView Components
        Typeface myType = Typeface.createFromAsset(getAssets(),"font/teen.ttf");
        Typeface myType1 = Typeface.createFromAsset(getAssets(),"font/FontleroyBrownNF.ttf");

        tvClgNotice.setTypeface(myType);
        tvTNPNotice.setTypeface(myType);
        tvResults.setTypeface(myType);
        tvNews.setTypeface(myType);
        tvStdLogin.setTypeface(myType);
        tvDeve.setTypeface(myType1);
    }

    @Override
    public void onClick(View view)
    {
        //Applying Intent To the Components
        Intent i;
        switch (view.getId())
        {

            case R.id.tvStdLogin1:
                i = new Intent(HomeActivity.this,LoginActivity.class);
                startActivity(i);
                break;
            case R.id.ivNotice:
                 i = new Intent(HomeActivity.this, NoticeActivity.class);
                startActivity(i);
                break;
            case R.id.ivTNPNotice:
                i = new Intent(HomeActivity.this, TNPNoticeActivity.class);
                startActivity(i);
                break;
            case R.id.ivNews:
                i = new Intent(HomeActivity.this, NewsActivity.class);
                startActivity(i);
                break;
            case R.id.ivResults:
                Intent searchIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://chhattisgarh.indiaresults.com/csvtu/default.aspx"));
                startActivity(searchIntent);
                break;
        }//switch Closed
    }//onClick Closed
}//Class Closed


package com.example.harishsoni.finalproject2.News;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.harishsoni.finalproject2.R;

/**
 * Created by Belal on 9/22/2015.
 */

public class CustomListForNews extends ArrayAdapter<String> {
    private String[] news_title;
    private String[] news_body;
    private Activity context;

    public CustomListForNews(Activity context, String[] news_title, String[] news_body) {
        super(context, R.layout.news_list, news_title);
        this.context = context;
        this.news_title = news_title;
        this.news_body=news_body;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.news_list, null, true);
        TextView tvNewsTitle = (TextView) listViewItem.findViewById(R.id.tvNewsTitl1e);
        TextView tvNewsBody = (TextView) listViewItem.findViewById(R.id.tvNewsBody);
            
        tvNewsTitle.setText(news_title[position]);
        tvNewsBody.setText(news_body[position]);
        return listViewItem;
    }
}
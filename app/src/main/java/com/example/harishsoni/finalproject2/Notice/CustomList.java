package com.example.harishsoni.finalproject2.Notice;

import android.app.Activity;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.harishsoni.finalproject2.R;

/**
 * Created by Belal on 9/22/2015.
 */

public class CustomList extends ArrayAdapter<String> {
    private String[] notice_title;
    private String[] notice_body;
    private String[] notice_by;
    private String[] notice_date;
    private Activity context;

    public CustomList(Activity context, String[] notice_title, String[] notice_body, String[] notice_by, String[] notice_date) {
        super(context, R.layout.list_notice, notice_title);
        this.context = context;
        this.notice_title = notice_title;
        this.notice_body=notice_body;
        this.notice_by = notice_by;
        this.notice_date = notice_date;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.list_notice, null, true);
        TextView tvTitle = (TextView) listViewItem.findViewById(R.id.tvTitl1e);
        TextView tvNoticeBody = (TextView) listViewItem.findViewById(R.id.tvNoticeBody);
        TextView tvNoticeBy = (TextView) listViewItem.findViewById(R.id.tvNoticeBy);
        TextView tvNoticeDate = (TextView) listViewItem.findViewById(R.id.tvNoticeDate);

        Typeface myType = Typeface.createFromAsset(context.getAssets(),"font/teen.ttf");

        tvTitle.setTypeface(myType);
        tvNoticeBody.setTypeface(myType);
        tvNoticeBy.setTypeface(myType);
        tvNoticeDate.setTypeface(myType);

        tvTitle.setText(notice_title[position]);
        tvNoticeBody.setText(notice_body[position]);
        tvNoticeBy.setText("By:"+notice_by[position]);
        tvNoticeDate.setText("Date:"+notice_date[position]);
        return listViewItem;
    }
}
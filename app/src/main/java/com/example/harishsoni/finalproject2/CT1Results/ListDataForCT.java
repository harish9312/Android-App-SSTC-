package com.example.harishsoni.finalproject2.CT1Results;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.harishsoni.finalproject2.R;

/**
 * Created by Harish Soni on 08-Jul-16.
 */
public class ListDataForCT extends ArrayAdapter<String> {
    
    private String[] sub1;
    private String[] sub2;
    private String[] sub3;
    private String[] sub4;
    private String[] sub5;
    private String[] sub6;

    private Activity context;

    public ListDataForCT(Context context, String[] sub1, String[] sub2, String[] sub3, String[] sub4, String[] sub5, String[] sub6) {
        super(context, R.layout.test_result_list,sub1);
                this.context = (Activity) context;
                this.sub1 = sub1;
                this.sub2 = sub2;
                this.sub3 = sub3;
                this.sub4 = sub4;
                this.sub5 = sub5;
                this.sub6 = sub6;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

LayoutInflater layoutInflater =   context.getLayoutInflater();
        View listItem = layoutInflater.inflate(R.layout.test_result_list,null,true);
        TextView tvSub1 = (TextView) listItem.findViewById(R.id.tvSub1);
        TextView tvSub2 = (TextView) listItem.findViewById(R.id.tvSub2);
        TextView tvSub3 = (TextView) listItem.findViewById(R.id.tvSub3);
        TextView tvSub4 = (TextView) listItem.findViewById(R.id.tvSub4);
        TextView tvSub5 = (TextView) listItem.findViewById(R.id.tvSub5);
        TextView tvSub6 = (TextView) listItem.findViewById(R.id.tvSub6);

        tvSub1.setText(sub1[position]);
        tvSub2.setText(sub2[position]);
        tvSub3.setText(sub3[position]);
        tvSub4.setText(sub4[position]);
        tvSub5.setText(sub5[position]);
        tvSub6.setText(sub6[position]);
        return listItem;
    }

}

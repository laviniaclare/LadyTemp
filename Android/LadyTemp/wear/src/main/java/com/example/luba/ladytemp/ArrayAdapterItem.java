package com.example.luba.ladytemp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by luba on 9/28/14.
 */
public class ArrayAdapterItem extends ArrayAdapter<ListItem> {

    Context mContext;
    int layoutResourceId;
    ListItem data[] = null;

    public ArrayAdapterItem(Context mContext, int layoutResourceId, ListItem[] data) {
        super(mContext, layoutResourceId, data);

        this.layoutResourceId = layoutResourceId;
        this.mContext = mContext;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView==null){
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            convertView = inflater.inflate(layoutResourceId, parent, false);
        }

        ListItem listItem = data[position];
        TextView textViewItem = (TextView) convertView.findViewById(R.id.notification);
        textViewItem.setText(listItem.itemName);
        return convertView;
    }
}




package com.gugu.wegolsu.k_seastem.ListDO;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.gugu.wegolsu.k_seastem.R;

import java.util.ArrayList;

public class CallListAdapter extends BaseAdapter {
    ArrayList<CallDO> callDO = new ArrayList<CallDO>();

    public void addItem(String name, String tel) {
        CallDO localCallDO = new CallDO();
        localCallDO.setName(name);
        localCallDO.setNum(tel);
        this.callDO.add(localCallDO);
    }

    public int getCount() {
        return callDO.size();
    }

    public Object getItem(int i) {
        return callDO.get(i);
    }

    public long getItemId(int i) {
        return i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        Context context = viewGroup.getContext();

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.call, viewGroup, false);
        }
        CallDO temp = callDO.get(i);

        TextView tvCallName = (TextView) view.findViewById(R.id.tvCallName);
        TextView tvCall = (TextView) view.findViewById(R.id.tvCall);
        tvCallName.setText(temp.getName());
        tvCall.setText(temp.getNum());

        return view;
    }
}
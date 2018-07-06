package com.gugu.wegolsu.k_seastem.ListDO;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.gugu.wegolsu.k_seastem.R;

import java.util.ArrayList;

public class CatchListAdapter extends BaseAdapter {
    private ArrayList<CatchDO> catchDO = new ArrayList();

    public void addItem(String name, String end) {
        CatchDO temp = new CatchDO("이름없음", "없음", "없음");
        temp.setStrName(name);
        temp.setStrEnd(end);
        catchDO.add(temp);
    }

    public int getCount() {
        return catchDO.size();
    }

    public Object getItem(int i) {
        return catchDO.get(i);
    }

    public long getItemId(int i) {
        return i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        Context context = viewGroup.getContext();

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.catch_ban, viewGroup, false);
        }
        TextView tvName = (TextView) view.findViewById(R.id.tvName);
        ProgressBar pbUntilDate = (ProgressBar) view.findViewById(R.id.pbUntilDate);
        TextView tvUntilDate = (TextView) view.findViewById(R.id.tvUntilDate);

        CatchDO temp = catchDO.get(i);

        String str = temp.getStrEnd();
        int iEnd = Integer.parseInt(str);

        if (iEnd <= 10) {
            pbUntilDate.getIndeterminateDrawable().setColorFilter(Color.parseColor("#55b151"), PorterDuff.Mode.SRC_ATOP);
        } else if (iEnd <= 20) {
            pbUntilDate.getIndeterminateDrawable().setColorFilter(Color.parseColor("#eec45e"), PorterDuff.Mode.SRC_ATOP);
        } else if (iEnd <= 30) {
            pbUntilDate.getIndeterminateDrawable().setColorFilter(Color.parseColor("#e24242"), PorterDuff.Mode.SRC_ATOP);
        } else {
            pbUntilDate.getIndeterminateDrawable().setColorFilter(Color.parseColor("#8b8b8b"), PorterDuff.Mode.SRC_ATOP);
        }

        tvName.setText(temp.getStrName());
        tvUntilDate.setText(temp.getStrEnd() + "일");

        return view;
    }
}
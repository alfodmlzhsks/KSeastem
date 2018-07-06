package com.gugu.wegolsu.k_seastem.fragment;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import com.gugu.wegolsu.k_seastem.R;
import com.gugu.wegolsu.k_seastem.databinding.FragmentTotalBinding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GeneralFragment extends Fragment {
    FragmentTotalBinding binding = null;
    Context context = null;
    String[] result = null;
    int year;

    private void price() {
        binding.tvTotalLive1.setText(result[12]);
        binding.tvTotalDead1.setText(result[13]);
        binding.tvTotalIce1.setText(result[14]);
        binding.tvTotal1.setText(result[15]);
        binding.tvTotalLive2.setText(result[16]);
        binding.tvTotalDead2.setText(result[17]);
        binding.tvTotalIce2.setText(result[18]);
        binding.tvTotal2.setText(result[19]);
        binding.tvTotalLive3.setText(result[20]);
        binding.tvTotalDead3.setText(result[21]);
        binding.tvTotalIce3.setText(result[22]);
        binding.tvTotal3.setText(result[23]);
        long l1 = Long.parseLong(result[23].replace(",", ""));
        long l2 = (Long.parseLong(result[15].replace(",", "")) + Long.parseLong(result[19].replace(",", "")) + l1) / 3L;
        binding.tvTotalAvg.setText("평균: " + new DecimalFormat("###,###,###,###").format(l2) + "(천원)");
        if (l1 < l2) {
            binding.tvTotalDiff.setText(year - 1 + "년도는 평균보다 낮습니다..");
            return;
        }
        binding.tvTotalDiff.setText(year - 1 + "년도는 평균보다 높습니다!!");
    }

    private void quantity() {
        binding.tvTotalLive1.setText(result[0]);
        binding.tvTotalDead1.setText(result[1]);
        binding.tvTotalIce1.setText(result[2]);
        binding.tvTotal1.setText(result[3]);
        binding.tvTotalLive2.setText(result[4]);
        binding.tvTotalDead2.setText(result[5]);
        binding.tvTotalIce2.setText(result[6]);
        binding.tvTotal2.setText(result[7]);
        binding.tvTotalLive3.setText(result[8]);
        binding.tvTotalDead3.setText(result[9]);
        binding.tvTotalIce3.setText(result[10]);
        binding.tvTotal3.setText(result[11]);
        int i = Integer.parseInt(result[11].replace(",", ""));
        int j = (Integer.parseInt(result[3].replace(",", "")) + Integer.parseInt(result[7].replace(",", "")) + i) / 3;
        binding.tvTotalAvg.setText("평균: " + new DecimalFormat("###,###,###,###").format(j) + "톤");
        if (i < j) {
            binding.tvTotalDiff.setText(year - 1 + "년도는 평균보다 낮습니다..");
            return;
        }
        binding.tvTotalDiff.setText(year - 1 + "년도는 평균보다 높습니다!!");
    }

    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle paramBundle) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_total, container, false);
        context = container.getContext();

        Date date = new Date();

        year = Integer.parseInt(new SimpleDateFormat("yyyy").format(date));

        binding.tvTotalYear1.setText("" + (year - 3));
        binding.tvTotalYear2.setText("" + (year - 2));
        binding.tvTotalYear3.setText("" + (year - 1));

        binding.toggleTotal.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (binding.toggleTotal.isChecked()) {
                    price();
                    return;
                }
                quantity();
            }
        });
        return binding.getRoot();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        if(isVisibleToUser) {
            new TotalAsync().execute("");
        }
    }

    public class TotalAsync extends AsyncTask<String, String, String> {

        BufferedReader bis = null;
        HttpURLConnection conn = null;
        String data = "";
        URL url = null;

        public String connect() {
            String line = "";

            try {
                conn.connect();

                InputStream is = conn.getInputStream();
                bis = new BufferedReader(new InputStreamReader(is));

                while((line=bis.readLine())!=null) {
                    data+=line;
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if(bis!=null) {
                    try {
                        bis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return data;
        }

        public TotalAsync() {
            super();
        }

        @Override
        protected String doInBackground(String... strings) {
            try {
                url = new URL("http://giruk.iptime.org/K-Seastem/total/totalReq.jsp?key=general");
                conn = ((HttpURLConnection) url.openConnection());
                result = connect().split("/");

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch(IOException e) {
                e.printStackTrace();
            }

            return "good";
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            quantity();


        }
    }
}

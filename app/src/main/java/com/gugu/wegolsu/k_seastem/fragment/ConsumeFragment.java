package com.gugu.wegolsu.k_seastem.fragment;

import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gugu.wegolsu.k_seastem.R;
import com.gugu.wegolsu.k_seastem.databinding.FragmentConsumeBinding;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConsumeFragment extends Fragment {
    FragmentConsumeBinding binding = null;
    Bitmap bmImg;
    String imgUrl = "http://giruk.iptime.org/K-Seastem/images/consume.png";

    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle paramBundle) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_consume, container, false);
        new ConsumeAsync().execute(imgUrl);
        return binding.getRoot();
    }

    private class ConsumeAsync extends AsyncTask<String, String, Bitmap> {

        HttpURLConnection conn = null;

        public ConsumeAsync() {
        }

        protected Bitmap doInBackground(String... strings) {
            try {
                conn = (HttpURLConnection) new URL(strings[0]).openConnection();
                conn.setDoInput(true);
                conn.connect();
                InputStream is = conn.getInputStream();
                bmImg = BitmapFactory.decodeStream(is);
                return bmImg;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        protected void onPostExecute(Bitmap paramBitmap) {
            binding.ivShowConsume.setImageBitmap(paramBitmap);
        }

        protected void onPreExecute() {
            super.onPreExecute();
        }

        protected void onProgressUpdate(String... strings) {
            super.onProgressUpdate(strings);
        }
    }
}

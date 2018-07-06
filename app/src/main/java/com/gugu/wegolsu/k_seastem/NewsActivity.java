package com.gugu.wegolsu.k_seastem;

import android.databinding.DataBindingUtil;
import android.net.http.SslError;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.gugu.wegolsu.k_seastem.databinding.ActivityNewsBinding;

public class NewsActivity extends AppCompatActivity {

    ActivityNewsBinding binding = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_news);
        binding.setNews(this);

        binding.newsWeb.getSettings().setJavaScriptEnabled(true);
        binding.newsWeb.getSettings().setBuiltInZoomControls(true);
        binding.newsWeb.getSettings().setSupportZoom(true);
        binding.newsWeb.loadUrl("http://giruk.iptime.org/K-Seastem/index.html");
        binding.newsWeb.setWebChromeClient(new WebChromeClient());
        binding.newsWeb.setWebViewClient(new WebViewClientClass());
    }

    private class WebViewClientClass extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            Log.d("check URL",url);
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            handler.proceed();
        }
    }
}

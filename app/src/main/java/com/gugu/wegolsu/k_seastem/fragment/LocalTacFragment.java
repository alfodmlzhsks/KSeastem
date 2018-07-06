package com.gugu.wegolsu.k_seastem.fragment;

import android.databinding.DataBindingUtil;
import android.net.http.SslError;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.gugu.wegolsu.k_seastem.R;
import com.gugu.wegolsu.k_seastem.databinding.FragmentLocaltacBinding;

public class LocalTacFragment extends Fragment {
    FragmentLocaltacBinding binding = null;

    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle paramBundle) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_localtac, container, false);
        binding.localWeb.getSettings().setJavaScriptEnabled(true);
        binding.localWeb.getSettings().setBuiltInZoomControls(true);
        binding.localWeb.getSettings().setSupportZoom(true);
        binding.localWeb.getSettings().setUseWideViewPort(true);
        binding.localWeb.setInitialScale(4);
        binding.localWeb.loadUrl("http://giruk.iptime.org/K-Seastem/tac/local.html");
        binding.localWeb.setWebChromeClient(new WebChromeClient());
        binding.localWeb.setWebViewClient(new WebViewClientClass());

        return binding.getRoot();
    }

    private class WebViewClientClass extends WebViewClient {

        private WebViewClientClass() {
        }

        public void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError) {
            paramSslErrorHandler.proceed();
        }

        public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString) {
            Log.d("check URL", paramString);
            paramWebView.loadUrl(paramString);
            return true;
        }
    }
}

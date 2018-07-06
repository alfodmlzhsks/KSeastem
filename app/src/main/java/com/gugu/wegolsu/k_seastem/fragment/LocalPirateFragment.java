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
import com.gugu.wegolsu.k_seastem.databinding.FragmentLocalPirateBinding;

public class LocalPirateFragment extends Fragment {
    FragmentLocalPirateBinding binding = null;

    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle paramBundle) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_local_pirate, container, false);
        binding.localPirateWeb.getSettings().setJavaScriptEnabled(true);
        binding.localPirateWeb.getSettings().setBuiltInZoomControls(true);
        binding.localPirateWeb.getSettings().setSupportZoom(true);
        binding.localPirateWeb.getSettings().setUseWideViewPort(true);
        binding.localPirateWeb.setInitialScale(4);
        binding.localPirateWeb.loadUrl("http://giruk.iptime.org/K-Seastem/pirate/pirate.html");
        binding.localPirateWeb.setWebChromeClient(new WebChromeClient());
        binding.localPirateWeb.setWebViewClient(new WebViewClientClass());

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

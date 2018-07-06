package com.gugu.wegolsu.k_seastem.fragment;

import android.content.Context;
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
import com.gugu.wegolsu.k_seastem.databinding.FragmentEezWebBinding;

public class EEZWebViewFragment extends Fragment {

    FragmentEezWebBinding binding = null;
    Context context = null;
    String key = null;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        key = getArguments().getString("key");
    }

    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle paramBundle) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_eez_web, container, false);

        context = container.getContext();

        binding.eezWeb.getSettings().setJavaScriptEnabled(true);
        binding.eezWeb.getSettings().setBuiltInZoomControls(true);
        binding.eezWeb.getSettings().setSupportZoom(true);
        binding.eezWeb.getSettings().setUseWideViewPort(true);
        binding.eezWeb.setInitialScale(4);
        if (key.equals("foreign")) {
            binding.eezWeb.loadUrl("http://giruk.iptime.org/K-Seastem/eez/korea.html");
        } else {
            binding.eezWeb.loadUrl("http://giruk.iptime.org/K-Seastem/eez/world.html");
        }
        binding.eezWeb.setWebChromeClient(new WebChromeClient());
        binding.eezWeb.setWebViewClient(new WebViewClientClass());

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
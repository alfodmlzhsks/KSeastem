package com.gugu.wegolsu.k_seastem.fragment;

import android.databinding.DataBindingUtil;
import android.net.http.SslError;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.gugu.wegolsu.k_seastem.R;
import com.gugu.wegolsu.k_seastem.databinding.FragmentAttackPirateBinding;

public class AttackPirateFragment extends Fragment {

    FragmentAttackPirateBinding binding = null;

    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle paramBundle) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_attack_pirate, container, false);
        binding.attackPirateWeb.getSettings().setJavaScriptEnabled(true);
        binding.attackPirateWeb.getSettings().setBuiltInZoomControls(true);
        binding.attackPirateWeb.getSettings().setSupportZoom(true);
        binding.attackPirateWeb.getSettings().setUseWideViewPort(true);
        binding.attackPirateWeb.setInitialScale(4);
        binding.attackPirateWeb.loadUrl("http://giruk.iptime.org/K-Seastem/pirate/pirate1.html");
        binding.attackPirateWeb.setWebChromeClient(new WebChromeClient());
        binding.attackPirateWeb.setWebViewClient(new WebViewClientClass());
        return binding.getRoot();
    }

    private class WebViewClientClass extends WebViewClient {
        private WebViewClientClass() {

        }

        @Override
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            handler.proceed();
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}

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
import com.gugu.wegolsu.k_seastem.databinding.FragmentMovePirateBinding;

public class MovePirateFragment extends Fragment {
    FragmentMovePirateBinding binding = null;

    @Nullable
    public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle) {
        this.binding = DataBindingUtil.inflate(paramLayoutInflater, R.layout.fragment_move_pirate, paramViewGroup, false);
        this.binding.movePirateWeb.getSettings().setJavaScriptEnabled(true);
        this.binding.movePirateWeb.getSettings().setBuiltInZoomControls(true);
        this.binding.movePirateWeb.getSettings().setSupportZoom(true);
        this.binding.movePirateWeb.loadUrl("http://giruk.iptime.org/K-Seastem/pirate/pirate2.html");
        this.binding.movePirateWeb.setWebChromeClient(new WebChromeClient());
        this.binding.movePirateWeb.setWebViewClient(new WebViewClientClass());
        return this.binding.getRoot();
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


/* Location:              C:\Users\gugu\Downloads\dex2jar-2.0\dex2jar-2.0\kseastem-dex2jar.jar!\com\gugu\wegolsu\k_seastem\fragment\MovePirateFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
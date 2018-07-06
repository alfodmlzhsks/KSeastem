package com.gugu.wegolsu.k_seastem.fragment;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import com.gugu.wegolsu.k_seastem.R;
import com.gugu.wegolsu.k_seastem.databinding.FragmentEezSelect1Binding;

public class EEZRightMenuFragment extends Fragment {
    FragmentEezSelect1Binding binding = null;
    Context context = null;

    public void allInVisible() {
        binding.imbEEZMenuLeft1.setVisibility(View.INVISIBLE);
        binding.imbEEZMenuRight1.setVisibility(View.INVISIBLE);
    }

    public void allVisible() {
        binding.imbEEZMenuLeft1.setVisibility(View.VISIBLE);
        binding.imbEEZMenuRight1.setVisibility(View.VISIBLE);
    }

    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle paramBundle) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_eez_select1, container, false);
        context = container.getContext();
        binding.imbEEZMenuLeft1.setOnClickListener(new OnClickListener() {

            public void onClick(View paramAnonymousView) {
                allInVisible();
                EEZPictureFragment1 picture = new EEZPictureFragment1();
                Bundle localBundle = new Bundle();
                localBundle.putString("key", "korea");
                picture.setArguments(localBundle);
                getFragmentManager().beginTransaction().replace(R.id.constSelect1, picture).commit();
            }
        });
        binding.imbEEZMenuRight1.setOnClickListener(new OnClickListener() {

            public void onClick(View paramAnonymousView) {
                allInVisible();
                EEZWebViewFragment webView = new EEZWebViewFragment();
                Bundle localBundle = new Bundle();
                localBundle.putString("key", "korea");
                webView.setArguments(localBundle);
                getFragmentManager().beginTransaction().replace(R.id.constSelect1, webView).commit();
            }
        });
        return binding.getRoot();
    }
}

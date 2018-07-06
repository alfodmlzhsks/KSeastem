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
import com.gugu.wegolsu.k_seastem.databinding.FragmentEezSelectBinding;

public class EEZLeftMenuFragment extends Fragment {
    FragmentEezSelectBinding binding = null;
    Context context = null;

    public void allInVisible() {
        binding.imbEEZMenuLeft.setVisibility(View.INVISIBLE);
        binding.imbEEZMenuRight.setVisibility(View.INVISIBLE);
    }

    public void allVisible() {
        binding.imbEEZMenuLeft.setVisibility(View.VISIBLE);
        binding.imbEEZMenuRight.setVisibility(View.VISIBLE);
    }

    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle paramBundle) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_eez_select, container, false);
        context = container.getContext();

        binding.imbEEZMenuLeft.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                allInVisible();
                EEZPictureFragment picture = new EEZPictureFragment();
                Bundle localBundle = new Bundle();
                localBundle.putString("key", "foreign");
                picture.setArguments(localBundle);
                getFragmentManager().beginTransaction().replace(R.id.constSelect, picture).commit();
            }
        });

        binding.imbEEZMenuRight.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                allInVisible();
                EEZWebViewFragment webview = new EEZWebViewFragment();
                Bundle localBundle = new Bundle();
                localBundle.putString("key", "foreign");
                webview.setArguments(localBundle);
                getFragmentManager().beginTransaction().replace(R.id.constSelect, webview).commit();
            }
        });
        return binding.getRoot();
    }
}

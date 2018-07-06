package com.gugu.wegolsu.k_seastem;

import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.content.pm.ActivityInfo;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.app.AppCompatActivity;

import com.gugu.wegolsu.k_seastem.databinding.ActivityEezBinding;
import com.gugu.wegolsu.k_seastem.fragment.EEZLeftMenuFragment;
import com.gugu.wegolsu.k_seastem.fragment.EEZRightMenuFragment;

public class EEZActivity extends AppCompatActivity {

    ActivityEezBinding binding = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_eez);
        binding.setEezactivity(this);

        binding.eezPager.setAdapter(new PagerAdapter(getSupportFragmentManager()));
        binding.eezPager.setCurrentItem(0);
        binding.tab3.setupWithViewPager(binding.eezPager);
    }

    private class PagerAdapter extends FragmentStatePagerAdapter {

        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public int getCount() {
            return 2;
        }

        public Fragment getItem(int i) {
            switch (i) {
                case 0:
                    return new EEZLeftMenuFragment();
                case 1:
                    return new EEZRightMenuFragment();
                default:
                    return null;
            }

        }

        public CharSequence getPageTitle(int i) {
            switch (i) {
                case 0:
                    return "외국 -> 우리나라";
                case 1:
                    return "우리나라 -> 외국";
                default:
                    return "error";
            }
        }
    }
}

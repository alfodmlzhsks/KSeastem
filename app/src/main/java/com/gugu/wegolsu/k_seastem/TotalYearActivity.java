package com.gugu.wegolsu.k_seastem;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.app.AppCompatActivity;

import com.gugu.wegolsu.k_seastem.databinding.ActivityTotalYearBinding;
import com.gugu.wegolsu.k_seastem.fragment.CheonFragment;
import com.gugu.wegolsu.k_seastem.fragment.GeneralFragment;
import com.gugu.wegolsu.k_seastem.fragment.NesuFragment;
import com.gugu.wegolsu.k_seastem.fragment.TotalFragment;

public class TotalYearActivity extends AppCompatActivity {

    ActivityTotalYearBinding binding = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_total_year);
        binding.setTotalactivity(this);

        binding.totalPager.setAdapter(new PagerAdapter(getSupportFragmentManager()));
        binding.totalPager.setCurrentItem(0);
        binding.tabTotal.setupWithViewPager(binding.totalPager);
    }

    private class PagerAdapter extends FragmentStatePagerAdapter {

        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public int getCount() {
            return 4;
        }

        public Fragment getItem(int paramInt) {
            switch (paramInt) {
                case 0:
                    return new GeneralFragment();
                case 1:
                    return new CheonFragment();
                case 2:
                    return new NesuFragment();
                case 3:
                    return new TotalFragment();
                default:
                    return null;
            }
        }

        public CharSequence getPageTitle(int paramInt) {
            switch (paramInt) {
                case 0:
                    return "일반해면";
                case 1:
                    return "천해양식";
                case 2:
                    return "내수면";
                case 3:
                    return "합계";
                default:
                    return "error";
            }
        }
    }
}
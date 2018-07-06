package com.gugu.wegolsu.k_seastem;

import android.content.pm.ActivityInfo;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.app.AppCompatActivity;

import com.gugu.wegolsu.k_seastem.databinding.ActivityTacBinding;
import com.gugu.wegolsu.k_seastem.fragment.ConsumeFragment;
import com.gugu.wegolsu.k_seastem.fragment.LocalTacFragment;
import com.gugu.wegolsu.k_seastem.fragment.ZosaFragment;

public class TACActivity extends AppCompatActivity {

    ActivityTacBinding binding = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        // 화면을 landscape(가로) 화면으로 고정하고 싶은 경우

        binding = DataBindingUtil.setContentView(this, R.layout.activity_tac);
        binding.setTac(this);
        binding.tacPager.setAdapter(new PagerAdapter(getSupportFragmentManager()));
        binding.tacPager.setCurrentItem(0);
        binding.tab1.setupWithViewPager(binding.tacPager);
    }

    private class PagerAdapter extends FragmentStatePagerAdapter {

        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new LocalTacFragment(); //그냥 처음에 생성된채로 있는거임
                case 1:
                    return new ConsumeFragment(); //그냥 처음에 생성된채로 있는거임
                case 2:
                    return new ZosaFragment();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch(position) {
                case 0:
                    return "지역별\nTAC";
                case 1:
                    return "어종별\n소진량";
                case 2:
                    return "조사원\n배치현황";
                default:
                    return "Error";
            }
        }
    }
}

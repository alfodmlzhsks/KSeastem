package com.gugu.wegolsu.k_seastem;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.app.AppCompatActivity;

import com.gugu.wegolsu.k_seastem.databinding.ActivityPirateBinding;
import com.gugu.wegolsu.k_seastem.fragment.AttackPirateFragment;
import com.gugu.wegolsu.k_seastem.fragment.LocalPirateFragment;
import com.gugu.wegolsu.k_seastem.fragment.MovePirateFragment;

public class PirateActivity extends AppCompatActivity {
    ActivityPirateBinding binding = null;
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_pirate);
        binding.setPirate(this);

        binding.piratePager.setAdapter(new PagerAdapter(getSupportFragmentManager()));
        binding.piratePager.setCurrentItem(0);
        binding.tab2.setupWithViewPager(binding.piratePager);

    }

    private class PagerAdapter extends FragmentStatePagerAdapter {

        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public int getCount() {
            return 3;
        }

        public Fragment getItem(int paramInt) {
            switch (paramInt) {
                default:
                    return null;
                case 0:
                    return new LocalPirateFragment();
                case 1:
                    return new AttackPirateFragment();
                case 2:
                    return new MovePirateFragment();
            }

        }

        public CharSequence getPageTitle(int i) {
            switch (i) {
                case 0:
                    return "지역별 현황";
                case 1:
                    return "공격종류별 현황";
                case 2:
                    return "해적동향";
                default:
                    return "Error";
            }
        }
    }
}

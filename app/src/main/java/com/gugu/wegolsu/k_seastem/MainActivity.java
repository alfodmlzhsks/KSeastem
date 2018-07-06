package com.gugu.wegolsu.k_seastem;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.gugu.wegolsu.k_seastem.ListDO.CatchDO;
import com.gugu.wegolsu.k_seastem.databinding.ActivityMainBinding;
import com.gugu.wegolsu.k_seastem.fragment.FirstMenuFragment;
import com.gugu.wegolsu.k_seastem.fragment.SecondMenuFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    static public ActivityMainBinding binding = null;
    static ArrayList<CatchDO> catchData = null;
    static public String strFlag = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        // 화면을 landscape(세로) 화면으로 고정하고 싶은 경우

        catchData = new ArrayList<CatchDO>();

        new Thread(new Runnable() {
            @Override
            public void run() {
                catchData.add(new CatchDO("개서개", "0701", "0831"));
                catchData.add(new CatchDO("대구", "0301", "0331"));   //부산광역시, 경상남도는 0101~0131까지
                catchData.add(new CatchDO("문치가자미", "1201", "0131"));
                catchData.add(new CatchDO("연어", "1001", "1130"));
                catchData.add(new CatchDO("전어", "0501", "0715"));
                catchData.add(new CatchDO("쥐노래미", "1101", "1231"));
                catchData.add(new CatchDO("참홍어", "0601", "0715")); //주3의 해역에서는 예외있음 (링크로 표시하기 잠깐사진표시)예외들은
                catchData.add(new CatchDO("참조기", "0701", "0731"));  //예외
                catchData.add(new CatchDO("갈치", "0701", "0731")); //예외
                catchData.add(new CatchDO("고등어", "0401", "0630")); //예외
                catchData.add(new CatchDO("말쥐치", "0501", "0731")); //dPdhl
                catchData.add(new CatchDO("옥돔", "0721", "0820"));
                catchData.add(new CatchDO("미거지", "0801", "0831")); //강원도한정
                catchData.add(new CatchDO("꽃게", "0601", "0930")); //dPdhl
                catchData.add(new CatchDO("대게류", "0601", "1130")); //예외
                catchData.add(new CatchDO("붉은대게", "0710", "0825")); //예외
                catchData.add(new CatchDO("털게", "0401", "0531")); //강원도한정
                catchData.add(new CatchDO("닭새우", "0701", "0831"));
                catchData.add(new CatchDO("대하", "0501", "0630"));
                catchData.add(new CatchDO("펄닭새우", "0601", "0831"));
                catchData.add(new CatchDO("백합", "0701", "0820"));
                catchData.add(new CatchDO("새조개", "0616", "0930"));
                catchData.add(new CatchDO("소라", "0601", "0831")); //경우의수가 많은것들은 그냥 다설명
                catchData.add(new CatchDO("전복류", "0901", "1031"));
                catchData.add(new CatchDO("코끼리조개", "0401", "0731"));
                catchData.add(new CatchDO("키조개", "0701", "0831"));
                catchData.add(new CatchDO("가리비", "0301", "0630"));
                catchData.add(new CatchDO("오분자기", "0701", "0831"));
                catchData.add(new CatchDO("개다시마", "1101", "0131"));
                catchData.add(new CatchDO("감태", "0501", "0731"));
                catchData.add(new CatchDO("곰피", "0501", "0731"));
                catchData.add(new CatchDO("넓미역", "0901", "1130"));
                catchData.add(new CatchDO("대황", "0501", "0731"));
                catchData.add(new CatchDO("도박류", "1001", "0430"));
                catchData.add(new CatchDO("뜸부기", "0801", "0930"));
                catchData.add(new CatchDO("우뭇가사리", "1101", "0430"));
                catchData.add(new CatchDO("톳", "1001", "0131"));
                catchData.add(new CatchDO("해삼", "0701", "0731"));
                catchData.add(new CatchDO("살오징어", "0401", "0531"));
                catchData.add(new CatchDO("낙지", "0601", "0630"));
                catchData.add(new CatchDO("쭈꾸미", "0511", "0831"));
            }
        }).start();

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setActivity(this);

        binding.imbDetail.setVisibility(View.GONE);
        binding.menuPager.setAdapter(new PagerAdapter(getSupportFragmentManager()));
        binding.menuPager.setCurrentItem(0);
        binding.menuPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            //뷰페이지 변경완료시
            @Override
            public void onPageSelected(int position) {
                switch(position) {
                    case 0:
                        binding.ivChange.setImageResource(R.drawable.viewpager_1);
                        break;
                    case 1:
                        binding.ivChange.setImageResource(R.drawable.viewpager_2);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        binding.imbDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(strFlag) {
                    case "catch":
                        Intent ban = new Intent(getApplicationContext(), CatchBanActivity.class);
                        startActivity(ban);
                        break;
                    case "eez":
                        Intent eez = new Intent(getApplicationContext(), EEZActivity.class);
                        startActivity(eez);
                        break;
                    case "tac":
                        Intent tac = new Intent(getApplicationContext(), TACActivity.class);
                        startActivity(tac);
                        break;
                    case "global":
                        Intent global = new Intent(getApplicationContext(), GlobalFishActivity.class);
                        startActivity(global);
                        break;
                    case "total":
                        Intent total = new Intent(getApplicationContext(), TotalYearActivity.class);
                        startActivity(total);
                        break;
                    case "pirate":
                        Intent pirate = new Intent(getApplicationContext(), PirateActivity.class);
                        startActivity(pirate);
                        break;
                    case "news":
                        Intent news = new Intent(getApplicationContext(), NewsActivity.class);
                        startActivity(news);
                        break;
                    case "call":
                        Intent call = new Intent(getApplicationContext(), CallActivity.class);
                        startActivity(call);
                        break;
                    default:
                        break;
                }
            }
        });
    }

    private class PagerAdapter extends FragmentStatePagerAdapter {

        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch(position) {
                case 0:
                    return new FirstMenuFragment(); //그냥 처음에 생성된채로 있는거임
                case 1:
                    return new SecondMenuFragment(); //그냥 처음에 생성된채로 있는거임
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 2;
        }
    }
}

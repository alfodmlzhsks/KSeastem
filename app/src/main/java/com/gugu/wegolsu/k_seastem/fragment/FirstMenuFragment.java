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

import com.gugu.wegolsu.k_seastem.MainActivity;
import com.gugu.wegolsu.k_seastem.R;
import com.gugu.wegolsu.k_seastem.databinding.FragmentFirstMenuBinding;

public class FirstMenuFragment extends Fragment implements OnClickListener {
    Context context = null;
    FragmentFirstMenuBinding ffmb = null;

    public FirstMenuFragment() {
        super();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ffmb = DataBindingUtil.inflate(inflater, R.layout.fragment_first_menu, container, false);
        context = container.getContext();
        ffmb.imbCatchBan.setOnClickListener(this);
        ffmb.imbEez.setOnClickListener(this);
//        ffmb.imbGlobalFish.setOnClickListener(this);
        ffmb.imbTac.setOnClickListener(this);
        return ffmb.getRoot();
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.imb_catchBan:
                MainActivity.strFlag = "catch";
                MainActivity.binding.imbDetail.setVisibility(View.VISIBLE);
                MainActivity.binding.tvTitle.setText("포획생물금지란?");
                MainActivity.binding.tvBg.setText("국립수산과학원의\n 수산생명자원센터에서 정한\n포획금지 시행령을\n 일반인이 접근하기 쉽게 정리했습니다.\n금지기간을 시각적으로 보여줍니다.");
                break;
            case R.id.imb_eez:
                MainActivity.strFlag = "eez";
                MainActivity.binding.imbDetail.setVisibility(View.VISIBLE);
                MainActivity.binding.tvTitle.setText("EEZ란?");
                MainActivity.binding.tvBg.setText("배타적 경제수역은 영해 기준선으로부터 \n 200해리 이내의 수역을 말합니다.\n개발, 보존, 관리등의 주권적 권리를 가집니다.\n \n협정수역도\n우리어선->외국EEZ / 외국어선->우리EEZ \n 현황을 제공합니다.");
                break;
            case R.id.imb_tac:
                MainActivity.strFlag = "tac";
                MainActivity.binding.imbDetail.setVisibility(View.VISIBLE);
                MainActivity.binding.tvTitle.setText("TAC란?");
                MainActivity.binding.tvBg.setText("Total Allowable Catch (총 허용 어획량)\n어업자원의 지속적 이용을 목적으로 \n 어획량을 정하여 관리하는 제도입니다.\n \n 작년도의 지역별 TAC비율, \n최근까지의 어종별 소진량, \n수산자원조사원 배치현황을 제공합니다.");
                break;
            case R.id.tvFuture:
                MainActivity.strFlag = "global";
                MainActivity.binding.imbDetail.setVisibility(View.VISIBLE);
                MainActivity.binding.tvTitle.setText("원양어업통계란?");
                MainActivity.binding.tvBg.setText("대한민국국민이 해외수역에서 \n단독 또는 외국인과 합작하여\n수산동식물을 포획·채취하는 사업을 말합니다.\n \n품종별 현황, 해역별 현황\n원양어업 해역도를 제공합니다.");
                break;
            default:
                break;

        }
    }
}

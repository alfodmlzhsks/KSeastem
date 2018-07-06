package com.gugu.wegolsu.k_seastem.fragment;

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
import com.gugu.wegolsu.k_seastem.databinding.FragmentSecondMenuBinding;

public class SecondMenuFragment extends Fragment implements OnClickListener {

    FragmentSecondMenuBinding fsmb = null;

    public SecondMenuFragment() {
        super();
    }

    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle paramBundle) {
        fsmb = DataBindingUtil.inflate(inflater, R.layout.fragment_second_menu, container, false);
        fsmb.imbTotalYear.setOnClickListener(this);
        fsmb.imbPirate.setOnClickListener(this);
        fsmb.imbGuard.setOnClickListener(this);
        fsmb.imbCall.setOnClickListener(this);

        return fsmb.getRoot();
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.imb_totalYear:
                MainActivity.strFlag = "total";
                MainActivity.binding.imbDetail.setVisibility(View.VISIBLE);
                MainActivity.binding.tvTitle.setText("수산물 생산량 비교란?");
                MainActivity.binding.tvBg.setText("최근3년간의 어업별\n생산량, 생산금액을 보여줍니다.\n(일반해면, 천해양식, 내수면)\n\n이를 통해 일반국민들도\n어업생산동향 정보를 쉽게 접할 수 있습니다.");
                break;
            case R.id.imb_pirate:
                MainActivity.strFlag = "pirate";
                MainActivity.binding.imbDetail.setVisibility(View.VISIBLE);
                MainActivity.binding.tvTitle.setText("해적현황이란?");
                MainActivity.binding.tvBg.setText("해양안전종합정보시스템의\n해적정보를 쉽게 정리했습니다.\n\n지역별 해적통계,\n공격유형별 해적통계,\n해적동향(1주일)을 제공합니다.");
                break;
            case R.id.imb_guard:
                MainActivity.strFlag = "news";
                MainActivity.binding.imbDetail.setVisibility(View.VISIBLE);
                MainActivity.binding.tvTitle.setText("뉴스란?");
                MainActivity.binding.tvBg.setText("수산정보포털에서 제공하는\n수산뉴스를 쉽게 만나볼 수 있습니다.");
                break;
            case R.id.imb_call:
                MainActivity.strFlag = "call";
                MainActivity.binding.imbDetail.setVisibility(View.VISIBLE);
                MainActivity.binding.tvTitle.setText("관련부서 전화번호란?");
                MainActivity.binding.tvBg.setText("각 부처의 전화번호를 제공합니다.\n\n앱을 통하여 전화연결이 가능합니다.");
                break;
            default:
                break;
        }
    }
}

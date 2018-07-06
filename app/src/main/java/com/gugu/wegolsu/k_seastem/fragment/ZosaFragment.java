package com.gugu.wegolsu.k_seastem.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;

import com.gugu.wegolsu.k_seastem.R;
import com.gugu.wegolsu.k_seastem.databinding.FragmentZosaBinding;

public class ZosaFragment extends Fragment {
    FragmentZosaBinding binding = null;

    public ZosaFragment() {
        super();
    }

    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle paramBundle) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_zosa, container, false);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(container.getContext(), R.array.zosa, android.R.layout.simple_spinner_item);

        binding.spinnerZosa.setAdapter(adapter);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        binding.spinnerZosa.setOnItemSelectedListener(new OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                String temp = (String) adapterView.getItemAtPosition(i);
                binding.tvZosaoneContent.setText(temp);

                switch (temp) {
                    case "부산":
                        binding.tvSosokContent.setText("본사\n자원정보실\n(13명)");
                        binding.tvBokmuContent.setText("본사(4명)\n공동어시장\n(9명)");
                        return;
                    case "포항":
                        binding.tvSosokContent.setText("동해본부\n기획운영팀\n(1명)");
                        binding.tvBokmuContent.setText("동해본부");
                        return;
                    case "구룡포":
                        binding.tvSosokContent.setText("동해본부\n기획운영팀\n(3명)");
                        binding.tvBokmuContent.setText("구룡포수협");
                        return;
                    case "울릉도":
                        binding.tvSosokContent.setText("동해본부\n기획운영팀\n(1명)");
                        binding.tvBokmuContent.setText("경북어업\n기술센터\n울릉지소");
                        return;
                    case "감포":
                        binding.tvSosokContent.setText("동해본부\n기획운영팀\n(2명)");
                        binding.tvBokmuContent.setText("경주시수협");
                        return;
                    case "울산":
                        binding.tvSosokContent.setText("동해본부\n기획운영팀\n(2명)");
                        binding.tvBokmuContent.setText("국립수산과학원\n고래연구센터");
                        return;
                    case "강구":
                        binding.tvSosokContent.setText("동해본부\n기획운영팀\n(2명)");
                        binding.tvBokmuContent.setText("강구수협");
                        return;
                    case "영덕":
                        binding.tvSosokContent.setText("동해본부\n기획운영팀\n(1명)");
                        binding.tvBokmuContent.setText("영덕북부수협\n축산지점");
                        return;
                    case "후포":
                        binding.tvSosokContent.setText("동해본부\n동해생명\n자원센터\n(2명)");
                        binding.tvBokmuContent.setText("울진바다목장\n홍보관");
                        return;
                    case "죽변":
                        binding.tvSosokContent.setText("동해본부\n동해생명\n자원센터\n(2명)");
                        binding.tvBokmuContent.setText("죽변수협");
                        return;
                    case "강릉":
                        binding.tvSosokContent.setText("동해본부\n내수면생명\n자원센터\n(3명)");
                        binding.tvBokmuContent.setText("내수면생명\n자원센터");
                        return;
                    case "삼척":
                        binding.tvSosokContent.setText("동해본부\n내수면생명\n자원센터\n(2명)");
                        binding.tvBokmuContent.setText("삼척수협");
                        return;
                    case "속초":
                        binding.tvSosokContent.setText("동해본부\n내수면생명\n자원센터\n(4명)");
                        binding.tvBokmuContent.setText("속초수협");
                        return;
                    case "동해":
                        binding.tvSosokContent.setText("동해본부\n내수면생명\n자원센터\n(1명)");
                        binding.tvBokmuContent.setText("묵호수협");
                        return;
                    case "군산":
                        binding.tvSosokContent.setText("서해\n기획운영팀\n(2명)");
                        binding.tvBokmuContent.setText("서해본부");
                        return;
                    case "보령":
                        binding.tvSosokContent.setText("서해\n기획운영팀\n(2명)");
                        binding.tvBokmuContent.setText("충남수산관리소\n보령사무소");
                        return;
                    case "태안":
                        binding.tvSosokContent.setText("서해\n기획운영팀\n(2명)");
                        binding.tvBokmuContent.setText("국립수산과학원\n양식연구센터");
                        return;
                    case "안면도":
                        binding.tvSosokContent.setText("서해\n기획운영팀\n(2명)");
                        binding.tvBokmuContent.setText("태안바다목장\n현장사무소");
                        return;
                    case "인천":
                        binding.tvSosokContent.setText("서해본부\n경인사업센터\n(5명)");
                        binding.tvBokmuContent.setText("인천수협");
                        return;
                    case "대청도":
                        binding.tvSosokContent.setText("서해본부\n경인사업센터\n(1명)");
                        binding.tvBokmuContent.setText("옹진수협\n대청지소");
                        return;
                    case "여수":
                        binding.tvSosokContent.setText("남해본부\n기획운영팀\n(4명)");
                        binding.tvBokmuContent.setText("남해본부");
                        return;
                    case "고흥":
                        binding.tvSosokContent.setText("남해본부\n기획운영팀\n(4명)");
                        binding.tvBokmuContent.setText("남해본부");
                        return;
                    case "거문도":
                        binding.tvSosokContent.setText("남해본부\n기획운영팀\n(1명)");
                        binding.tvBokmuContent.setText("거문도수협");
                        return;
                    case "목포":
                        binding.tvSosokContent.setText("남해본부\n기획운영팀\n(3명)");
                        binding.tvBokmuContent.setText("서해\n어업관리단");
                        return;
                    case "흑산도":
                        binding.tvSosokContent.setText("남해본부\n기획운영팀\n(1명)");
                        binding.tvBokmuContent.setText("흑산도수협");
                        return;
                    case "진도":
                        binding.tvSosokContent.setText("남해본부\n기획운영팀\n(1명)");
                        binding.tvBokmuContent.setText("전남해양수산과학원\n진도지원");
                        return;
                    case "통영":
                        binding.tvSosokContent.setText("남해본부\n기획운영팀\n(1명)");
                        binding.tvBokmuContent.setText("국립수산과학원\n수산자원연구센터");
                        return;
                    case "진해":
                        binding.tvSosokContent.setText("남해본부\n기획운영팀\n(1명)");
                        binding.tvBokmuContent.setText("국립수산과학원\n내수면양식연구센터");
                        return;
                    case "마산":
                        binding.tvSosokContent.setText("남해본부\n기획운영팀\n(1명)");
                        binding.tvBokmuContent.setText("경남수산기술사업소\n마산사무소");
                        return;
                    case "거제":
                        binding.tvSosokContent.setText("남해본부\n기획운영팀\n(1명)");
                        binding.tvBokmuContent.setText("거제수협");
                        return;
                    case "사천":
                        binding.tvSosokContent.setText("남해본부\n기획운영팀\n(4명)");
                        binding.tvBokmuContent.setText("사천수협");
                        return;
                    case "남해":
                        binding.tvSosokContent.setText("남해본부\n기획운영팀\n(4명)");
                        binding.tvBokmuContent.setText("남해본부");
                        return;
                    case "완도":
                        binding.tvSosokContent.setText("남해생명\n자원센터\n(1명)");
                        binding.tvBokmuContent.setText("남해생명\n자원센터");
                        return;
                    case "제주":
                        binding.tvSosokContent.setText("제주본부\n기획운영팀\n(8명)");
                        binding.tvBokmuContent.setText("제주본부");
                        return;
                    default:
                        return;
                }

            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });


        return binding.getRoot();
    }
}

package com.gugu.wegolsu.k_seastem.fragment;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.gugu.wegolsu.k_seastem.R;
import com.gugu.wegolsu.k_seastem.databinding.FragmentEezPicture1Binding;

public class EEZPictureFragment1 extends Fragment {
    FragmentEezPicture1Binding binding = null;
    Context context = null;
    String key = null;

    public EEZPictureFragment1() {
        super();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_eez_picture1, container, false);
        context = container.getContext();
        ArrayAdapter adapter = ArrayAdapter.createFromResource(context, R.array.eezWorld, android.R.layout.simple_spinner_item);

        binding.spinnerEEZPic3.setAdapter(adapter);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        binding.spinnerEEZPic3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String temp = (String) adapterView.getItemAtPosition(i);
                if (temp.equals("일본")) {
                    ArrayAdapter adapter = ArrayAdapter.createFromResource(context, R.array.eezKoJapan, android.R.layout.simple_spinner_item);
                    binding.spinnerEEZPic4.setAdapter(adapter);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                } else {
                    ArrayAdapter adapter = ArrayAdapter.createFromResource(context, R.array.eezKoChina, android.R.layout.simple_spinner_item);
                    binding.spinnerEEZPic4.setAdapter(adapter);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        binding.spinnerEEZPic4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String temp = (String) adapterView.getItemAtPosition(i);

                switch (temp) {
                    case "저인망류":
                        binding.ivEEZPicture1.setImageResource(R.drawable.kochina_juinmang);
                        break;
                    case "선망":
                        binding.ivEEZPicture1.setImageResource(R.drawable.kochina_seonmang);
                        break;
                    case "안강망":
                        binding.ivEEZPicture1.setImageResource(R.drawable.kochina_angangmang);
                        break;
                    case "자망류":
                        binding.ivEEZPicture1.setImageResource(R.drawable.kochina_jamang);
                        break;
                    case "통발류":
                        binding.ivEEZPicture1.setImageResource(R.drawable.kochina_tongbal);
                        break;
                    case "낚시류":
                        binding.ivEEZPicture1.setImageResource(R.drawable.kochina_naksi);
                        break;
                    case "일반어획물운반선":
                        binding.ivEEZPicture1.setImageResource(R.drawable.kochina_general);
                        break;
                    case "꽁치봉수망":
                        binding.ivEEZPicture1.setImageResource(R.drawable.kojapan_ggonchi);
                        break;
                    case "오징어채낚기":
                        binding.ivEEZPicture1.setImageResource(R.drawable.kojapan_ojinga);
                        break;
                    case "대형기선외끌이":
                        binding.ivEEZPicture1.setImageResource(R.drawable.kojapan_weggle);
                        break;
                    case "대형기선쌍끌이":
                        binding.ivEEZPicture1.setImageResource(R.drawable.kojapan_ssangggle);
                        break;
                    case "대형트롤":
                        binding.ivEEZPicture1.setImageResource(R.drawable.kojapan_troll);
                        break;
                    case "중형기선저인망":
                        binding.ivEEZPicture1.setImageResource(R.drawable.kojapan_jeinmang);
                        break;
                    case "선망어업":
                        binding.ivEEZPicture1.setImageResource(R.drawable.kojapan_seonmang);
                        break;
                    case "선망어업 금지구역":
                        binding.ivEEZPicture1.setImageResource(R.drawable.kojapan_seonmangban);
                        break;
                    case "연승어업":
                        binding.ivEEZPicture1.setImageResource(R.drawable.kojapan_yeonseung);
                        break;
                    case "연승어업 금지구역":
                        binding.ivEEZPicture1.setImageResource(R.drawable.kojapan_yeonseungban);
                        break;
                    case "외줄낚시":
                        binding.ivEEZPicture1.setImageResource(R.drawable.kojapan_wejul);
                        break;
                    case "복어채낚기":
                        binding.ivEEZPicture1.setImageResource(R.drawable.kojapan_boka);
                        break;
                    case "갈치채낚기":
                        binding.ivEEZPicture1.setImageResource(R.drawable.kojapan_galchi);
                        break;
                    case "원양오징어채낚기":
                        binding.ivEEZPicture1.setImageResource(R.drawable.kojapan_wonyangojina);
                        break;
                    case "공통규제":
                        binding.ivEEZPicture1.setImageResource(R.drawable.kojapan_common);
                        break;
                    case "조업수역코드":
                        binding.ivEEZPicture1.setImageResource(R.drawable.kojapan_code);
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        return binding.getRoot();
    }
}
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
import com.gugu.wegolsu.k_seastem.databinding.FragmentEezPictureBinding;

public class EEZPictureFragment extends Fragment {
    FragmentEezPictureBinding binding = null;
    Context context = null;

    public EEZPictureFragment() {
        super();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_eez_picture, container, false);
        context = container.getContext();
        ArrayAdapter adapter = ArrayAdapter.createFromResource(context, R.array.eezWorld, android.R.layout.simple_spinner_item);

        binding.spinnerEEZPic1.setAdapter(adapter);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        binding.spinnerEEZPic1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String temp = (String)adapterView.getItemAtPosition(i);
                if(temp.equals("일본")) {
                    ArrayAdapter adapter = ArrayAdapter.createFromResource(EEZPictureFragment.this.context, R.array.eezJapan, android.R.layout.simple_spinner_item);
                    binding.spinnerEEZPic2.setAdapter(adapter);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                } else {
                    ArrayAdapter adapter = ArrayAdapter.createFromResource(EEZPictureFragment.this.context, R.array.eezChina, android.R.layout.simple_spinner_item);
                    binding.spinnerEEZPic2.setAdapter(adapter);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        binding.spinnerEEZPic2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String temp = (String)adapterView.getItemAtPosition(i);

                switch(temp) {
                    case "타망":
                        binding.ivEEZPicture.setImageResource(R.drawable.china_tamang);
                        break;
                    case "위망":
                        binding.ivEEZPicture.setImageResource(R.drawable.china_wemang);
                        break;
                    case "유망":
                        binding.ivEEZPicture.setImageResource(R.drawable.china_yumang);
                        break;
                    case "오징어채낚기(우조)":
                        binding.ivEEZPicture.setImageResource(R.drawable.china_ojinga);
                        break;
                    case "일반어획물운반선":
                        binding.ivEEZPicture.setImageResource(R.drawable.china_general);
                        break;
                    case "공통규제":
                        binding.ivEEZPicture.setImageResource(R.drawable.japan_common);
                        break;
                    case "대중형선망":
                        binding.ivEEZPicture.setImageResource(R.drawable.japan_daejung);
                        break;
                    case "이서저인망":
                        binding.ivEEZPicture.setImageResource(R.drawable.japan_eseo);
                        break;
                    case "충합저인망":
                        binding.ivEEZPicture.setImageResource(R.drawable.japan_chung);
                        break;
                    case "오징어채낚기":
                        binding.ivEEZPicture.setImageResource(R.drawable.japan_ojinga);
                        break;
                    case "연승":
                        binding.ivEEZPicture.setImageResource(R.drawable.japan_yeonseung);
                        break;
                    case "예인조":
                        binding.ivEEZPicture.setImageResource(R.drawable.japan_yein);
                        break;
                    case "가다랑어일본조":
                        binding.ivEEZPicture.setImageResource(R.drawable.japan_gadaranga);
                        break;
                    case "일본조":
                        binding.ivEEZPicture.setImageResource(R.drawable.japan_japan);
                        break;
                    case "청새치돌봉":
                        binding.ivEEZPicture.setImageResource(R.drawable.japan_cheongsae);
                        break;
                    case "고정식자망":
                        binding.ivEEZPicture.setImageResource(R.drawable.japan_gojeong);
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


/* Location:              C:\Users\gugu\Downloads\dex2jar-2.0\dex2jar-2.0\kseastem-dex2jar.jar!\com\gugu\wegolsu\k_seastem\fragment\EEZPictureFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.gugu.wegolsu.k_seastem;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;

import com.gugu.wegolsu.k_seastem.ListDO.CallDO;
import com.gugu.wegolsu.k_seastem.ListDO.CallListAdapter;
import com.gugu.wegolsu.k_seastem.databinding.ActivityCallBinding;

public class CallActivity extends AppCompatActivity {

    ActivityCallBinding binding = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_call);
        binding.setCall(this);

        CallListAdapter adapter = new CallListAdapter();
        adapter.addItem("해양수산부", "044-200-5990");
        adapter.addItem("부산항만공사", "051-999-3000");
        adapter.addItem("인천항만공사", "032-890-8000");
        adapter.addItem("해양환경관리공단", "02-3498-8500");
        adapter.addItem("한국수산자원관리공단", "051-742-3391");

        binding.lvCall.setAdapter(adapter);



        binding.lvCall.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                CallDO temp = (CallDO)adapterView.getItemAtPosition(i);

                try{
                    switch(i) {
                        case 0:
                            startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:0442005990")));
                            break;
                        case 1:
                            startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:0519993000")));
                            break;
                        case 2:
                            startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:0328908000")));
                            break;
                        case 3:
                            startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:0234988500")));
                            break;
                        case 4:
                            startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:0517423391")));
                            break;
                        default:
                            break;
                    }
                }catch(SecurityException e) {
                    e.printStackTrace();
                }

            }
        });
    }
}

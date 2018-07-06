package com.gugu.wegolsu.k_seastem;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.pm.ActivityInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.gugu.wegolsu.k_seastem.ListDO.CatchDO;
import com.gugu.wegolsu.k_seastem.ListDO.CatchListAdapter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CatchBanActivity extends AppCompatActivity {

    ProgressDialog dialog = null;
    ListView lvBan = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        // 화면을 landscape(가로) 화면으로 고정하고 싶은 경우

        setContentView(R.layout.activity_catch_ban);

        CatchListAdapter adapter = new CatchListAdapter();
        LoadingAnimation animation = new LoadingAnimation(dialog, adapter);
        animation.execute("");

        SimpleDateFormat format = new SimpleDateFormat("MM-dd");
        final Date date = new Date();

        String today = format.format(date);

        ListView lvBan = (ListView) findViewById(R.id.lvBan);

        lvBan.setAdapter(adapter);

        //클릭스 부가설명
        lvBan.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                CatchDO temp = (CatchDO)adapterView.getItemAtPosition(i);

                show(temp.getStrName());
            }
        });
    }

    private void show(String name)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.catch_ban_select, null);
        builder.setView(view);

        final AlertDialog dialog = builder.create();
        final TextView tvFishName = (TextView)view.findViewById(R.id.tvFishName);
        final ImageView ivFish = (ImageView)view.findViewById(R.id.ivFish);
        final TextView tvContent = (TextView)view.findViewById(R.id.tvContent);
        final ImageView ivMap = (ImageView)view.findViewById(R.id.ivMap);

        switch(name) {
            case "개서대":
                tvFishName.setText("개서대");
                ivFish.setImageResource(R.drawable.gaeseodae);
                tvContent.setText("부가설명 없음");
                break;
            case "대구":
                tvFishName.setText("대구");
                ivFish.setImageResource(R.drawable.daegu);
                tvContent.setText("부산광역시 및 경상남도는\n 1월 1일 ~ 1월 31일");
                break;
            case "문치가자미":
                tvFishName.setText("문치가자미");
                ivFish.setImageResource(R.drawable.daegu);
                tvContent.setText("부가설명 없음");
                break;
            case "연어":
                tvFishName.setText("연어");
                ivFish.setImageResource(R.drawable.yeona);
                tvContent.setText("부가설명 없음");
                break;
            case "전어":
                tvFishName.setText("전어");
                ivFish.setImageResource(R.drawable.jeona);
                tvContent.setText("강원도, 경상북도는 제외");
                break;
            case "쥐노래미":
                ivMap.setVisibility(View.VISIBLE);
                tvFishName.setText("쥐노래미");
                ivFish.setImageResource(R.drawable.jeona);
                tvContent.setText("위의 해역에서는 11월 15일 ~ 12월 14일");
                ivMap.setImageResource(R.drawable.gmap);
                break;
            case "참홍어":
                tvFishName.setText("참홍어");
                ivFish.setImageResource(R.drawable.honga);
                tvContent.setText("부가설명 없음");
                break;
            case "참조기":
                tvFishName.setText("참조기");
                ivFish.setImageResource(R.drawable.zogi);
                tvContent.setText("유자망을 사용하는 경우 \n4월 22일 ~ 8월 10일\n단 10퍼센트 미만은 제외");
                break;
            case "갈치":
                tvFishName.setText("갈치");
                ivFish.setImageResource(R.drawable.galchi);
                tvContent.setText("북위33도00분00초 이북해역 한정\n단 10퍼센트 미만은 제외");
                break;
            case "고등어":
                tvFishName.setText("고등어");
                ivFish.setImageResource(R.drawable.godeunga);
                tvContent.setText("기간 중 해양수산부가 정한 1개월\n단 10퍼센트 미만은 제외");
                break;
            case "말쥐치":
                tvFishName.setText("말쥐치");
                ivFish.setImageResource(R.drawable.malgchi);
                tvContent.setText("정치망어업, 연안어업, 구획어업은 \n6월 1일 ~ 7월 31일");
                break;
            case "옥돔":
                tvFishName.setText("옥돔");
                ivFish.setImageResource(R.drawable.okdom);
                tvContent.setText("부가설명 없음");
                break;
            case "미거지":
                tvFishName.setText("미거지");
                ivFish.setImageResource(R.drawable.miguzi);
                tvContent.setText("부가설명 없음");
                break;
            case "꽃게":
                tvFishName.setText("꽃게");
                ivFish.setImageResource(R.drawable.gokgae);
                tvContent.setTextSize(12);
                tvContent.setText("기간 중 해양수산부가 정한 2개월\n어획량의 5퍼센트 이상 포획하지 않는 경우에는 외끌이대형저인망어업, 쌍끌이대형저인망어업, 동해구외끌이중형저인망어업, \n서남해구외끌이중형저인망어업, 서남해구쌍끌이중형저인망어업, 대형트롤어업,\n 근해안강망어업은 제외한다");
                break;
            case "대게류":
                ivMap.setVisibility(View.VISIBLE);
                tvFishName.setText("대게류");
                ivFish.setImageResource(R.drawable.daegae);
                tvContent.setTextSize(12);
                tvContent.setText("위의 해역에서는 3월 1일 ~ 4월 30일\n\n동경 131도30분: 6월 1일 ~ 10월 31일\n\n북위38도34분09.68초, 강원도 고성군 현내면 지경리 해안선의 교점\n북위38도34분09.69초, 동경128도30분06.89초의 교점\n북위38도33분09.69초, 동경128도30분06.89초의 교점\n북위38도33분09.69초, 강원도 고성군 현내면 저진리 해안선의 교점을 차례대로 연결한 선 안의 해역에서는\n4월 1일 ~ 7월 20일");
                ivMap.setImageResource(R.drawable.daegaemap);
                break;
            case "붉은대게":
                tvFishName.setText("붉은대게");
                ivFish.setImageResource(R.drawable.daegae);
                tvContent.setText("강원도 연안자망어업은\n6월 1일 ~ 7월10일");
                break;
            case "털게":
                tvFishName.setText("털게");
                ivFish.setImageResource(R.drawable.tulgae);
                tvContent.setText("강원도 한정");
                break;
            case "닭새우":
                tvFishName.setText("털게");
                ivFish.setImageResource(R.drawable.daksaeu);
                tvContent.setText("부가설명 없음");
                break;
            case "대하":
                tvFishName.setText("대하");
                ivFish.setImageResource(R.drawable.daeha);
                tvContent.setText("부가설명 없음");
                break;
            case "펄닭새우":
                tvFishName.setText("펄닭새우");
                ivFish.setImageResource(R.drawable.perldaksaeu);
                tvContent.setText("부가설명 없음");
                break;
            case "백합":
                tvFishName.setText("백합");
                ivFish.setImageResource(R.drawable.bakhap);
                tvContent.setText("부가설명 없음");
                break;
            case "새조개":
                tvFishName.setText("새조개");
                tvContent.setTextSize(12);
                ivFish.setImageResource(R.drawable.saezogae);
                tvContent.setText("부산광역시, 울산광역시\n경상남도, 전라남도(무안군, 영관군 제외)\n제주특별자치도\n6월 1일 ~ 9월 30일");
                break;
            case "소라":
                tvFishName.setText("소라");
                tvContent.setTextSize(12);
                ivFish.setImageResource(R.drawable.sora);
                tvContent.setText("전라남도 여수시 산삼면, 제주특별자치도 제주시(추자면 추자도 제외)는\n6월 1일 ~ 8월 31일\n\n제주특별자치도 추자면 추자도는 7월 1일 ~ 9월 30일\n경상북도 울릉군 울릉도와 독도는 6월 1일 ~ 9월 30일");
                break;
            case "전복류":
                tvFishName.setText("전복류");
                ivFish.setImageResource(R.drawable.zeonbok);
                tvContent.setText("제주특별자치도는 10월 1일 ~ 12월 31일");
                break;
            case "코끼리조개":
                tvFishName.setText("코끼리조개");
                ivFish.setImageResource(R.drawable.koggirizogae);
                tvContent.setText("강원도와 경상북도 한정");
                break;
            case "키조개":
                tvFishName.setText("키조개");
                ivFish.setImageResource(R.drawable.kozogae);
                tvContent.setText("부가설명 없음");
                break;
            case "가리비":
                tvFishName.setText("가리비");
                tvContent.setTextSize(12);
                ivFish.setImageResource(R.drawable.garibi);
                tvContent.setText("북위36도 04분 10.74초, 동경129도 24분 51.72초\n북위36도 04분 10.75초, 동경129도 34분 51.66초\n북위36도 09분 10.71초, 동경129도 24분 51.71초\n북위36도 09분 10.71초, 동경129도 34분 51.66초\n안의 해역 한정");
                break;
            case "오분자기":
                tvFishName.setText("오분자기");
                ivFish.setImageResource(R.drawable.obunzagi);
                tvContent.setText("제주특별자치도 한정");
                break;
            case "개다시마":
                tvFishName.setText("개다시마");
                ivFish.setImageResource(R.drawable.gaedasima);
                tvContent.setText("부가설명 없음");
                break;
            case "감태":
                tvFishName.setText("감태");
                ivFish.setImageResource(R.drawable.gamtae);
                tvContent.setText("제주특별자치도는\n1월 1일 ~ 12월 31일");
                break;
            case "곰피":
                tvFishName.setText("곰피");
                ivFish.setImageResource(R.drawable.gompi);
                tvContent.setText("부가설명 없음");
                break;
            case "넓미역":
                tvFishName.setText("넓미역");
                ivFish.setImageResource(R.drawable.nulbmiyeok);
                tvContent.setText("제주특별자치도 한정");
                break;
            case "대황":
                tvFishName.setText("대황");
                ivFish.setImageResource(R.drawable.daehwang);
                tvContent.setText("부가설명 없음");
                break;
            case "도박류":
                tvFishName.setText("도박류");
                ivFish.setImageResource(R.drawable.dobak);
                tvContent.setText("부가설명 없음");
                break;
            case "뜸부기":
                tvFishName.setText("뜸부기");
                ivFish.setImageResource(R.drawable.ddeumbugi);
                tvContent.setText("부가설명 없음");
                break;
            case "우뭇가사리":
                tvFishName.setText("우뭇가사리");
                ivFish.setImageResource(R.drawable.umootgasari);
                tvContent.setText("부가설명 없음");
                break;
            case "톳":
                tvFishName.setText("톳");
                ivFish.setImageResource(R.drawable.tot);
                tvContent.setText("부가설명 없음");
                break;
            case "해삼":
                tvFishName.setText("해삼");
                ivFish.setImageResource(R.drawable.hasam);
                tvContent.setText("부가설명 없음");
                break;
            case "살오징어":
                tvFishName.setText("살오징어");
                ivFish.setImageResource(R.drawable.salojinga);
                tvContent.setText("근해채낚기어업, 연안복합어업은\n4월 1일 ~ 4월 30일\n단 정치어업망의 경우 제외");
                break;
            case "낙지":
                tvFishName.setText("낙지");
                ivFish.setImageResource(R.drawable.nakji);
                tvContent.setText("시.도지사가 4월 1일 ~ 9월 30일 기간 중\n1개월 이상의 기간을 지역별로 따로 정하여\n고시하는 경우 해당 기간으로 한다");
                break;
            case "쭈꾸미":
                tvFishName.setText("쭈꾸미");
                ivFish.setImageResource(R.drawable.zzoggumi);
                tvContent.setText("부가설명 없음");
                break;
        }

        dialog.show();

    }

    private class LoadingAnimation extends AsyncTask<String, String, String> {

        ProgressDialog dialog = null;
        CatchListAdapter adapter = null;

        public LoadingAnimation(ProgressDialog dialog, CatchListAdapter adapter) {
            super();

            this.dialog = dialog;
            this.adapter = adapter;

            this.dialog = new ProgressDialog(CatchBanActivity.this);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            dialog.setMessage("업데이트 중..");

            dialog.show();


        }

        //날짜 거르고, 남은기간출력 루틴
        @Override
        protected String doInBackground(String... strings) {

            final String year = new SimpleDateFormat("yyyy").format(new Date());

            int i = 0;
            CatchDO temp = null;

            while (i < 41) {
                temp = MainActivity.catchData.get(i);
                String start = temp.getStrStart();
                start = year + start;

                long startDays = diffOfDate(start);

                Log.i("start", "" + startDays); //남은일자 잘나오는지 로그
                //0보다 작으면 해당됨, 0보다 크면 아직아님

                String end = temp.getStrEnd();
                end = year + end;

                long endDays = diffOfDate(end);
                //0보다 작으면 올해+1, 0보다 크면 올해

                if (endDays <= 0) {
                    end = (Integer.parseInt(year) + 1) + temp.getStrEnd();
                }
                Log.i("end", "" + endDays);

                if (startDays <= 0 && endDays >= 0) {
                    adapter.addItem(temp.getStrName(), "" + endDays);
                }
                i++;
            }

            //어째선지 이거를 while전에 쓰면 adapter.addItem이 코드중간에 실행이안됨;;;
            try {

                for (int j = 0; j < 5; j++) {
                    //asyncDialog.setProgress(i * 30);
                    Thread.sleep(500);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return "123";
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String s) {

            dialog.dismiss();

            super.onPostExecute(s);
        }

        //시작날짜 넘겨주면 오늘이랑 날짜차이 알려줌
        public long diffOfDate(String date) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
            Date beginDate = new Date();
            Date endDate = null;

            try {
                beginDate = formatter.parse(new SimpleDateFormat("yyyyMMdd").format(beginDate));    //오늘날짜
                endDate = formatter.parse(date);   //타겟날짜
            } catch (ParseException e) {

            }


            long diff = endDate.getTime() - beginDate.getTime();
            long diffDays = diff / (24 * 60 * 60 * 1000);

            return diffDays;
        }
    }

    //필수임 dialog띄우고 실제 액비비티에서도 종료안해주면 leak 에러뜸
    @Override
    protected void onStop() {
        super.onStop();

        if(dialog!=null) {
            dialog.dismiss();
            dialog = null;
        }
    }

}

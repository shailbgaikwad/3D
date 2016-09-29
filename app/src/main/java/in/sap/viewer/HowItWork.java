package in.sap.viewer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.IntentCompat;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import adapter.ViewPagerAdapter;

/**
 * Created by shailb on 25/01/16.
 */
public class HowItWork extends Activity {
    private ViewPager _mViewPager;
    ViewPagerAdapter adapter;
    private Button _btn1, _btn2, _btn3, _btn4;
    ArrayList<String> Imgurl;
    ArrayList<String> Color;
    TextView txtfinish, txtskip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        if (PreferenceHelper.GetHowitWork(HowItWork.this)) {
//            Intent i = new Intent(HowItWork.this, Splash.class);
//            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | IntentCompat.FLAG_ACTIVITY_CLEAR_TASK);
//            startActivity(i);
//        } else {

            setContentView(R.layout.howit_work);
            txtfinish = (TextView) findViewById(R.id.txtfinsish);
            txtskip = (TextView) findViewById(R.id.txtskip);
            Imgurl = new ArrayList<String>();
            Color = new ArrayList<String>();
            Imgurl.add("#99539C");
            Imgurl.add("#621D7F");
            Imgurl.add("#391B73");
            Imgurl.add("#ff7043");
            initButton();
            setUpView();
            setTab();

            txtskip.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(HowItWork.this, MainActivity.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | IntentCompat.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(i);
                }
            });
   //     }

    }

    private void setTab() {
        _mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrollStateChanged(int position) {
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            @Override
            public void onPageSelected(int position) {
                // TODO Auto-generated method stub
                if (position == 3) {
                    txtfinish.setVisibility(View.VISIBLE);
                } else {
                    txtfinish.setVisibility(View.INVISIBLE);

                }
                btnAction(position);
                //System.out.println("HIMHISDFSDF SDF SDF SDFS DF" + position);
            }

        });

        txtfinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HowItWork.this, MainActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | IntentCompat.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
            }
        });

    }

    private void setUpView() {
        _mViewPager = (ViewPager) findViewById(R.id.viewPager);
        adapter = new ViewPagerAdapter(HowItWork.this, Imgurl);
        _mViewPager.setAdapter(adapter);
        _mViewPager.setCurrentItem(0);
        // #99539C,#621D7F,#391B73
    }

    private void initButton() {
        HowItWork.this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                _btn1 = (Button) findViewById(R.id.btn1);
                _btn2 = (Button) findViewById(R.id.btn2);
                _btn3 = (Button) findViewById(R.id.btn3);
                _btn4 = (Button) findViewById(R.id.btn4);
                //_btn4= (Button) findViewById(R.id.btn4);
                setButton(_btn1, "", 25, 25);
                setButton(_btn2, "", 15, 15);
                setButton(_btn3, "", 15, 15);
                setButton(_btn4, "", 15, 15);
            }
        });

    }

    private void btnAction(int action) {
        switch (action) {

            case 0:
                setButton(_btn1, "", 25, 25);
                setButton(_btn2, "", 15, 15);
                break;
            case 1:
                setButton(_btn2, "", 25, 25);
                setButton(_btn1, "", 15, 15);
                setButton(_btn3, "", 15, 15);
                break;
            case 2:
                setButton(_btn3, "", 25, 25);
                setButton(_btn2, "", 15, 15);
                setButton(_btn4, "", 15, 15);

                break;
            case 3:
                setButton(_btn4, "", 25, 25);
                setButton(_btn3, "", 15, 15);

                break;
        }
    }

    private void setButton(final Button btn, String text, final int h, final int w) {
        HowItWork.this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                btn.setWidth(w);
                btn.setHeight(h);
                // btn.setText(text);

                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) btn.getLayoutParams();
                params.width = w;
                params.height = h;
                btn.setLayoutParams(params);
            }
        });

    }
}

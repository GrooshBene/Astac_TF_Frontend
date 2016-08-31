package grooshbene.edcan.kr.todaysfeeling;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by bene on 2016. 6. 21..
 */
public class SplashActivity extends Activity {
    Handler hd, mIntentHd;
    ImageView mLogo;
    TextView mTitleView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mLogo = (ImageView)findViewById(R.id.mLogo);
        mTitleView = (TextView)findViewById(R.id.mTitleView);
        hd = new Handler();
        mIntentHd = new Handler();
        hd.postDelayed(new Runnable() {
            @Override
            public void run() {
                mTitleView.setVisibility(View.VISIBLE);
                mTitleView.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.splash_fade_in));
            }
        }, 1500);
        mIntentHd.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MapActivity.class);
                startActivity(intent);
                finish();
            }
        }, 4500);

    }

    @Override
    public void onBackPressed() {

    }
}

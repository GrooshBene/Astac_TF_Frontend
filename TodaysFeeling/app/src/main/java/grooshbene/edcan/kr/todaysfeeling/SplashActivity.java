package grooshbene.edcan.kr.todaysfeeling;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

/**
 * Created by bene on 2016. 6. 21..
 */
public class SplashActivity extends Activity {
    Handler hd, mIntentHd;
    LinearLayout mLogo;
    LoginButton mFbLogin;
    CallbackManager manager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        manager = CallbackManager.Factory.create();
        mFbLogin = (LoginButton) findViewById(R.id.mFbLogin);
        mLogo = (LinearLayout)findViewById(R.id.mLogo);

        hd = new Handler();
        hd.postDelayed(new Runnable() {
            @Override
            public void run() {
                mLogo.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide));
                mFbLogin.setVisibility(View.VISIBLE);
                mFbLogin.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.splash_fade_in));
            }
        }, 1500);


        mFbLogin.setReadPermissions("email", "user_about_me", "user_friends");
        LoginManager.getInstance().registerCallback(manager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Log.e("Facebook Login Result", String.valueOf(loginResult));
                Intent intent = new Intent(SplashActivity.this, MapActivity.class);
                startActivity(intent);
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {
                Toast.makeText(SplashActivity.this, "서버와의 연결에 문제가 있습니다. 나중에 다시 시도해 주세요.", Toast.LENGTH_SHORT).show();
                Log.e("fbError", error.getMessage());
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        manager.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onBackPressed() {

    }
}

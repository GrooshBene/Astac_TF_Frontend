package grooshbene.edcan.kr.todaysfeeling;

import android.app.Application;

import com.facebook.FacebookSdk;

/**
 * Created by GrooshBene on 2016. 9. 9..
 */
public class ApplicationLauncher extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FacebookSdk.sdkInitialize(this);
    }
}

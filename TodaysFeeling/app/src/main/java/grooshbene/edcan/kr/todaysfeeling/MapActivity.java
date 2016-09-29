package grooshbene.edcan.kr.todaysfeeling;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.NavigationMenu;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.DrawableUtils;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

import io.github.yavski.fabspeeddial.FabSpeedDial;

/**
 * Created by bene on 2016. 6. 20..
 */
public class MapActivity extends ActionBarActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener, FabSpeedDial.MenuListener {

    ArrayList<MarkerOptions> markersArray = new ArrayList<MarkerOptions>();
    Toolbar mToolbar;
    LinearLayout mFabBackground;
    FabSpeedDial mFabSpeedDial;
    BeaconService mBeaconService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        mBeaconService = new BeaconService();
        mToolbar = (Toolbar) findViewById(R.id.mToolbar);
        mFabBackground = (LinearLayout) findViewById(R.id.fab_background);
        mFabSpeedDial = (FabSpeedDial) findViewById(R.id.mFabSpeedDial);
        setSupportActionBar(mToolbar);
        mToolbar.setTitleTextColor(Color.rgb(250,250,250));
        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        mFabSpeedDial.setMenuListener(this);
        startService(new Intent("grooshbene.edcan.kr.todaysfeeling.service"));
        makeNotification();
    }


    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng spot1 = new LatLng(37.5009040, 127.0257580);
        LatLng spot2 = new LatLng(37.4986671, 127.0285215);
        LatLng spot3 = new LatLng(37.497929, 127.0265303);
        LatLng spot4 = new LatLng(37.4977844, 127.0286143);
        LatLng spot5 = new LatLng(37.4996741, 127.0280135);
        LatLng spot6 = new LatLng(37.4996571, 127.0271552);
        LatLng spot7 = new LatLng(37.4964140, 127.0279598);
        LatLng spot8 = new LatLng(37.4996741, 127.0280135);
        LatLng spot9 = new LatLng(37.4977844, 127.0286143);
        LatLng spot10 = new LatLng(37.4985675, 127.0280457);
        LatLng spot11 = new LatLng(37.4972993, 127.0297194);
        addMarker("카페베네 강남대로점", "서울특별시 서초구 강남대로 429", spot1, R.drawable.love3);
        addMarker("카페베네 강남역 A타워점", "서울특별시 강남구 테헤란로 105", spot2, R.drawable.business2);
        addMarker("카페베네 강남역점", "서울특별시 서초구 서초대로 77길 3 아라타워 2층", spot3, R.drawable.friend1);
        addMarker("스타벅스 테헤란로점", "서울특별시 역삼동 서초 삼성타운", spot4, R.drawable.business5);
        addMarker("스타벅스 강남대로점", "서울특별시 서초구 강남대로 212", spot5, R.drawable.normal3);
        addMarker("커피빈 강남역점", "서울특별시 역삼동 서초 삼성타운", spot6, R.drawable.family4);
        addMarker("파리바게트 강남역점", "서울특별시 서초구 서초대로64길 32", spot7, R.drawable.family1);
        addMarker("윙스터디 강남점", "서울특별시 서초구 강남대로 129", spot8, R.drawable.friend15);
        addMarker("파리바게트 강남대로점", "서울특별시 역삼동 서초 삼성타운", spot9, R.drawable.love1);
        addMarker("강남역 카페도서관", "서울특별시 서초구 강남대로 21", spot10, R.drawable.normal1);
        addMarker("강남역 윙스터디 2호점", "서울특별시 서초구 서초대로 21길 34", spot11, R.drawable.friend4);

        //Android M Permission Request

        if (Build.VERSION.SDK_INT >= 23 && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.INTERNET}, 100);
        }

        else {

            googleMap.setMyLocationEnabled(true);
            for (int i = 0; i < markersArray.size(); i++) {
                googleMap.addMarker(markersArray.get(i));
                Log.e("asdf", markersArray.get(i).getPosition().toString());
            }
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(spot10, 17));
            googleMap.setOnMarkerClickListener(this);
            return;
        }

    }

    protected Marker createMarker(GoogleMap googleMap, LatLng latLng, String title, String snippet){

        return googleMap.addMarker(new MarkerOptions().position(latLng).title(title).snippet(snippet));
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        Intent intent = new Intent(MapActivity.this, PlaceInfoActivity.class);
        String title = marker.getTitle().toString();
        String snippet = marker.getSnippet().toString();
        intent.putExtra("title", title);
        intent.putExtra("snippet", snippet);
        startActivity(intent);
        return false;
    }

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public int checkPermission(String permission, int pid, int uid) {
        if(Build.VERSION.SDK_INT >= 23 && checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED || checkSelfPermission(Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.INTERNET}, 100);
        }
        return super.checkPermission(permission, pid, uid);
    }

    @Override
    public boolean onPrepareMenu(NavigationMenu navigationMenu) {
        mFabBackground.setBackgroundColor(Color.argb(80,00,00,00));
        mFabBackground.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in));
        return true;
    }

    @Override
    public boolean onMenuItemSelected(MenuItem menuItem) {
        mFabBackground.setBackgroundColor(Color.argb(00,00,00,00));
        Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT).show();
        return true;
    }

    @Override
    public void onMenuClosed() {
        mFabBackground.setBackgroundColor(Color.argb(00, 00, 00, 00));
//        mFabBackground.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_out));
    }

    public void addMarker(String title, String address, LatLng mLatLng, int icon){
        markersArray.add(new MarkerOptions().title(title).snippet(address).position(mLatLng).icon(BitmapDescriptorFactory.fromResource(icon)));
    }

    public void makeNotification(){
        NotificationManager mNotificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        Resources res = getResources();
        NotificationCompat.Builder mNotiBuilder = new NotificationCompat.Builder(this)
                .setContentTitle("오분 비콘 서비스")
                .setContentText("비콘 감지 기능이 켜져있습니다.")
                .setTicker("비콘 서비스 활성화")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(res, R.mipmap.ic_launcher))
                .setAutoCancel(true)
                .setDefaults(Notification.DEFAULT_SOUND| Notification.DEFAULT_VIBRATE| Notification.DEFAULT_LIGHTS)
                .setNumber(13);

        Notification n = mNotiBuilder.build();
        mNotificationManager.notify(1234, n);
    }

    public void destroyNotification(){
        NotificationManager mNotificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.cancel(1234);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopService(new Intent("grooshbene.edcan.kr.todaysfeeling.service"));
        destroyNotification();
    }
}

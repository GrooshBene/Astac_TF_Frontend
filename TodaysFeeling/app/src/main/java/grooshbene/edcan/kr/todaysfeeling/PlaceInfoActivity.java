package grooshbene.edcan.kr.todaysfeeling;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by bene on 2016. 6. 21..
 */
public class PlaceInfoActivity extends AppCompatActivity implements View.OnClickListener {

    CollapsingToolbarLayout mCollapsingToolbar;
    FragmentManager.OnBackStackChangedListener mBackStackListener;
    ImageView mImageView;
    Toolbar mToolbar;
    ListView mListView;
    View mListHeader;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_placeinfo);
        mCollapsingToolbar = (CollapsingToolbarLayout)findViewById(R.id.collapsing_toolbar);
        mToolbar = (Toolbar)findViewById(R.id.mToolbar);
        mListView = (ListView)findViewById(R.id.mListView);
        mImageView = (ImageView)findViewById(R.id.image);
        mImageView.setImageResource(R.drawable.eydia_image);
        setSupportActionBar(mToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        mCollapsingToolbar.setTitle("스타벅스 신논현점");
        mCollapsingToolbar.setExpandedTitleColor(getResources().getColor(android.R.color.white));

        mToolbar.setNavigationOnClickListener(this);



    }

    @Override
    public void onClick(View view) {
        finish();
    }
}

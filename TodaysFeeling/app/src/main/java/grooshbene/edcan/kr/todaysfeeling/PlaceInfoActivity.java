package grooshbene.edcan.kr.todaysfeeling;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.database.DataSetObserver;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bene on 2016. 6. 21..
 */
public class PlaceInfoActivity extends AppCompatActivity implements View.OnClickListener {

    ArrayList<ListData> arrayList;
    CollapsingToolbarLayout mCollapsingToolbar;
    FragmentManager.OnBackStackChangedListener mBackStackListener;
    ImageView mImageView;
    Toolbar mToolbar;
    ListView mListView;
    LayoutInflater mInflater;
    ArrayAdapter<String> mAdapter;
    ArrayList<String> arrList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_placeinfo);
        setDefault();
    }

    private void setDefault() {
        mInflater = getLayoutInflater();
        mCollapsingToolbar = (CollapsingToolbarLayout)findViewById(R.id.collapsing_toolbar);
        mToolbar = (Toolbar)findViewById(R.id.mToolbar);
        mListView = (ListView)findViewById(R.id.mListView);
        mImageView = (ImageView)findViewById(R.id.image);
        mImageView.setImageResource(R.drawable.eydia_image);
        setSupportActionBar(mToolbar);
        ArrayList<ListData> arrayList = new ArrayList<>();
        arrayList.add(new ListData("wow"));
        arrayList.add(new ListData("wow"));
        arrayList.add(new ListData("wow"));
        View header = mInflater.inflate(R.layout.place_listview_header, mListView, false);
        mListView.setAdapter(new ListViewAdapter(getApplicationContext(), arrayList));
        mListView.addHeaderView(header);

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

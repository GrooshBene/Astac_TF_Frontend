package grooshbene.edcan.kr.todaysfeeling;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by bene on 2016. 6. 21..
 */
public class MapDialog extends Activity {
    Intent intent;
    TextView mTitleView, mContentView;
    ImageView mImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_map);
        mTitleView = (TextView)findViewById(R.id.mTitleTextView);
        mContentView = (TextView)findViewById(R.id.mContentTextView);
        mImageView = (ImageView)findViewById(R.id.mImageView);
        intent = getIntent();
        String title = intent.getStringExtra("title");
        String snippet = intent.getStringExtra("snippet");
        if(title == "카페베네 강남역 A타워점"){
            mImageView.setImageBitmap(BitmapFactory.decodeResource(this.getResources() , R.drawable.another_chocolate_cake));
        }
        else if(title == "카페베네 강남역점"){
            mImageView.setImageBitmap(BitmapFactory.decodeResource(this.getResources() , R.drawable.one_another_chocolate_cake));
        }
        mTitleView.setText(title);
        mContentView.setText(snippet);

    }
}

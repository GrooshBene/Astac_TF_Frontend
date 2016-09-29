package grooshbene.edcan.kr.todaysfeeling;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by GrooshBene on 2016. 9. 29..
 */
public class ReviewDialog extends Activity implements View.OnClickListener {
    Button mButton;
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.review_dialog);
        mButton = (Button)findViewById(R.id.mRegisterButton);
        mButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        finish();
    }
}

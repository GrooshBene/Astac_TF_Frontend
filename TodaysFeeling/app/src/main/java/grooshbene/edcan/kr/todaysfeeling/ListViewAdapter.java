package grooshbene.edcan.kr.todaysfeeling;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by JunseokOh on 2016. 9. 19..
 */
public class ListViewAdapter extends ArrayAdapter<ListData> {
    private LayoutInflater inflater;
    private ArrayList<ListData> arrayList;

    public ListViewAdapter(Context context, ArrayList<ListData> arrayList) {
        super(context, 0, arrayList);
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.arrayList = arrayList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ListData data = arrayList.get(position);
        View view = inflater.inflate(R.layout.list_review_content, null);
        TextView textView = (TextView) view.findViewById(R.id.textView);
        textView.setText(data.getPhone());
        return view;
    }
}

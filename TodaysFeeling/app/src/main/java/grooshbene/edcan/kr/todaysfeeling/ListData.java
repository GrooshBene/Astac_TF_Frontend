package grooshbene.edcan.kr.todaysfeeling;

import android.content.Context;

/**
 * Created by GrooshBene on 2016. 9. 19..
 */
public class ListData {
    public String content_label;
    public String description;
    public String phone;
    public int spCnt;

    public ListData(String phone_) {
        phone = phone_;
    }


    public String getContent_label() {
        return content_label;
    }

    public String getDescription() {
        return description;
    }

    public String getPhone() {
        return phone;
    }

    public int getSpCnt(){return spCnt;}
}

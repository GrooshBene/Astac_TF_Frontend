package grooshbene.edcan.kr.todaysfeeling;

<<<<<<< HEAD
/**
 * Created by JunseokOh on 2016. 9. 19..
 */
public class ListData {
    private String title;

    public ListData(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
=======
import android.content.Context;

/**
 * Created by GrooshBene on 2016. 9. 19..
 */
public class ListData {
    public String content_label;
    public String description;
    public String phone;
    public int spCnt;

    public ListData(Context context, String phone_) {
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
>>>>>>> 27f53437a92234d4092ce747df9114c4460f6b1d
}

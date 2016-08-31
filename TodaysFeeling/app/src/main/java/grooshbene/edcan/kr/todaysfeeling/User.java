package grooshbene.edcan.kr.todaysfeeling;

/**
 * Created by bene on 2016. 8. 7..
 */
public class User {
    public String id;
    public String user_id;
    public String user_name;
    public String user_pw;
    public String user_type;
    public int age;
    public String gender;
    public String authToken;

    public User(String id, String user_id, String user_name, String user_pw, String user_type, int age, String gender, String authToken){
        this.id = id;
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_pw = user_pw;
        this.user_type = user_type;
        this.age = age;
        this.gender = gender;
        this.authToken = authToken;
    }
}

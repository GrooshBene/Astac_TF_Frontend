package grooshbene.edcan.kr.todaysfeeling;

/**
 * Created by bene on 2016. 8. 26..
 */
public class Place {
    public String id;
    public String placeName;
    public String placeSeller;
    public String openTime;
    public String closeTime;
    public float placeSilence;
    public float placeBright;
    public String placeAddress;
    public String placeCategory;
    public String sellerTalk;
    public String rateAverage;

    public Place(String id, String placeName, String placeSeller, String openTime, String closeTime, float placeSilence, float placeBright, String placeAddress, String placeCategory, String sellerTalk, String rateAverage){
        this.id = id;
        this.placeName = placeName;
        this.placeSeller = placeSeller;
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.placeSilence = placeSilence;
        this.placeBright = placeBright;
        this.placeAddress = placeAddress;
        this.placeCategory = placeCategory;
        this.sellerTalk = sellerTalk;
        this.rateAverage = rateAverage;
    }
}

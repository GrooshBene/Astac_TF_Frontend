package grooshbene.edcan.kr.todaysfeeling;

import java.util.List;

import retrofit.Call;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;

/**
 * Created by bene on 2016. 8. 7..
 */
public interface JSONService {
    @GET("/auth/facebook/token")
    List<User> fbToken(@Path("access_token") String accessToken);

    @FormUrlEncoded
    @POST("/auth/register")
    Call<User> sellerRegister(@Field("id") String loginId, @Field("password") String loginPassword);

    @FormUrlEncoded
    @POST("/auth/authenticate")
    Call<User> autoAuth(@Field("auth_token") String authToken);

    @FormUrlEncoded
    @POST("/place/add")
    Call<Place> placeAdd(@Field("sellerId") String sellerId, @Field("place_name") String placeName, @Field("place_address") String placeAddress, @Field("place_category") String placeCategory, @Field("seller_talk") String sellerTalk, @Field("time_open") String openingTime, @Field("time_close") String closingTime);

    @FormUrlEncoded
    @POST("/place/update")
    Call<Place> placeUpdate(@Field("place_id") String placeId);

    @FormUrlEncoded
    @POST("/review/write")
    Call<Place> reviewWrite(@Field("place_id") String placeId, @Field("writer_id") String writerId, @Field("writer_name") String writerName, @Field("review_content") String reviewContent, @Field("place_rate") String placeRate);

    @FormUrlEncoded
    @POST("/me/info")
    Call<User> myInfo(@Field("id") String userId);

    @FormUrlEncoded
    @POST("/me/review")
    Call<User> myReview(@Field("id") String userReview);
}

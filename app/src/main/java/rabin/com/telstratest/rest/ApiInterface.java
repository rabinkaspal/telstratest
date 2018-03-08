package rabin.com.telstratest.rest;

import rabin.com.telstratest.model.ItemResponse;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by DEXTER on 8/3/18.
 */

public interface ApiInterface {

    @GET("/")
    Call<ItemResponse> getItems();

}

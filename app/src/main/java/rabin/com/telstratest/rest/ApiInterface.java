package rabin.com.telstratest.rest;

import rabin.com.telstratest.model.ItemResponse;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by DEXTER on 8/3/18.
 */

public interface ApiInterface {

    @GET("/s/2iodh4vg0eortkl/facts.json")
    Call<ItemResponse> getItems();

}

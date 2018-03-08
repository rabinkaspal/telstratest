package rabin.com.telstratest.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by DEXTER on 8/3/18.
 */

public class ItemResponse {

    @SerializedName("title")
    private String title;
    @SerializedName("rows")
    private List<Item> rows;


    public ItemResponse(String title, List<Item> rows) {
        this.title = title;
        this.rows = rows;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Item> getRows() {
        return rows;
    }

    public void setRows(List<Item> rows) {
        this.rows = rows;
    }
}

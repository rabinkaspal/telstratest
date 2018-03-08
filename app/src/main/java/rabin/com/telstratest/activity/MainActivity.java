package rabin.com.telstratest.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

import rabin.com.telstratest.R;
import rabin.com.telstratest.adapter.ItemsAdapter;
import rabin.com.telstratest.model.Item;
import rabin.com.telstratest.model.ItemResponse;
import rabin.com.telstratest.rest.ApiClient;
import rabin.com.telstratest.rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    RecyclerView tlsListView;
    ApiInterface apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tlsListView = (RecyclerView) findViewById(R.id.tlsListView);
        tlsListView.setLayoutManager(new LinearLayoutManager(this));
        tlsListView.setHasFixedSize(true);

        apiService = ApiClient.getClient().create(ApiInterface.class);

        getRowData();

    }


    public void getRowData(){

        Call<ItemResponse> call = apiService.getItems();
        call.enqueue(new Callback<ItemResponse>() {
            @Override
            public void onResponse(Call<ItemResponse> call, Response<ItemResponse> response) {

                String title = response.body().getTitle();
                getSupportActionBar().setTitle(title);

                List<Item> items = response.body().getRows();
                tlsListView.setAdapter(new ItemsAdapter(getApplicationContext(), items));
            }

            @Override
            public void onFailure(Call<ItemResponse> call, Throwable t) {
                Log.e(TAG, "ERROR: "+ t.toString());
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

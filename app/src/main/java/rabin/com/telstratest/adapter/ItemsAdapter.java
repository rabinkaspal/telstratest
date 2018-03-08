package rabin.com.telstratest.adapter;

import android.content.ClipData;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import rabin.com.telstratest.R;
import rabin.com.telstratest.model.Item;

/**
 * Created by DEXTER on 8/3/18.
 */
public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ItemViewHolder> {

    private List<Item> items;
    private Context context;


    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView tlsItemTitle, tlsItemContent;
        ImageView tlsItemImage;


        public ItemViewHolder(View v) {
            super(v);
            tlsItemTitle = (TextView) v.findViewById(R.id.tlsItemTitle);
            tlsItemContent = (TextView) v.findViewById(R.id.tlsItemContent);
            tlsItemImage = (ImageView) v.findViewById(R.id.tlsItemImage);
        }
    }


    public ItemsAdapter(Context context, List<Item> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public ItemsAdapter.ItemViewHolder onCreateViewHolder(ViewGroup parent,int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tls_list_item, parent, false);
        return new ItemViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ItemViewHolder holder, final int position) {
        holder.tlsItemTitle.setText(items.get(position).getTitle());
        holder.tlsItemContent.setText(items.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
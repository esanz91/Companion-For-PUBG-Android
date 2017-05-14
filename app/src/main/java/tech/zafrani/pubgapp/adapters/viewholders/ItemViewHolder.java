package tech.zafrani.pubgapp.adapters.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import tech.zafrani.pubgapp.models.Item;


public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    public final static String IMAGE_URL_BASE= "https://github.com/Zsteven44/PUBG-Companion-Images/blob/master/images/";
    public final static String ARG_RAW = "?raw=true";
    public final static String EMPTY_FIELD = " - ";
    public final static String ARG_ITEM = ItemViewHolder.class.getSimpleName() + ".ARG_ITEM";
    public Item item;
    public ItemViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
    }

    public void bind(final Item item){};

    @Override
    public void onClick(View view) {

    }

}

package tech.zafrani.pubgapp.adapters;


import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import tech.zafrani.pubgapp.adapters.viewholders.BaseViewHolder;


public abstract class BaseRecyclerViewAdapterImpl<Model extends Serializable, ViewHolder extends BaseViewHolder<Model>>
        extends RecyclerView.Adapter<ViewHolder>
        implements RecyclerViewAdapter<Model>,
                   BaseViewHolder.Listener<Model>{

    @NonNull
    private final List<Model> models;


    public BaseRecyclerViewAdapterImpl() {
        this(new ArrayList<Model>());
    }

    public BaseRecyclerViewAdapterImpl(@NonNull final List<Model> models) {
        this.models = models;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder,
                                 final int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return this.models.size();
    }

    @Nullable
    @Override
    public Model get(final int position) {
        if (position < 0 || position >= this.models.size()) {
            return null;
        }
        return this.models.get(position);
    }


}
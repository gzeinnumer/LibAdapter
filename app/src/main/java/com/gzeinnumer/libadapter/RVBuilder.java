package com.gzeinnumer.libadapter;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

import java.util.List;

public class RVBuilder {
    private Context context;
    private BindViewHolder bindViewHolder;
    private List<String> list;
    private int emptyLayout = -1;
    private ViewBinding viewBinding;

    public RVBuilder(Context context, ViewBinding viewBinding) {
        this.viewBinding = viewBinding;
        this.context = context;
    }

    public RVBuilder setItems(List<String> list) {
        this.list = list;
        return  this;
    }

    public RVBuilder setCustomNoItem(int emptyLayout) {
        this.emptyLayout = emptyLayout;
        return this;
    }

    public RVBuilder bind(BindViewHolder bindViewHolder) {
        this.bindViewHolder = bindViewHolder;
        return this;
    }

    public <T extends RecyclerView.Adapter<RecyclerView.ViewHolder>> AdapterCreator build() {
        return new AdapterCreator(list, emptyLayout, viewBinding, new BindViewHolder() {
            @Override
            public void bind(AdapterCreator.ViewHolder holder, int position) {
                bindViewHolder.bind(holder, position);
            }
        });
    }
}

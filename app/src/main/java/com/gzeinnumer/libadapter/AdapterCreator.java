package com.gzeinnumer.libadapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

import com.gzeinnumer.libadapter.databinding.ItemRvBinding;

import java.util.List;

public class AdapterCreator extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final BindViewHolder bindViewHolder;
    private final List<String> list;
    private final int emptyLayout;
    private ViewBinding viewBinding;

    public AdapterCreator(List<String> list, int emptyLayout, ViewBinding viewBinding, BindViewHolder bindViewHolder) {
        this.list = list;
        this.emptyLayout = emptyLayout;
        this.viewBinding =viewBinding;
        this.bindViewHolder = bindViewHolder;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (list.size() == 0) {
            return new ViewHolderEmpty(LayoutInflater.from(parent.getContext()).inflate(emptyLayout == -1 ? R.layout.empty_item : emptyLayout, parent, false));
        } else {
            return new ViewHolder(ItemRvBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        //holder.itemView.setAnimation(AnimationUtils.loadAnimation(holder.itemView.getContext(), GblVariabel.anim));

        if (list.size() > 0)
            bindViewHolder.bind((ViewHolder) holder, position);
    }

    @Override
    public int getItemCount() {
        return list.size() > 0 ? list.size() : 1;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ItemRvBinding binding;

        public ViewHolder(@NonNull ItemRvBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }

    public static class ViewHolderEmpty extends RecyclerView.ViewHolder {
        public ViewHolderEmpty(@NonNull View itemView) {
            super(itemView);
        }
    }
}

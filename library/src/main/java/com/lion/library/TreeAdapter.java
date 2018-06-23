package com.lion.library;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public abstract class TreeAdapter extends RecyclerView.Adapter<TreeViewHolder> {
    private Context context;
    private SparseIntArray layoutResourceMap;
    private List<TreeNode> treeNodes;

    public TreeAdapter(Context context, SparseIntArray layoutResourceMap) {
        this.context = context;
        this.layoutResourceMap = layoutResourceMap;
        this.treeNodes = new ArrayList<>();
    }

    @NonNull
    @Override
    public TreeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TreeViewHolder(LayoutInflater.from(context).inflate(layoutResourceMap.get(viewType), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TreeViewHolder holder, int position) {
        bindViewHolder(holder, position, null);
    }

    @Override
    public void onBindViewHolder(@NonNull TreeViewHolder holder, int position, @NonNull List<Object> payloads) {
        bindViewHolder(holder, position, payloads);
    }

    @Override
    public int getItemCount() {
        return treeNodes.size();
    }

    @Override
    public int getItemViewType(int position) {
        return treeNodes.get(position).getViewType();
    }

    private void bindViewHolder(final TreeViewHolder holder, int position, List<Object> payloads) {
        holder.getTreeItemView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                int i = position + 1;
                if (i < treeNodes.size()) {
                    if (getItemViewType(i) <= getItemViewType(position)) {
                        return;
                    }
                    if (treeNodes.get(i).isVisible()) {
                        collapse(position);
                    } else {
                        expand(position);
                    }
                }
            }
        });
        holder.setItemVisibility(treeNodes.get(position).isVisible());
        bind(holder, treeNodes.get(position), getItemViewType(position), payloads);
    }

    public abstract void bind(TreeViewHolder treeViewHolder, TreeNode treeNode, int viewType, List<Object> payloads);

    public void setData(List<TreeNode> treeNodes) {
        this.treeNodes = treeNodes;
    }

    public void bindRecyclerView(RecyclerView recyclerView) {
        recyclerView.setItemAnimator(null);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(this);
    }

    public void bindRecyclerView(RecyclerView recyclerView, RecyclerView.LayoutManager layoutManager) {
        recyclerView.setItemAnimator(null);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(this);
    }

    public void expand(int position) {
        changeVisible(position, true);
        notifyDataSetChanged();
    }

    public void collapse(int position) {
        changeVisible(position, false);
        notifyDataSetChanged();
    }

    private void changeVisible(int position, boolean visible) {
        int i = position + 1;
        while (i < treeNodes.size()) {
            if (getItemViewType(i) <= getItemViewType(position)) {
                break;
            }
            treeNodes.get(i).setVisible(visible);
            i++;
        }
    }
}

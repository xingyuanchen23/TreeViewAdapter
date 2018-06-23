package com.lion.library;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class TreeViewHolder extends RecyclerView.ViewHolder {
    private SparseArray<View> sparseArray;
    private View treeItemView;

    public TreeViewHolder(View treeItemView) {
        super(treeItemView);
        this.treeItemView = treeItemView;
        this.sparseArray = new SparseArray<>();
    }

    public View getTreeItemView() {
        return treeItemView;
    }

    public View getView(int id) {
        View view = sparseArray.get(id);
        if (view == null) {
            view = treeItemView.findViewById(id);
            sparseArray.put(id, view);
        }
        return view;
    }

    public TreeViewHolder setText(int id, String text) {
        TextView textView = (TextView) getView(id);
        if (text == null) {
            textView.setText("");
        } else {
            textView.setText(text);
        }
        return this;
    }

    public TreeViewHolder appendText(int id, String text) {
        TextView textView = (TextView) getView(id);
        if (text != null) {
            textView.setText((textView.getText() + text));
        }
        return this;
    }

    public TreeViewHolder setTextColor(int id, int color) {
        ((TextView) getView(id)).setTextColor(color);
        return this;
    }

    public TreeViewHolder setImageResource(int id, int resId) {
        ((ImageView) getView(id)).setImageResource(resId);
        return this;
    }

    public TreeViewHolder setEnabled(int id, boolean enable) {
        getView(id).setEnabled(enable);
        return this;
    }

    public TreeViewHolder setVisibility(int id, int visibility) {
        getView(id).setVisibility(visibility);
        return this;
    }

    public TreeViewHolder setBackgroundResource(int id, int backgroundResource) {
        getView(id).setBackgroundResource(backgroundResource);
        return this;
    }

    public TreeViewHolder setOnclickListener(int id, View.OnClickListener onclickListener) {
        getView(id).setOnClickListener(onclickListener);
        return this;
    }

    public void setItemVisibility(boolean isVisible) {
        ViewGroup.LayoutParams layoutParams = itemView.getLayoutParams();
        if (isVisible) {
            layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
            layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT;
            itemView.setVisibility(View.VISIBLE);
        } else {
            itemView.setVisibility(View.GONE);
            layoutParams.height = 0;
            layoutParams.width = 0;
        }
        itemView.setLayoutParams(layoutParams);
    }
}

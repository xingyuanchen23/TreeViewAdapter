package com.lion.treeview.entity;

import com.lion.library.TreeNode;

public class ThirdTreeNode extends TreeNode {
    private String text;

    public ThirdTreeNode(int viewType, boolean visible, String text) {
        super(viewType, visible);
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

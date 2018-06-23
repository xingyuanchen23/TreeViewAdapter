package com.lion.treeview.entity;

import com.lion.library.TreeNode;

public class FirstTreeNode extends TreeNode {
    private String text;

    public FirstTreeNode(int type, boolean visible, String text) {
        super(type, visible);
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

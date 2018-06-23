package com.lion.library;

public class TreeNode {
    private int viewType;
    private boolean visible;

    public TreeNode(int viewType, boolean visible) {
        this.viewType = viewType;
        this.visible = visible;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}

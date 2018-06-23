package com.lion.treeview.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.SparseIntArray;

import com.lion.library.TreeAdapter;
import com.lion.library.TreeNode;
import com.lion.library.TreeViewHolder;
import com.lion.treeview.R;
import com.lion.treeview.entity.FirstTreeNode;
import com.lion.treeview.entity.SecondTreeNode;
import com.lion.treeview.entity.ThirdTreeNode;

import java.util.ArrayList;
import java.util.List;

public class TreeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tree);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        List<TreeNode> treeNodes = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            double random = Math.random();
            if (random < 0.3) {
                treeNodes.add(new FirstTreeNode(1, true, "1"));
            } else if (random < 0.6) {
                treeNodes.add(new SecondTreeNode(2, true, "2"));
            } else {
                treeNodes.add(new ThirdTreeNode(3, true, "3"));
            }
        }

        SparseIntArray layoutResourceMap = new SparseIntArray();
        layoutResourceMap.put(1, R.layout.item_tree_first);
        layoutResourceMap.put(2, R.layout.item_tree_second);
        layoutResourceMap.put(3, R.layout.item_tree_third);

        TreeAdapter treeAdapter = new TreeAdapter(this, layoutResourceMap) {
            @Override
            public void bind(TreeViewHolder treeViewHolder, TreeNode treeNode, int viewType, List<Object> payloads) {
                switch (viewType) {
                    case 1:
                        FirstTreeNode firstTreeNode = (FirstTreeNode) treeNode;
                        treeViewHolder.setText(R.id.tv1, firstTreeNode.getText());
                        break;
                    case 2:
                        SecondTreeNode secondTreeNode = (SecondTreeNode) treeNode;
                        treeViewHolder.setText(R.id.tv2, secondTreeNode.getText());
                        break;
                    case 3:
                        ThirdTreeNode thirdTreeNode = (ThirdTreeNode) treeNode;
                        treeViewHolder.setText(R.id.tv3, thirdTreeNode.getText());
                        break;
                }
            }
        };
        treeAdapter.setData(treeNodes);
        treeAdapter.bindRecyclerView(recyclerView);
    }
}

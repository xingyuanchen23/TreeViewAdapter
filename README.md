**What is TreeViewAdapter?**

TreeViewAdapter is a powerful encapsulated adapter for recyclerView to represent multi-level list in Android.

**Why it is powerful?**

You can represent multi-level list by just ONE recyclerView with TreeViewAdapter.

**How can TreeView do that?**

TreeViewAdapter expand and collapse nodes by their ViewType. 
You may refer to getItemViewType(int) method in RecyclerView.Adapter class. 

**How to use TreeViewAdapter?**

You just need 3 steps to create a multi-level list.

1. Create a List and add nodes into it.
2. Create a layoutResourceMap to map type to layout file.
3. Create a treeAdapter, bind it to a recyclerView and set data source.

Here is a demo:

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

FirstTreeNode, SecondTreeNode and ThirdTreeNode are all subclasses of TreeNode. 
You should notice that the only data class treeAdapter accepting is TreeNode. 

**Anything more?**

If you wanna customize treeNode, which probably you have to, please note that the field names 'viewType' and 'visible'
are not supposed to be used since they have been used by TreeNode.

**Enjoy yourself!**

    implementation 'com.github.LionXingyuanChen:TreeView:v1.0.0'
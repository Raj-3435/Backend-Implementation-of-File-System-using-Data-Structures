package com.uqedd.filesystem;

import java.util.Map;
import java.util.HashMap;

class TreeNode {
    String name;
    boolean isFile;
    Map<String, TreeNode> children;
    TreeNode parent;

    TreeNode(String name, boolean isFile, TreeNode parent) {
        this.name = name;
        this.isFile = isFile;
        this.parent = parent;

        if (!isFile) {
            this.children = new HashMap<>();
        }
    }
}
package com.uqedd.filesystem;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class TrieNode {
    Map<Character, TrieNode> children;
    boolean isEnd;
    List<TreeNode> nodes;

    TrieNode() {
        this.children = new HashMap<>();
        this.isEnd = false;
        this.nodes = new ArrayList<>();
    }
}
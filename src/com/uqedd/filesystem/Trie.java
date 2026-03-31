package com.uqedd.filesystem;

import java.util.ArrayList;
import java.util.List;

class Trie {
    TrieNode root;
    Trie() {
        this.root = new TrieNode();
    }
    
    void insert(String word, TreeNode node) {
        TrieNode curr = root;

        for (char c : word.toCharArray()) {

            if (!curr.children.containsKey(c)) {
                curr.children.put(c, new TrieNode());
            }

            curr = curr.children.get(c);
        }

        curr.isEnd = true;
        curr.nodes.add(node);
    }
    List<TreeNode> search(String prefix){
    	TrieNode curr = root;

    	for (char c : prefix.toCharArray()) {
    	    if (!curr.children.containsKey(c)) {
    	        return new ArrayList<>(); // no match
    	    }
    	    curr = curr.children.get(c);
    	}
    	List<TreeNode> result = new ArrayList<>();
        dfs(curr, result);
        return result;
    	
    }
    void dfs(TrieNode node, List<TreeNode> result) {
    	if (node.isEnd) {
    	    result.addAll(node.nodes);
    	}

    	for (TrieNode child : node.children.values()) {
    	    dfs(child, result);
    	}
    }
}
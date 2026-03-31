package com.uqedd.filesystem;

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
}
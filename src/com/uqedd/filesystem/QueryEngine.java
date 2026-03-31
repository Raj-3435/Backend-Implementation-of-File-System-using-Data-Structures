package com.uqedd.filesystem;

import java.util.*;

class QueryEngine {

    FileSystem fs;

    QueryEngine(FileSystem fs) {
        this.fs = fs;
    }
    List<String> search(String query) {

        if (query.equals("*")) {
            return dfsSearch(fs.root);
        }

        else if (query.contains(".")) {
            return exactSearch(query);
        }

        else {
            return trieSearch(query);
        }
    }
    List<String> trieSearch(String prefix) {
        return fs.search(prefix);
    }
    List<String> dfsSearch(TreeNode node) {
        List<String> result = new ArrayList<>();
        dfsHelper(node, result);
        return result;
    }
    void dfsHelper(TreeNode node, List<String> result) {

        if (node != null && node.parent != null) {
            result.add(fs.getFullPath(node));
        }

        if (node.children != null) {
            for (TreeNode child : node.children.values()) {
                dfsHelper(child, result);
            }
        }
    }
    List<String> exactSearch(String name) {
        List<String> all = dfsSearch(fs.root);
        List<String> result = new ArrayList<>();

        for (String path : all) {
            if (path.endsWith("/" + name)) {
                result.add(path);
            }
        }

        return result;
    } 
}
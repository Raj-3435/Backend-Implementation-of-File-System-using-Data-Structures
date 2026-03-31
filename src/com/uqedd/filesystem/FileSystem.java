package com.uqedd.filesystem;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class FileSystem {
    TreeNode root;
    TreeNode current;

    FileSystem() {
        // initialize root
    	this.root = new TreeNode("/", false, null);
    	// set current = root
        this.current = root;
    }
    
    void mkdir(String name) {
    	if (current.isFile) {
    	    System.out.println("Cannot create directory inside a file");
    	    return;
    	} if (current.children.containsKey(name)) {
            System.out.println("Directory already exists");
        } else {
            TreeNode newNode = new TreeNode(name, false, current);
            current.children.put(name, newNode);
        }
    }
    
    List<String> ls() {
        if (current.isFile) {
            List<String> fileList = new ArrayList<>();
            fileList.add(current.name);
            return fileList;
        }

        List<String> list = new ArrayList<>(current.children.keySet());
        Collections.sort(list);
        return list;
    }
}

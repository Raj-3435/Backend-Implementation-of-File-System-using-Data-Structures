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
    void cd(String path) {
    	TreeNode temp;

    	if (path.startsWith("/")) {
    	    temp = root;
    	} else {
    	    temp = current;
    	}
    	String[] parts = path.split("/");
    	for (String part : parts) {
    		if (part.equals("")) continue;
    		else if (part.equals("..")) {
    		    if (temp.parent != null) {
    		        temp = temp.parent;
    		    }
    		}
    		else {
    		    if (!temp.children.containsKey(part)) {
    		        System.out.println("No such directory");
    		        return;
    		    }

    		    TreeNode next = temp.children.get(part);

    		    if (next.isFile) {
    		        System.out.println("Cannot cd into file");
    		        return;
    		    }

    		    temp = next;
    		}
    	}
    	current = temp;
    }
    void delete(String name, boolean force) {
        if (current.isFile) {
            System.out.println("Cannot delete inside a file");
            return;
        }

        if (!current.children.containsKey(name)) {
            System.out.println("No such file or directory");
            return;
        }

        TreeNode node = current.children.get(name);

        if (!node.isFile && !node.children.isEmpty() && !force) {
            System.out.println("Directory is not empty. Use force delete");
            return;
        }

        current.children.remove(name);
    }
    void mkdirPath(String path) {
        TreeNode temp;

        // Step 1: Decide starting point
        if (path.startsWith("/")) {
            temp = root;
        } else {
            temp = current;
        }

        // Step 2: Split path
        String[] parts = path.split("/");

        // Step 3: Traverse till second-last
        for (int i = 0; i < parts.length - 1; i++) {
            String part = parts[i];

            if (part.equals("")) continue;

            // Check existence
            if (!temp.children.containsKey(part)) {
                System.out.println("Invalid path");
                return;
            }

            TreeNode next = temp.children.get(part);

            // Check not file
            if (next.isFile) {
                System.out.println("Path contains file");
                return;
            }

            temp = next;
        }

        // Step 4: Handle last part
        String last = parts[parts.length - 1];

        if (last.equals("")) return; // handles trailing '/'

        if (temp.children.containsKey(last)) {
            System.out.println("Directory already exists");
            return;
        }

        TreeNode newNode = new TreeNode(last, false, temp);
        temp.children.put(last, newNode);
    }
    
}

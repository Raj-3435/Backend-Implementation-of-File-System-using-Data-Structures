package com.uqedd.filesystem;

public class Main {
    public static void main(String[] args) {
        FileSystem fs = new FileSystem();

        // Basic mkdir
        fs.mkdir("a");
        fs.mkdir("b");

        // Check root contents
        System.out.println("Root: " + fs.ls()); // [a, b]

        // Navigate into a
        fs.cd("a");
        fs.mkdir("x");

        System.out.println("Inside a: " + fs.ls()); // [x]

        // Go back to root
        fs.cd("/");

        // Multi-level mkdir
        fs.mkdirPath("a/x/y"); // should work
        fs.mkdirPath("a/z/w"); // should fail

        // Navigate and check
        fs.cd("a/x");
        System.out.println("Inside a/x: " + fs.ls()); // [y]

        // Test delete
        fs.delete("y", false); // should work
        System.out.println("After delete: " + fs.ls()); // []

        // Create nested and test force delete
        fs.mkdir("c");
        fs.cd("c");
        fs.mkdir("d");
        fs.cd("..");

        fs.delete("c", false); // should fail
        fs.delete("c", true);  // should work

        System.out.println("Final: " + fs.ls());
        fs.cd("/");
        System.out.println("Final: " + fs.ls());
    }
}
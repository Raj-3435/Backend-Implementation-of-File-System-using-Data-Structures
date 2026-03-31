package com.uqedd.filesystem;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        FileSystem fs = new FileSystem();
        QueryEngine qe = new QueryEngine(fs);

        System.out.println("🚀 UQEDD File System Started (type 'exit' to quit)");

        while (true) {
            System.out.print("> ");
            String input = sc.nextLine();

            if (input.equals("exit")) break;

            String[] parts = input.split(" ");
            String command = parts[0];

            try {
                switch (command) {

	                case "mkdir":
	                    if (parts[1].contains("/")) {
	                        fs.mkdirPath(parts[1]);
	                    } else {
	                        fs.mkdir(parts[1]);
	                    }
	                    break;
                    
	                case "mkdirp":
                        fs.mkdirPath(parts[1]);
                        break;

                    case "ls":
                        System.out.println(fs.ls());
                        break;

                    case "cd":
                        fs.cd(parts[1]);
                        break;

                    case "delete":
                        if (parts.length > 2 && parts[2].equals("-f")) {
                            fs.delete(parts[1], true);
                        } else {
                            fs.delete(parts[1], false);
                        }
                        break;

                    case "search":
                        System.out.println(qe.search(parts[1]));
                        break;

                    default:
                        System.out.println("Unknown command");
                }

            } catch (Exception e) {
                System.out.println("Invalid command usage");
            }
        }

        sc.close();
        System.out.println("👋 Exiting...");
    }
}
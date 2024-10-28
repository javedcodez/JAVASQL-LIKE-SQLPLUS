package com.core_java; // add you package  

import java.io.Console;

public class JavaSql {
    static {
        System.out.println("JAVA*SQL*Plus: Release 0.0.0.0.1 - Production on Mon Oct 28 10:49:21 2024");
        System.out.println("Version 0.0.0.0.1");
        System.out.println("\nCopyright (c) 1982, 2019, Oracle. All rights reserved.");
    }

    public static void main(String[] args) {
        Console console = System.console();

        if (console != null) {
            boolean isAuthenticated = false;
            int attemptCount = 0; // Counter for attempts

            // Initial authentication loop for the fixed username and password
            while (!isAuthenticated && attemptCount < 3) {
                String username = console.readLine("Enter user-name: ");
                char[] passwordArray = console.readPassword("Enter password: "); // Password will be hidden
                String password = new String(passwordArray);

                // Clear password array for security
                java.util.Arrays.fill(passwordArray, ' ');

                // Check predefined username and password
                if ("javed".equals(username) && "shaikh".equals(password)) {
                    isAuthenticated = true;

                    // Display connection message if credentials are correct
                    System.out.println("\nLast Successful login time: Mon Oct 28 2024 10:49:34 +05:30");
                    System.out.println("\nConnected to:");
                    System.out.println("Oracle Database 19c Enterprise Edition Release 19.0.0.0.0 - Production");
                    System.out.println("Version 19.3.0.0.0, " + username + "!");
                } else {
                    attemptCount++;
                    System.out.println("Error: ORA-01017:");
                    System.out.println("Invalid username/password; logon denied\n");
                    System.out.println("Attempts left: " + (3 - attemptCount)); // Display remaining attempts
                }
            }

            // Exit if authentication fails after 3 attempts
            if (attemptCount >= 3) {
                System.out.println("Maximum attempts reached. Exiting the program.");
                return; // Exit the program
            }

            // Command prompt loop
            String command;
            System.out.println(); // Add a newline for better formatting
            do {
                command = console.readLine("javasql> ");

                if (command.equalsIgnoreCase("conn") || command.equalsIgnoreCase("connect")) {
                    // Prompt for username and password for the connection
                    String connUsername = console.readLine("Enter user-name for connection: ");
                    char[] connPasswordArray = console.readPassword("Enter password for connection: "); // Password will be hidden
                    String connPassword = new String(connPasswordArray);

                    // Clear password array for security
                    java.util.Arrays.fill(connPasswordArray, ' ');

                    // Check connection credentials (can add more logic here if needed)
                    if ("javed".equals(connUsername) && "shaikh".equals(connPassword)) {
                        System.out.println("Connected successfully as " + connUsername + "!");
                    } else {
                        System.out.println("Error: ORA-01017:");
                        System.out.println("Invalid username/password for connection; logon denied");
                    }
                } else if (!command.equalsIgnoreCase("exit")) {
                    System.out.println("Command not recognized: " + command);
                }
            } while (!command.equalsIgnoreCase("exit"));

            System.out.println("Exiting javasql. Goodbye!");
        } else {
            System.out.println("Console not available. Please run this program in a terminal.");
        }
    }
}

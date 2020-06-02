package de.hfu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    public static void main(String[] args) {
           printInputsUppercase();
    }

    /**
     * Takes in the arguments from the command line and prints them in uppercase.
     * The function loops as long as the user isn't typing "stop"
     */
    public static void printInputsUppercase() {
        BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
        String str = "";

        System.out.println("Enter lines of text.");
        System.out.println("Enter 'stop' to quit.");

        do {
            try {
                str = obj.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(str.toUpperCase());
        } while (!str.equals("stop"));

    }
}

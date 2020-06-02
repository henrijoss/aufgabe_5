package de.hfu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws IOException {
            // create a BufferedReader using System.in
            BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
            String str;

            System.out.println("Enter lines of text.");
            System.out.println("Enter 'stop' to quit.");
            do {
                str = obj.readLine();
                System.out.println(str.toUpperCase());
            } while (!str.equals("stop"));
    }
}

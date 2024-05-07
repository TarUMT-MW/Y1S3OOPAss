/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pointrewardsystem;

import java.util.Scanner;

public class PointRewardSystem {
    
    
    
    public static void main(String[] args) {
        
        boolean success = false;
        int choice;
        
        Scanner scanner = new Scanner(System.in);
        
        
        DataStorage ds = new DataStorage();
        MemAccount acc = new MemAccount();
        
        
        do {
            //readFile into program first
            ds.readFile();
            displayHomepage();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
                switch (choice) {
                    case 1:
                        acc.login();
                        break;
                    case 2:
                        acc.register();
                        //writeFile
                        break;
                    case 3:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice! Please enter a valid option.");
                        break;
                }
        } while (!success);
    }
    
    //homepage
    public static void displayHomepage() {
        System.out.println("--------------------------");
        System.out.println("[1] Login");
        System.out.println("[2] Register");
        System.out.println("[3] Exit");
        System.out.print("Please choose: ");
    }
}
        



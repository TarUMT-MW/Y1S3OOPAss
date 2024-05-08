/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pointrewardsystem;

import java.util.Scanner;

public class PointRewardSystem {
    
    
    
    public static void main(String[] args) {
        
        boolean success = false;
        int choice;
        
        Terms terms = new Terms();
        MemAccount acc = new MemAccount();
        
        DataStorage ds = new DataStorage();
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("WELCOME AND ENJOY OUR SERVICES");
        
        do {
            displayHomepage();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
                switch (choice) {
                    case 1:
                        acc.login(); 
                        break;
                    case 2:
                        acc.register();
                        break;
                    case 3:
                        terms.displayTerms();
                        break;
                    case 4:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice! Please enter a valid option.");
                        break;
                }
        } while (!success);
    
        System.out.println("THANK YOU FOR USING OUR SERVICES");
    }
    
    //homepage
    public static void displayHomepage() {
        System.out.println("--------------------------");
        System.out.println("[1] Login");
        System.out.println("[2] Register");
        System.out.println("[3] Display Terms");
        System.out.println("[4] Exit");
        System.out.print("Please choose: ");
    }
    public static void displayUserpage(){
        System.out.println("=--------------------------=");
        System.out.println("[1] Point Balance");
        System.out.println("[2] Redeem Coupon");
        System.out.println("[3] Display Terms");
        System.out.println("[3] Exit");
        System.out.print("Please choose: ");
    }
}
        



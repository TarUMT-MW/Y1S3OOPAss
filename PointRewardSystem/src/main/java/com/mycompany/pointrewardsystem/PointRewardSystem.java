/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pointrewardsystem;

import java.util.Scanner;

public class PointRewardSystem {

    private static Terms terms = new Terms();
    private static DataStorage ds = new DataStorage();    
    private static Scanner scanner = new Scanner(System.in);
    
    
    public static void main(String[] args) {
        boolean success = false;
        char choice;
        System.out.println("\nWELCOME AND ENJOY OUR SERVICES");
        
        ds.readFile();
        do {
            displayHomepage();
           
            choice = scanner.next().charAt(0);
            scanner.nextLine(); // Consume newline character
            choice = Character.toLowerCase(choice);
            
                switch (choice) {
                    case 'a':
                        int currentMem = MemAccount.login(); 
                        if (currentMem != -1){
                            selectionUserpage(currentMem);
                        }
                        break;
                    case 'b':
                        MemAccount.register();
                        break;
                    case 'c':
                        MemAccount.forgotPass();
                        break;
                    case 'd':
                        Terms.displayTerms();
                        break;
                    case 'e':
                        System.out.println("\nEXITING...\n");
                        success = true;
                        break;
                    default:
                        System.out.println("Invalid choice! Please enter a valid option.");
                        break;
                }
        } while (!success);
    
        System.out.println("THANK YOU FOR USING OUR SERVICES");
    }
    
    //homepage
    public static void displayHomepage() {
        System.out.println("------------------------------");
        System.out.println("[A] Login");
        System.out.println("[B] Register");
        System.out.println("[C] Forgot Password");
        System.out.println("[D] Display Terms");
        System.out.println("[E] Exit Program");
        System.out.print("Please pick a service: ");
    }
    public static void displayUserpage(){
        System.out.println("=------------------------------=");
        System.out.println("[A] Earn Points");
        System.out.println("[B] Redeem Coupon");
        System.out.println("[C] Display Terms");
        System.out.println("[D] Back");
        System.out.println("[E] Exit Program");
        System.out.print("Please pick a service: ");
    }
    
    public static void selectionUserpage(int currentMem){
        boolean success = false;
        char choice;
        do {
            
            displayUserpage();
           
            choice = scanner.next().charAt(0);
            scanner.nextLine(); // Consume newline character
            choice = Character.toLowerCase(choice);
            
                switch (choice) {
                    case 'a':
                        EarnPoints earnPoints = new EarnPoints();
                        earnPoints.earning(currentMem);
                        break;
                    case 'b':
                        
                        //redeem
                        break;
                    case 'c':
                        terms.displayTerms();
                        break;
                    case 'd':
                        System.out.println("\nRETURNING...\n");
                        success = true;
                        break;
                    case 'e':
                        System.out.println("\nEXITING...\n");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice! Please enter a valid option.");
                        break;
                }
            ds.writeFile();
        } while (!success);
    }
}
        



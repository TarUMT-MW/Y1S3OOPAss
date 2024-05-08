/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pointrewardsystem;

import java.util.Scanner;

public class Terms {
  
    private static int choice;
    public static void displayTerms(){
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\n**************************");
        System.out.printf("%16s","TERMS\n");
        System.out.println("**************************");
        
        do{
            System.out.println("--------------------------");
            System.out.println("[1] Back");
            System.out.println("[2] Exit Program");
            System.out.print("Please Choose: ");
            choice = scanner.nextInt(); //1 to return 2 to exit
            switch (choice) {
                case 1:
                    System.out.println("RETURNING...");
                    break;
                case 2:
                    System.out.println("------------------------------------");
                    System.out.printf("%35s","THANK YOU FOR USING OUR SERVICES\n");
                    System.out.println("------------------------------------");
                    System.exit(0);
                default:
                    choice = 0;
                    System.out.println("Invalid choice! Please enter a valid option.");
                    break;
            }
        } while (choice == 0);
        
    }
    
}

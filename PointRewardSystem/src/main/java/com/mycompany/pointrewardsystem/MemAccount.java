/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pointrewardsystem;

import java.util.Scanner;
import java.util.ArrayList;


public class MemAccount {
    
    
    private final Scanner scanner = new Scanner(System.in);
    boolean success = false;
    int choice;
    
    DataStorage ds = new DataStorage();
    ArrayList<Member> members = ds.getMembers();
    
    
    //Register
    //Login
    public void login() {
        ds.readFile();
        do {
            System.out.print("Enter customer membership ID number (press 0 to go back): ");
            String memID = scanner.nextLine();

            if (memID.equals("0")) {
                return; // Exit login method
            }
	
            boolean validID = isValidID(memID);
            boolean found = false;
            if (validID) {

                for (Member member : members) {

                    if (member.getMemID().equals(memID)) {
                        System.out.print("Enter password: ");
                        String password = scanner.nextLine();
                        found = true;

                        if (member.getPassword().equalsIgnoreCase(password)) {
                            System.out.println("Log in successful!\n");
                            System.out.println("\n=--------------------------=");
                            System.out.println("Welcome " + member.getName() + ".");
                            success = true;
                        } else {System.out.println("Invalid password!");}
                    }
                }

            } else {
                System.out.println("Membership ID should only be 6 digits!");
            }
            if (!found) {
                System.out.println("Invalid membership ID number!");
            }
	} while (!success);
        
    }
    
    public void register() {
        ds.readFile();
        int check = 0;

        System.out.print("Enter customer name (press 0 to go back): ");
        String newName = scanner.nextLine();
        if (newName.equals("0")) {
            return; // Exit login method
        }

        System.out.print("Enter customer address: ");
        String newAddress = scanner.nextLine();
        do {
            System.out.print("Enter customer phone number: ");
            String newPhoneNo = scanner.nextLine();
            boolean validPhone = isValidPhoneNo(newPhoneNo);
            if (validPhone) {
                    do {
            System.out.print("Enter customer IC number: ");
            String newIcNo = scanner.nextLine();
            boolean validIC = isValidIC(newIcNo);
            if (validIC) {

                System.out.print("Enter customer password: ");
                String newPassword = scanner.nextLine();

                for (Member member : members) {

                        if (member.getIcNo().equals(newIcNo)) {
                                System.out.println("Member already exists!");
                                check = -1;

                        } else {
                                Member newMember = new Member(newName, newAddress, newPhoneNo, newIcNo, newPassword);
                                members.add(newMember);
                                if (newMember != null) {
                                        System.out.println();
                                        System.out.println("Register successful!");
                                        System.out.println("Member ID: " + newMember.getMemID() + "\n");
                                        check = 0;
                                }
                                break;
                        }
                }
            } else {
                    System.out.println("Invalid IC number! Please try again.");
                    check = -1;
            }
                    } while (check == -1);
            } else {
                    System.out.println("Invalid phone number! Please try again.");
                    check = -1;
            }
        } while (check == -1);
        //Write into file
        ds.writeFile();
    }
    
    
    //VALIDATIONS FOR MEM ACCOUNT
    public static boolean isValidID(String memID) {
            if (memID.length() != 6) {
                    return false;
            }

            for (int i = 0; i < 6; i++) {
                    if (!Character.isDigit(memID.charAt(i))) {
                            return false;
                    }
            }

            return true;
    }
    
    public static boolean isValidIC(String icNumber) {
        // Check if the input is exactly 12 characters long
        if(icNumber.length() != 12) {
            return false;
        }
        
        // Check if the first 6 characters are digits
        for(int i = 0; i < 6; i++) {
            if(!Character.isDigit(icNumber.charAt(i))) {
                return false;
            }
        }
        
        // Check if the seventh character is either 0 or 1
        char seventhChar = icNumber.charAt(6);
        if(seventhChar != '0' && seventhChar != '1') {
            return false;
        }
        
        // Check if the remaining characters are digits
        for(int i = 7; i < 12; i++) {
            if(!Character.isDigit(icNumber.charAt(i))) {
                return false;
            }
        }
        
        // If all conditions are met, return true
        return true;
    }
    
    public static boolean isValidPhoneNo(String phoneNumber) {
        // Check if the phone number is exactly 10 or 11 characters long
        if(phoneNumber.length() != 10 && phoneNumber.length() != 11) {
            return false;
        }
        
        // Check if the phone number contains only digits
        for(int i = 0; i < phoneNumber.length(); i++) {
            if(!Character.isDigit(phoneNumber.charAt(i))) {
                return false;
            }
        }
        
        // Check if the phone number starts with a valid prefix
        String[] validPrefixes = {"010","011", "012", "013", "014", "015", "016", "017", "018", "019"};
        boolean isValidPrefix = false;
        for(String prefix : validPrefixes) {
            if(phoneNumber.startsWith(prefix)) {
                isValidPrefix = true;
                break;
            }
        }
        if(!isValidPrefix) {
            return false;
        }
        
        // If all conditions are met, return true
        return true;
    }
}

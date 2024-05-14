/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pointrewardsystem;

import java.util.Scanner;
import java.util.ArrayList;

public class MemAccount {

    private static Scanner scan = new Scanner(System.in);
    private static boolean success = false;
    int choice;

    private static DataStorage ds = new DataStorage();
    private static Member memberData = new Member();
    private static ArrayList<Member> members = ds.getMembers();

    //Register
    //Login
    public static int login() {
        int login = -1;

        do {
            System.out.print("Enter customer membership ID number (press 0 to go back): ");
            String memID = scan.nextLine();

            if (memID.equals("0")) {
                success = true;
                //login = false;
            } else {
                boolean validID = isValidID(memID); //check valid ID format
                boolean found = false;
                if (validID) {
                    int i = 0;
                    for (Member member : members) {
                        if (member.getMemID().equals(memID)) {
                            System.out.print("Enter password: ");
                            String password = scan.nextLine();
                            found = true;

                            if (member.getPassword().equals(password)) {
                                System.out.println("Log in successful!\n");
                                System.out.println("\n=------------------------------=");
                                System.out.println("Welcome " + member.getName() + ".");
                                System.out.println("Current Point Balance: "
                                        + member.getPoints().currentPoints + ".");
                                success = true;
                                login = i;
                                break;
                            } else {
                                System.out.println("Invalid password!");
                            }
                        }
                        i++;
                    }
                    if (!found) {
                        System.out.println("Invalid membership ID number!");
                    }
                } else {
                    System.out.println("Membership ID should be 6 digits!");
                }
            }
        } while (!success);

        return login;
    }

    public static void register() {
        int check = 0;

        System.out.print("Enter customer name (press 0 to go back): ");
        String newName = scan.nextLine();

        if (newName.equals("0")) {
            return; // Exit login method
        }

        System.out.print("Enter customer address: ");
        String newAddress = scan.nextLine();

        do {
            System.out.print("Enter customer phone number: ");
            String newPhoneNo = scan.nextLine();
            boolean validPhone = isValidPhoneNo(newPhoneNo);
            if (validPhone) {
                do {
                    System.out.print("Enter customer IC number: ");
                    String newIcNo = scan.nextLine();
                    boolean validIC = isValidIC(newIcNo);
                    if (validIC) {

                        System.out.print("Enter customer password: ");
                        String newPassword = scan.nextLine();

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
        ds.writeFile();
    }
    
    public static void forgotPass(){
        boolean loop = true, found = true, samePass;
        
        do{
            System.out.print("Enter customer name (press 0 to go back): ");
            String name = scan.nextLine();
            if (name.equals("0")) {
                return; // Exit login method
            }
            System.out.print("Enter customer IC number: ");
            String icNo = scan.nextLine();
            for (Member member : members){
                if (name.equals(member.getName()) && icNo.equals(member.getIcNo())){
                    do{
                        
                        System.out.print("Enter new customer password: ");
                        String newPassword = scan.nextLine();
                        System.out.print("Confirm password: ");
                        String confirmPass = scan.nextLine();
                        if (newPassword.equals(confirmPass)){
                            member.setPassword(newPassword);
                            System.out.println(name + " your password has been successfully changed.\n");
                            samePass = true;
                            found = true;
                            loop = false;
                            ds.writeFile();
                        } else {
                            System.out.println("Password not same. Please confirm it's correct.");
                            samePass = false;
                        }
                        
                    } while (!samePass);
                } else {found = false;}
            }            
            if (!found){
                System.out.println("Customer name or IC number is incorrect. Please Try Again.");
            }
        } while (loop);
  
    }

    //VALIDATIONS FOR MEM ACCOUNT
    public static boolean isValidID(String memID) {
        if (memID.length() != 6) {
            return false;
        } else {
            for (int i = 0; i < 6; i++) {
                if (!Character.isDigit(memID.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isValidIC(String icNumber) {
        // Check if the input is exactly 12 characters long
        if (icNumber.length() != 12) {
            return false;
        }

        // Check if the first 6 characters are digits
        for (int i = 0; i < 6; i++) {
            if (!Character.isDigit(icNumber.charAt(i))) {
                return false;
            }
        }

        // Check if the seventh character is either 0 or 1
        char seventhChar = icNumber.charAt(6);
        if (seventhChar != '0' && seventhChar != '1') {
            return false;
        }

        // Check if the remaining characters are digits
        for (int i = 7; i < 12; i++) {
            if (!Character.isDigit(icNumber.charAt(i))) {
                return false;
            }
        }

        // If all conditions are met, return true
        return true;
    }

    public static boolean isValidPhoneNo(String phoneNumber) {
        // Check if the phone number is exactly 10 or 11 characters long
        if (phoneNumber.length() != 10 && phoneNumber.length() != 11) {
            return false;
        }

        // Check if the phone number contains only digits
        for (int i = 0; i < phoneNumber.length(); i++) {
            if (!Character.isDigit(phoneNumber.charAt(i))) {
                return false;
            }
        }

        // Check if the phone number starts with a valid prefix
        String[] validPrefixes = {"010", "011", "012", "013", "014", "015", "016", "017", "018", "019"};
        boolean isValidPrefix = false;
        for (String prefix : validPrefixes) {
            if (phoneNumber.startsWith(prefix)) {
                isValidPrefix = true;
                break;
            }
        }
        if (!isValidPrefix) {
            return false;
        }

        // If all conditions are met, return true
        return true;
    }
}

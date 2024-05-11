/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pointrewardsystem;

import java.util.ArrayList;
import java.util.Scanner;

public class EarnPoints {
    
    private static Member memberData = new Member();
    private ArrayList<Member> members = memberData.getMembers(); 
    private Scanner scanner = new Scanner(System.in);
    private int accumulatedPoints, currentPoints;
    private boolean valid = false;
    
    public void earning(int currentMem){
        String amtSpent;
        int earnings = 0;
        accumulatedPoints = members.get(currentMem).getPoints().getAccumulatedPoints();
        currentPoints = members.get(currentMem).getPoints().getCurrentPoints();

        do {
            System.out.print("Please enter the spending on the receipt: RM ");
            amtSpent = scanner.nextLine();
            valid = validityCheck(amtSpent);
            if (!valid){
                System.out.println("Incorrect input, Please Try Again.");
            }
        } while (!valid);
        
        double spendings = Double.parseDouble(amtSpent);
        if (accumulatedPoints > PointBalance.PREMIUM_THRESHOLD){
            PremiumBalance premium = new PremiumBalance(accumulatedPoints, currentPoints);
            earnings = premium.earnPoints(spendings);
            accumulatedPoints += earnings;
            currentPoints += earnings;
            System.out.println(earnings+ " Points Earned.");
            System.out.println("Point Balance: " + currentPoints);
        } else {
            NormalBalance normal = new NormalBalance(accumulatedPoints, currentPoints);
            earnings = normal.earnPoints(spendings);
            accumulatedPoints += earnings;
            currentPoints += earnings;
            System.out.println(earnings+ " Points Earned.");
            System.out.println("Point Balance: " + currentPoints);
        }
        
        members.get(currentMem).getPoints().setAccumulatedPoints(accumulatedPoints);
        members.get(currentMem).getPoints().setCurrentPoints(currentPoints);
        
    }
    
    private boolean validityCheck(String amtSpent){
        try{
            Double.parseDouble(amtSpent);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pointrewardsystem;

/**
 *
 * @author KMW
 */
public class PremiumBalance extends PointBalance{
    private static final double POINTS_PER_SPENDINGS = 2;
    public PremiumBalance(int accumulatedPoints, int currentPoints){
        super(accumulatedPoints, currentPoints);
    }
    
    @Override 
    public void earnPoints(double spendings){
        int earnings = (int) (spendings * POINTS_PER_SPENDINGS);
        accumulatedPoints += earnings;
        currentPoints += earnings;
    }
}

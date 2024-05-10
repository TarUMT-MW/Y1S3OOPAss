/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pointrewardsystem;


public class PremiumBalance extends PointBalance{
    private static final double POINTS_PER_SPENDINGS = 2;
    public PremiumBalance(int accumulatedPoints, int currentPoints){
        super(accumulatedPoints, currentPoints);
    }
       
    @Override 
    public int earnPoints(double spendings){
        int earnings = (int) (spendings * POINTS_PER_SPENDINGS);
        return earnings;
    }

    //getters
    public static double getPOINTS_PER_SPENDINGS() {
        return POINTS_PER_SPENDINGS;
    }

    public int getAccumulatedPoints() {
        return accumulatedPoints;
    }

    public int getCurrentPoints() {
        return currentPoints;
    }
}

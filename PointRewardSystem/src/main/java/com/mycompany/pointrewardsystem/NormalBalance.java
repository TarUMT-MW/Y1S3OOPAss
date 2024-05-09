/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pointrewardsystem;


public class NormalBalance extends PointBalance{
    private static final double POINTS_PER_SPENDINGS = 1;
    public NormalBalance(int accumulatedPoints, int currentPoints){
        super(accumulatedPoints, currentPoints);
    }
    
    @Override 
    public void earnPoints(double spendings){
        int earnings = (int) (spendings * POINTS_PER_SPENDINGS);
        accumulatedPoints += earnings;
        currentPoints += earnings;
    }
}

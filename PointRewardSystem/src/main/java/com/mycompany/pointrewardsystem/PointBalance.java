/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pointrewardsystem;

public class PointBalance {
    protected int accumulatedPoints, currentPoints;
    public static final int PREMIUM_THRESHOLD = 5000;
    
    public int earnPoints(double spendings){
    return 0;
    }
    
    //constuctor
    public PointBalance(int accumulatedPoints, int currentPoints) {
        this.accumulatedPoints = accumulatedPoints;
        this.currentPoints = currentPoints;
    }
    
    //getter setters
    public int getAccumulatedPoints() {
        return accumulatedPoints;
    }

    public void setAccumulatedPoints(int accumulatedPoints) {
        this.accumulatedPoints = accumulatedPoints;
    }

    public int getCurrentPoints() {
        return currentPoints;
    }

    public void setCurrentPoints(int currentPoints) {
        this.currentPoints = currentPoints;
    }

    
    
}

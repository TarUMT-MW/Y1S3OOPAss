/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pointrewardsystem;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;


public class DataStorage {
    private static String name, address, memID, phoneNo, icNo, password;
    private static int accumulatedPoints, currentPoints;
    
    public static ArrayList<Member> members = new ArrayList<>();

    //READ member data from file
    public void readFile(){
        try (BufferedReader read = new BufferedReader(new FileReader("memInfo.txt"))){
            String line;
            while ((line = read.readLine()) != null){
                name = line;
                address = read.readLine();
                memID = read.readLine();
                phoneNo = read.readLine();
                icNo = read.readLine();
                password = read.readLine();
                accumulatedPoints = parseInt(read.readLine());
                currentPoints = parseInt(read.readLine());

                //PointBalance points = new PointBalance(accumulatedPoints, currentPoints);
                
                Member member = new Member(name, address, memID, phoneNo, icNo, password, accumulatedPoints, currentPoints);
                members.add(member);
                //System.out.println(points);
            }
            read.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    
    public void writeFile(){
        try (BufferedWriter write = new BufferedWriter(new FileWriter("memInfo.txt"))){
            for (Member member : members){
                write.write(member.getName() + "\n");
                write.write(member.getAddress() + "\n");
                write.write(member.getMemID() + "\n");
                write.write(member.getPhoneNo() + "\n");
                write.write(member.getIcNo() + "\n");
                write.write(member.getPassword() + "\n");
                write.write(member.getPoints().getAccumulatedPoints() + "\n");
                write.write(member.getPoints().getCurrentPoints() + "\n");
            }
            write.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    
    //Constructor
    public DataStorage(){

    }
    
    //getter
    public static ArrayList<Member> getMembers(){
        return members;
    }
}

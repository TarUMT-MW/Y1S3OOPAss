/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pointrewardsystem;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;



public class DataStorage {
    private String name, address, memID, phoneNo, icNo, password;
    private int accumulatedP, currentP;
    
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
                accumulatedP = Integer.parseInt(read.readLine());
                currentP = Integer.parseInt(read.readLine());
                
                Member member = new Member(name, address, memID, phoneNo, icNo, password, accumulatedP, currentP);
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
            
            for (Member member:members){
            name = member.getName();
            address = member.getAddress();
            memID = member.getMemID();
            phoneNo = member.getPhoneNo();
            icNo = member.getIcNo();
            password = member.getPassword();
            accumulatedP = member.getPoints().accumulatedPoints;
            currentP = member.getPoints().currentPoints;
            write.write(name + "\n" + address + "\n" + memID + "\n" + phoneNo + "\n"
            + icNo + "\n" + password + "\n" + accumulatedP + "\n" + currentP + "\n");
            }

            write.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        
    }
//    ArrayList<Member> temp = new ArrayList<>();
//    public void preventDUP(){
//        
//        temp.clear();
//        temp.addAll(members);
//        members.clear();
//        members.addAll(temp);
//    }

    
    //Constructor
    public DataStorage(){

    }
    
    //getter
    public static ArrayList<Member> getMembers(){
        return members;
    }
}

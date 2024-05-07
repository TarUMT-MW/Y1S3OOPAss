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
import java.util.ArrayList;
import java.util.List;



public class DataStorage {
    private static String name, address, memID, phoneNo, icNo, password;
        public static ArrayList<Member> members = new ArrayList<>();
        
        public DataStorage(){
            
        }
        
        public static ArrayList<Member> getMembers(){
            return members;
        }
        
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
                    
                    Member newMember = new Member(name, address, memID, phoneNo, icNo, password);
                    members.add(newMember);
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pointrewardsystem;


import java.util.ArrayList;
import java.util.Random;

public class Member {
	private String name, address, memID, phoneNo, icNo, password;
//        private int accumulatedPoints, currentPoints;
	private PointBalance points;
        
	private static int numOfMember = 0;
        
        private static ArrayList<Member> members = DataStorage.getMembers();
	
	public Member() {
		
	}
	
	public Member(String name, String address, String phoneNo, String icNo, String password) {
		this.name = name;
		this.address = address;
		this.memID = generateMemID();
		this.phoneNo = phoneNo;
		this.icNo = icNo;
		this.password = password;
		this.points = new PointBalance(0,0);
		numOfMember++;
	}
        
        //for when reading and writting file
        public Member(String name, String address, String memID, String phoneNo, 
                String icNo, String password, int accumulatedPoints, int currentPoints) {
		this.name = name;
		this.address = address;
		this.memID = memID;
		this.phoneNo = phoneNo;
		this.icNo = icNo;
		this.password = password;
		this.points = new PointBalance(accumulatedPoints, currentPoints);
		numOfMember++;
	}
	
	public String generateMemID() {
		Random random = new Random();
		int memID = random.nextInt(900000) + 100000;
		String memberID = String.valueOf(memID);
		return memberID;
	}

        //to allow other classes to read the array of member info from member
        public static ArrayList<Member> getMembers(){
        return members;
        }
        
        //getter setter
	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getMemID() {
		return memID;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public String getIcNo() {
		return icNo;
	}
	
	public String getPassword() {
		return password;
	}
	
	public static int getNumOfMember() {
		return numOfMember;
	}
	
	public PointBalance getPoints() {
		return points;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setMemID(String memID) {
		this.memID = memID;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public void setIcNo(String icNo) {
		this.icNo = icNo;
	}
	
	public void setPoints(PointBalance points) {
		this.points = points;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean validatePassword(String password) {
        return this.password.equals(password);
    }

}

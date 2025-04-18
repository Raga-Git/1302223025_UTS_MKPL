/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany._tax_calculator;

/**
 *
 * @author LENOVO
 */
public class Identity {
    private String idNumber;
     private String firstName;
     private String lastName;
     private String address;
 
     public Identity(String idNumber, String firstName, String lastName, String address) {
         this.idNumber = idNumber;
         this.firstName = firstName;
         this.lastName = lastName;
         this.address = address;
     }
 
     public String getIdNumber() {
         return idNumber;
     }
 
     public String getFirstName() {
         return firstName;
     }
 
     public String getLastName() {
         return lastName;
     }
 
     public String getAddress() {
         return address;
     }
}

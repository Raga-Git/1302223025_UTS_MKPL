/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany._tax_calculator;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class Employee {
    private String employeeId;
	private Identity identity;
	
        private LocalDate joinDate;
	
	private boolean isForeigner;
	private Gender gender;
	
	private IncomeDetails incomeDetails;
	
	private Spouse spouse;

	private List<Child> children = new LinkedList<>();
	
	public Employee(String employeeId, Identity identity, LocalDate joinDate, boolean isForeigner, Gender gender) {
		this.employeeId = employeeId;
		this.identity = identity;
		this.joinDate = joinDate;
		this.isForeigner = isForeigner;
		this.gender = gender;
		
		children = new LinkedList<>();
	}
	
	/**
	 * Fungsi untuk menentukan gaji bulanan pegawai berdasarkan grade kepegawaiannya (grade 1: 3.000.000 per bulan, grade 2: 5.000.000 per bulan, grade 3: 7.000.000 per bulan)
	 * Jika pegawai adalah warga negara asing gaji bulanan diperbesar sebanyak 50%
	 */
	
	public void setMonthlySalary(int grade) {	
		int baseSalary;
                switch (grade) {
                    case 1:
                    baseSalary = 3000000;
                    break;
                case 2:
                    baseSalary = 5000000;
                    break;
                case 3:
                    baseSalary = 7000000;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid grade: " + grade);
                }
                if (isForeigner) {
                    baseSalary *= 1.5;
                }
                incomeDetails.setMonthlySalary((int) baseSalary);
	}
	
	public void setAnnualDeductible(int deductible) {	
		incomeDetails.setAnnualDeductible(deductible);
	}
	
	public void setSpouse(Spouse spouse) {
 		this.spouse = spouse;
 	}
	
	public void addChild(Child child) {
             children.add(child);
         }
	
	public int getAnnualIncomeTax() {
		
		//Menghitung berapa lama pegawai bekerja dalam setahun ini, jika pegawai sudah bekerja dari tahun sebelumnya maka otomatis dianggap 12 bulan.
		LocalDate date = LocalDate.now();
                int monthWorkingInYear;
		
		if (date.getYear() == joinDate.getYear()) {
 			monthWorkingInYear = date.getMonthValue() - joinDate.getMonthValue();
		}else {
			monthWorkingInYear = 12;
		}
		
		return TaxFunction.calculateTax(monthlySalary, otherMonthlyIncome, monthWorkingInYear, annualDeductible, spouseIdNumber.equals(""), childIdNumbers.size());
	}
}

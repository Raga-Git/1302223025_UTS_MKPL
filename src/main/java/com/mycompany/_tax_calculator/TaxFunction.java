/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany._tax_calculator;

/**
 *
 * @author LENOVO
 */
public class TaxFunction {

    /**
     * Fungsi untuk menghitung jumlah pajak penghasilan pegawai yang harus
     * dibayarkan setahun.
     *
     * Pajak dihitung sebagai 5% dari penghasilan bersih tahunan (gaji dan
     * pemasukan bulanan lainnya dikalikan jumlah bulan bekerja dikurangi
     * pemotongan) dikurangi penghasilan tidak kena pajak.
     *
     * Jika pegawai belum menikah dan belum punya anak maka penghasilan tidak
     * kena pajaknya adalah Rp 54.000.000. Jika pegawai sudah menikah maka
     * penghasilan tidak kena pajaknya ditambah sebesar Rp 4.500.000. Jika
     * pegawai sudah memiliki anak maka penghasilan tidak kena pajaknya ditambah
     * sebesar Rp 4.500.000 per anak sampai anak ketiga.
     *
     */
    private static final int BASE_SALARY = 54000000;
    private static final int MARRIED_BONUS = 4500000;
    private static final int CHILD_BONUS = 4500000;
    private static final int MAX_CHILDREN = 3;
    private static final double TAX_RATE = 0.05;

    public static int calculateTax(int monthlySalary, int otherMonthlyIncome, int numberOfMonthWorking, int deductible, boolean isMarried, int numberOfChildren) {
        validateNumberOfMonth(numberOfMonthWorking);

        numberOfChildren = Math.min(numberOfChildren, MAX_CHILDREN);

        int grossIncome = calculateGrossIncome(monthlySalary, otherMonthlyIncome, numberOfMonthWorking);
        int nonTaxable = calculateNonTaxableIncome(isMarried, numberOfChildren);

        int taxableIncome = grossIncome - deductible - nonTaxable;

        return (int) Math.round(TAX_RATE * Math.max(taxableIncome, 0));
    }

    private static void validateNumberOfMonth(int numberOfMonthWorking) {
        if (numberOfMonthWorking > 12) {
            throw new IllegalArgumentException("More than 12 months working per year");
        }
    }

    private static int calculateGrossIncome(int salary, int otherIncome, int months) {
        return (salary + otherIncome) * months;
    }

    private static int calculateNonTaxableIncome(boolean isMarried, int children) {
        int income = BASE_SALARY;
        if (isMarried) {
            income += MARRIED_BONUS;
        }
        income += children * CHILD_BONUS;
        return income;
    }
}


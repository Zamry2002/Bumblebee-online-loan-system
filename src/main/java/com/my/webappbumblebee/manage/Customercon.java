/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.my.webappbumblebee.manage;


public class Customercon {
    private int id;
    private String full_name;
    private String date_of_birth;
    private String email;
    private String age;
    private String gender;  
    private String loan_balance;
    private String used_amount;
    private String installment_plan;

    public Customercon(int id, String full_name, String date_of_birth, String email, String age, String gender, String loan_balance, String used_amount, String installment_plan) {
        this.id = id;
        this.full_name = full_name;
        this.date_of_birth = date_of_birth;
        this.email = email;
        this.age = age;
        this.gender = gender;
        this.loan_balance = loan_balance;
        this.used_amount = used_amount;
        this.installment_plan = installment_plan;
    }

    public Customercon(String full_name, String date_of_birth, String email, String age, String gender, String loan_balance, String used_amount, String installment_plan) {
        this.full_name = full_name;
        this.date_of_birth = date_of_birth;
        this.email = email;
        this.age = age;
        this.gender = gender;
        this.loan_balance = loan_balance;
        this.used_amount = used_amount;
        this.installment_plan = installment_plan;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLoan_balance() {
        return loan_balance;
    }

    public void setLoan_balance(String loan_balance) {
        this.loan_balance = loan_balance;
    }

    public String getUsed_amount() {
        return used_amount;
    }

    public void setUsed_amount(String used_amount) {
        this.used_amount = used_amount;
    }

    public String getInstallment_plan() {
        return installment_plan;
    }

    public void setInstallment_plan(String installment_plan) {
        this.installment_plan = installment_plan;
    }
}


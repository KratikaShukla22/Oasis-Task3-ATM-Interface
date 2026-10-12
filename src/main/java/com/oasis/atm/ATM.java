package com.oasis.atm;

import java.util.Scanner;
import java.util.ArrayList;

public class ATM {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int correctPin = 1234;

        System.out.print("Enter your PIN: ");
        int pin = sc.nextInt();

        if (pin != correctPin) {
            System.out.println("Incorrect PIN.");
            sc.close();
            return;
        }

        System.out.println("Login successful.");

        int balance = 10000;
        ArrayList<String> transactions = new ArrayList<>();
        int amount;

        while (true) {

            System.out.println("\n===== ATM MACHINE =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Deposit Money");
            System.out.println("4. Transaction History");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            if (choice == 1) {

                System.out.println("Balance: ₹" + balance);

            } else if (choice == 2) {

                System.out.print("Enter amount to withdraw: ");
                amount = sc.nextInt();

                if (amount > 0 && amount <= balance) {
                    balance = balance - amount;
                    transactions.add("Withdrawn: ₹" + amount);
                    System.out.println("Please collect your cash.");
                    System.out.println("Remaining balance: ₹" + balance);
                } else {
                    System.out.println("Invalid amount or insufficient balance.");
                }

            } else if (choice == 3) {

                System.out.print("Enter amount to deposit: ");
                amount = sc.nextInt();

                if (amount > 0) {
                    balance = balance + amount;
                    transactions.add("Deposited: ₹" + amount);
                    System.out.println("Amount deposited successfully.");
                    System.out.println("Updated balance: ₹" + balance);
                } else {
                    System.out.println("Invalid deposit amount.");
                }

            } else if (choice == 4) {

                System.out.println("\n===== TRANSACTION HISTORY =====");

                if (transactions.isEmpty()) {
                    System.out.println("No transactions yet.");
                } else {
                    for (String transaction : transactions) {
                        System.out.println(transaction);
                    }
                }

            } else if (choice == 5) {

                System.out.println("Thank you for using the ATM.");
                break;

            } else {

                System.out.println("Invalid choice.");
            }
        }
}}
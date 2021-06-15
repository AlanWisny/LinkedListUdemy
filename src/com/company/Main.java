package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Customer customer = new Customer("Alan", 50.00);
        Customer anotherCustomer = new Customer("Some guy", 01.50);
        anotherCustomer = customer;
        anotherCustomer.setBalance(12.18);
        // overwrites the initial value
        System.out.println(customer.getBalance());

        ArrayList<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(3);
        intList.add(4);

        for (int i=0; i < intList.size(); i++) {
            System.out.println(i + ": " + intList.get(i));
        }

        intList.add(1, 2);

        for (int i=0; i < intList.size(); i++) {
            System.out.println(i + ": " + intList.get(i));
        }

    }
}

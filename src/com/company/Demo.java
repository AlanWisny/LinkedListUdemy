package com.company;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        LinkedList<String> places = new LinkedList<>();
        addInOrder(places, "Amsterdam");
        addInOrder(places, "Rotterdam");
        addInOrder(places, "Haarlem");
        addInOrder(places, "Alphen a/d Rijn");
        addInOrder(places, "Den Haag");
        addInOrder(places, "Delft");
        addInOrder(places, "Zoetermeer");

        printList(places);

        places.add(1, "Amstelveen");
        printList(places);
        visit(places);
//
//        places.remove(4);
//        printList(places);
    }

    private static void printList(LinkedList<String> list) {
        Iterator<String> i = list.iterator();
        while(i.hasNext()) {
            System.out.println("Now visiting " + i.next());
        }
        System.out.println("==============================");
    }

    private static boolean addInOrder(LinkedList<String> list, String city) {
        ListIterator<String> it = list.listIterator();

        while(it.hasNext()) {
            // 0 matches, 1 if it is bigger, -1 if smaller
            int comparison = it.next().compareTo(city);

            if(comparison == 0) {
                // equal, do not add
                System.out.println(city + " is already included as a destination");
                return false;

            } else if(comparison > 0) {
                // new city should appear before this one
                it.previous();
                it.add(city);
                return true;

            } else if(comparison < 0) {
                // move on to the next city
            }
        }
        it.add(city);
        return true;
    }

    private static void visit(LinkedList cities) {
        Scanner s = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<String> it = cities.listIterator();

        if(cities.isEmpty()) {
            System.out.println("No cities in the itenerary");
        } else {
            System.out.println("Now visiting " + it.next());
            printMenu();
        }
        while(!quit) {
            int action = s.nextInt();
            s.nextLine();
            switch(action) {
                case 0:
                    System.out.println("Holiday is over");
                    break;
                case 1:
                    if(!forward){
                        if(it.hasPrevious()) {
                            it.next();
                        }
                        forward = true;
                    }
                    if(it.hasNext()) {
                        System.out.println("Now visiting " + it.next());
                } else {
                        System.out.println("Reached the end of the list");
                    }
                    break;

                case 2:
                    if(forward) {
                        if(it.hasPrevious()) {
                            it.previous();
                        }
                        forward = false;
                    }
                    if(it.hasPrevious()) {
                        System.out.println("Now visiting " + it.previous());
                    } else {
                        System.out.println("We are at the start of the list");
                        forward = true;
                    }
                    break;

                case 3:
                    printMenu();
                    break;
            }
        }
    }

    public static void printMenu() {
        System.out.println("Available actions:\npress ");
        System.out.println("0 - to quit\n" +
                            "1 - go to the next city\n" +
                            "2 - go to the previous city\n" +
                            "3 - print menu options");
    }
}

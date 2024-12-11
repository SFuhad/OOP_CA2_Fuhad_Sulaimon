package org.example;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/**
 *  Your Name: Fuhad Sulaimon
 *  Class Group: GD2A
 */

public class Question6      // Flight take-off (Queue)
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        Queue<String> takeOffQueue = new ArrayDeque<String>();
        Queue<String> landingQueue = new ArrayDeque<String>();

        System.out.println("Airport Runway");
        String[] menu =
        {
                         "Enter a Command",
                         "1. Takeoff",
                         "2. Land",
                         "3. Next",
                         "4. Quit"
        };
        for (String option: menu)
        {
            System.out.println(option);
        }

        int choice = 0;
        do {
            choice = getMenuChoice(4);
            switch (choice) {
                case 1:
                    System.out.println("Please enter the flight code consisting of 2 numbers.");
                    String takeOff = keyboard.nextLine();
                    while (takeOff.length() < 2) {
                        System.out.println("Error: Valid flight code required for takeoff");
                        takeOff = keyboard.nextLine();
                    }
                    takeOffQueue.add("Flight-" + takeOff);
                    System.out.println("Flight " + takeOff + " queued for takeoff.");
                    break;
                case 2:
                    System.out.println("Please enter the flight code consisting of 2 numbers.");
                    String landing = keyboard.nextLine();
                    while (landing.length() < 2) {
                        System.out.println("Error: Valid flight code required for takeoff");
                        landing = keyboard.nextLine();
                    }
                    landingQueue.add("Flight-" + landing);
                    System.out.println("Flight " + landing + " queued for takeoff.");
                    break;
                case 3:
                    if (!landingQueue.isEmpty()) {
                        String flight = landingQueue.poll();
                        System.out.println(flight + " is landing.");
                    } else if (!takeOffQueue.isEmpty()) {
                        String flight = takeOffQueue.poll();
                        System.out.println(flight + " is taking off.");
                    } else {
                        System.out.println("There are no flights waiting");
                    }
                    break;
                case 4:
                    System.out.println("Simulation Ended");
                    keyboard.close();
                    System.exit(0);

                default:
                    break;
            }
        }
        while (choice != 4);
    }
    public static int getMenuChoice(int numItems)
    {
        Scanner keyboard = new Scanner(System.in);
        int choice = keyboard.nextInt();
        while (choice < 0 || choice > numItems) {
            String[] menu =
                    {
                            "Enter a Valid Command",
                            "1. Takeoff",
                            "2. Land",
                            "3. Next",
                            "4. Quit"
                    };
            for (String option: menu)
            {
                System.out.println(option);
            }
            choice = keyboard.nextInt();
        }
        return choice;
    }
}
package org.example;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 *  Your Name: Fuhad Sulaimon
 *  Class Group: GD2A
 */
public class Question2  // Car Parking - Stack
{
    public static void runSimulation()
    {
        Scanner keyboard = new Scanner(System.in);

        //Initialize  a stack for a car park
        Deque<Integer> carPark = new ArrayDeque<>();

        //Initialize a stack for the stret;
        Deque<Integer> street = new ArrayDeque<>();

        System.out.print("Please enter a number: " +
                        "- Positive Numbers will add a car" +
                        "- Negative Numbers will retrieve a car" +
                        "- 0 will stop program");
        int carChoice = keyboard.nextInt();

        if(carChoice > 0)
        {
            carPark.push(carChoice);
            System.out.println(" Your car " + carChoice + "has been added to the car park");
        }
        else if (carChoice < 0)
        {
            int carToRemove = -carChoice;
            if(carPark.isEmpty())
            {
                System.out.println("There are no cars in the car park.");
            }
            else if(!carPark.contains(carToRemove))
            {
                System.out.println("Your car " +carToRemove+ "is not in the car park");
            }
            else
            {
                while(!carPark.isEmpty() && carPark.peek() != carToRemove)
                {
                    int topCar = carPark.pop();
                    street.push(topCar);
                    System.out.println("Owner of car " +topCar+ "has been asked to moved their car in other to allow " +carToRemove+ " #leave");
                }

                if(!carPark.isEmpty() && carPark.peek() == carToRemove)
                {
                    carPark.pop();
                    System.out.println("Car " +carToRemove+ " has left the car park.");
                }

                while(!street.isEmpty())
                {
                    int returningCars = street.pop();
                    carPark.push(returningCars);
                    System.out.println("Owner of car " +returningCars+ "has moved their car back to the car park.");
                }
            }
        }
    }

    public static void main(String[] args) {
        runSimulation();
    }
}

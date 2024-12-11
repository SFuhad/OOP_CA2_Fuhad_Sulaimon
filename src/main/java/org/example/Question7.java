package org.example;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/**
 *  Your Name: Fuhad Sulaimon
 *  Class Group: GD2A
 */
public class Question7  // Shares Tax Calculations (Queue)
{

    /*
    Will repeatedly ask the user to enter the commands in the format
    buy qty price
    or
    sell qty price
    or
    quit
     */
    public static void main(String[] args)
    {
        Queue<Share> queue = new ArrayDeque<Share>();

        Scanner in = new Scanner(System.in);
        String command = "";
            do
            {

            System.out.print(">Shares Trade Co. Menu\n" +
                            "-Buy\n" +
                            "-Sell\n" +
                            "-Quit\n");
            command = in.next();

            if(command.equalsIgnoreCase("buy"))
            {
                System.out.println("Please enter the quantity of  shares you want to buy: ");
                int qty = in.nextInt();
                System.out.println("Please enter the price at which you want to buy your shares: ");
                double price = in.nextDouble();
                queue.add(new Share(qty, price));
                System.out.println("You have bought " +qty+ " of shares at $" +price+ " per share.");

            }
            else if(command.equals("sell"))
            {
                System.out.println("Please enter the quantity of  shares you want to sell: ");
                int qty = in.nextInt();
                System.out.println("Please enter the price at which you want to sell your shares: ");
                double price = in.nextDouble();
                double gain = 0.0;

                while (qty > 0 && !queue.isEmpty()) {
                    Share current = queue.peek();

                    if (current.quantity <= qty) {
                        gain += current.quantity * (price - current.price);
                        qty -= current.quantity;
                        queue.poll();
                    } else {
                        gain += qty * (price - current.price);
                        current.quantity -= qty;
                        qty = 0;
                    }
                }

                if (qty > 0) {
                    System.out.println("There are no enough shares to sell");
                }
                else
                {
                    System.out.println("You have sold " +qty+ "at $" +price+ " per share");
                    System.out.println("Toral gain from sales is $" + gain);
                }
            }
            else if(!(command.equalsIgnoreCase("quit" ) || command.equalsIgnoreCase("buy") || command.equalsIgnoreCase("selll")))
            {
                System.out.println("Invalid Input: Enter a valid input from the options");
            }
        }while(!command.equalsIgnoreCase("quit"));
    }
}
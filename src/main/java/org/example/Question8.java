package org.example;

import java.util.*;
/**
 *  Your Name: Fuhad Sulaimon
 *  Class Group: GD2A
 */
public class Question8  // Multi-company (Queue)
{
    /*
   Will repeatedly ask the user to enter the commands in the format
   buy company qty price
   or
   sell company qty price
   or
   quit
    */
    public static void main(String[] args)
    {
        Map<String, Queue<Share>> stock = new HashMap<>();

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
                System.out.println("Please enter the name of the company you're buying shares from: ");
                String company = in.next();
                System.out.println("Please enter the quantity of  shares you want to buy: ");
                int qty = in.nextInt();
                System.out.println("Please enter the price at which you want to buy your shares: ");
                double price = in.nextDouble();
                stock.putIfAbsent(company, new LinkedList<>());
                stock.get(company).add(new  Share(qty, price));
                System.out.println("You have bought " +qty+ " of shares off" +company+ " at $" +price+ " per share.");

            }
            else if(command.equals("sell"))
            {
                System.out.println("Please enter the name of the company you're buying shares from: ");
                String company = in.next();
                System.out.println("Please enter the quantity of  shares you want to sell: ");
                int qty = in.nextInt();
                System.out.println("Please enter the price at which you want to sell your shares: ");
                double price = in.nextDouble();

                if(!stock.containsKey(company) || stock.get(company).isEmpty())
                {
                    System.out.println("There are no shares to buy off " +company);
                    continue;
                }

                Queue<Share> queue = stock.get(company);
                double gain = 0.0;
                int originallSale = qty;

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
                    System.out.println("There are no enough shares to sell of " +company);
                }
                else
                {
                    System.out.println((originallSale - qty)+ " shares has been sold of " +company+ " at $" +price);
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
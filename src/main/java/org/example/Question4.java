package org.example;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

/**
 *  Your Name: Fuhad Sulaimon
 *  Class Group: GD2A
 */

public class Question4  // Flood Fill (Stack, 2D Array)
{
    public static void main(String[] args) {
        start();
    }
    public static void start()
    {
        Scanner kb = new Scanner(System.in);
        int[][] arr = floodFillStart();

        System.out.println("Please enter your starting row point between 0-10");
        int initialRow = kb.nextInt();
        System.out.println("Please enter your starting column point between 0-10");
        int initialColumn = kb.nextInt();

        while(initialRow < 0 || initialRow >= 10)
        {
            System.out.println("Please enter a valid starting row point between 0-10");
            initialRow = kb.nextInt();
        }

        while(initialColumn < 0 || initialColumn >= 10)
        {
            System.out.println("Please enter a valid starting column point between 0-10");
            initialColumn = kb.nextInt();
        }

        fill(initialRow,initialColumn, arr);

        display(arr);
    }

    /*
        Starter function to create the 2D array and populate it with zeros
     */
    public static int[][]  floodFillStart() {
        int[][] arr = new int[10][10];
        for (int x = 0; x < 10; x++)
        {
            for (int y = 0; y < 10; y++)
            {
                arr[x][y] = 0;
            }
        }
        return arr;
    }
    /*
        Helper function to display the image
     */
    public static void display(int[][] arr)
    {
        for (int x = 0; x < 10; x++)
        {
            for (int y = 0; y < 10; y++)
            {
                System.out.printf("%4d", arr[x][y]);
            }
            System.out.println();
        }
    }
    private static void fill(int r, int c, int[][] arr)
    {
        Stack<Cell> stack = new Stack<>();

        stack.push(new Cell(r, c));

        int counter = 1;

        while(!stack.isEmpty())
        {
            Cell current = stack.pop();

            int row = current.row;
            int column = current.column;

            if (row >= 0 && row < 10 && column >= 0 && column < 10 && arr[row][column] == 0)
            {
                arr[row][column] = counter++;

                stack.push(new Cell(row - 1, column));
                stack.push(new Cell(row + 1, column));
                stack.push(new Cell(row, column - 1));
                stack.push(new Cell(row, column + 1));
            }
        }
    }
}

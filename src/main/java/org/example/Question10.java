package org.example;

import java.util.Random;
import java.util.Stack;

public class Question10
{
    public static void main(String[] args)
    {
        int startX = 1;
        int startY = 1;

        solve(startX, startY, DIRECTION.EAST);
    }

    public static void display(int[][] image) {
        for (int x = 0; x < image.length; x++) {
            for (int y = 0; y < image[0].length; y++) {
                System.out.printf("%4d", image[x][y]);
            }
            System.out.println();
        }
    }

    public static void solve(int x, int y, DIRECTION dir)
    {
        int [][] maze = generateMaze(10,10);
        System.out.println("The Maze");
        display(maze);

        int exitX = maze.length - 2;
        int exitY = maze[0].length - 2;

        boolean found = solveMaze(maze, x, y, exitX, exitY);
        if(found)
        {
            System.out.println("\nA path has been found");
        }
        else
        {
            System.out.println("\nNo path is found");
        }
    }

    public static int[][] generateMaze(int rows, int columns)
    {
        int[][] maze = new int[rows][columns];
        Random rand = new Random();

        for(int i = 0; i < rows; i++)
        {
            for (int j = 0; j < columns; j ++)
            {
                maze[i][j] = 1;
            }
        }

        int x = 1;
        int y = 1;
        maze[x][y] = 0;
        while(x < rows - 2 || y < columns - 2)
        {
            if(x < rows - 2 && rand.nextBoolean())
            {
                x++;
            } else if (y < columns - 2)
            {
                y++;
            }
            maze[x][y] = 0;
        }

        maze[rows - 2][columns - 2] = 0;

        for(int i =1; i < rows - 1; i ++)
        {
            for(int j = 1; j < columns - 1; j++)
            {
                if(maze[i][j] == 1 && rand.nextDouble() > 0.7)
                {
                    maze[i][j] = 0;
                }
            }
        }

        return maze;
    }

    public static boolean solveMaze(int[][] maze, int startX, int startY, int exitX, int exitY)
    {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{startX, startY});

        maze[startX][startY] = 2;

        int[][] directions =
        {
                {0, 1},
                {1, 0},
                {0, -1},
                {-1, 0}
        };

        while(!stack.isEmpty())
        {
            int [] current = stack.pop();
            int x = current[0];
            int y = current[1];

            if(x == exitX && y == exitY)
            {
                maze[x][y] = 3;
                return true;
            }

            for (int[] dir : directions)
            {
                int newX = x + dir[0];
                int newY = y + dir[1];

                if (isSafe(maze, newX, newY))
                {
                    stack.push(new int[]{newX, newY});
                    maze[newX][newY] = 2;
                }
            }
        }

        return false;
    }

    public  static boolean isSafe(int [][] maze, int x, int y)
    {
        return x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 0;
    }
}

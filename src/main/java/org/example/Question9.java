package org.example;

import java.util.Scanner;
import java.util.Stack;

/**
 *  Your Name: Fuhad Sulaimon
 *  Class Group: GD2A
 */
public class Question9 {

    /*
        Reads in an equation from the user
     */
    public static void main(String[] args) throws Exception {
        String equation;
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter equation");
        equation = in.nextLine().trim();

        try
        {
            double result = evaluate(equation);
            System.out.println("Result: " +result);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static double evaluate(String equation) throws Exception {
        Stack<Double> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>();

        int length = 0;
        while(length < equation.length())
        {
            char ch = equation.charAt(length);

            if(Character.isWhitespace(ch))
            {
                length++;
                continue;
            }

            if(Character.isDigit(ch))
            {
                StringBuilder num = new StringBuilder();
                while(length < equation.length() && (Character.isDigit(equation.charAt(length)) || equation.charAt(length) == '.'))
                {
                    num.append(equation.charAt(length));
                    length++;
                }
                numbers.push(Double.parseDouble(num.toString()));
                continue;
            }

            if (ch == '(')
            {
                operators.push(ch);
            }
            else if (ch == ')')
            {
                while(!operators.isEmpty() && operators.peek() != '(')
                {
                    evaluateTop(numbers, operators);
                }
                if (operators.isEmpty() || operators.pop() != '(')
                {
                    throw new Exception("Mismatching Parentheses");
                }
            }
            else if(isOperator(ch))
            {
                while(!operators.isEmpty() && precedence(operators.peek()) >= precedence(ch))
                {
                    evaluateTop(numbers, operators);
                }
                operators.push(ch);
            }
            else
            {
                throw new Exception("Invalid character: " + ch);
            }
            length++;
        }

        while(!operators.isEmpty())
        {
            evaluateTop(numbers, operators);
        }

        if(numbers.size() != 1)
        {
            throw new Exception("Invalid Expression");
        }
        return numbers.pop();
    }
    public static void evaluateTop(Stack<Double> numbers, Stack<Character> operators) throws Exception
    {
        if(numbers.size() < 2)
        {
            throw new Exception("Invalid Equation");
        }

        double b = numbers.pop();
        double a = numbers.pop();
        char operator = operators.pop();

        switch (operator)
        {
            case '+':
                numbers.push(a + b);
                break;
            case '-':
                numbers.push(a - b);
                break;
            case '*':
                numbers.push(a * b);
                break;
            case '/':
                if (b == 0)
                {
                    throw new Exception("Division by zero not valid");
                }
                numbers.push(a / b);
                break;
            default:
                throw new Exception("Invalid operator: " + operator);
        }
    }
    private static boolean isOperator(char ch)
    {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }
    private static int precedence(char operator)
    {
        if(operator == '+' || operator == '-')
        {
            return 1;
        }
        else if (operator == '*' || operator == '/')
        {
            return 2;
        }
        return -1;
    }
}

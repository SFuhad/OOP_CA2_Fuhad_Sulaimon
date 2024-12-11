package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

/**
 *  Your Name: Fuhad Sulaimon
 *  Class Group: GD2A
 */
public class Question3  {   //Nested HTML (Stack)

    /*
filename: name of the file to test.
*/
    public static boolean validate(String filename) throws FileNotFoundException
    {
        Deque<String> tags = new ArrayDeque<>();

        String[] selfClosingTags = {"br"};

        File inputFile = new File(filename);

        try(Scanner input = new Scanner(inputFile))
        {
            while(input.hasNext())
            {
                String tag = input.next();
                boolean isSelfClosing = false;
                for(String noCloseNeeded : selfClosingTags)
                {
                    if(tags.equals("<" +noCloseNeeded+ "/>"))
                    {
                        isSelfClosing = true;
                    }
                }

                if(isSelfClosing)
                {
                    continue;
                }
                
                if (tag.startsWith("</"))
                {
                    String tagContent = tag.substring(2, tag.length() - 1);

                    if(tags.isEmpty() || !tags.peek().equals(tagContent))
                    {
                        return false;
                    }
                    tags.pop();

                }
                else if(tag.startsWith("<"))
                {
                    String tagContent = tag.substring(1, tag.length() - 1);
                    tags.push(tagContent);
                }
            }

            return tags.isEmpty();
        }
    }

    /*
        This function tests the files in the files array to see if
         they are valid.
         tags_valid.txt should return true;
         tags_invalid.txt should output as invalid;


     */
    public static void main(String[] args) throws FileNotFoundException {
        String[] files = {"tags_valid.txt", "tags_invalid.txt"};
        for(String fName: files) {
            System.out.print(fName +": ");
            if (validate(fName)) {
                System.out.println("This file is valid");
            } else {
                System.out.println("This file is invalid");
            }
        }
    }



}



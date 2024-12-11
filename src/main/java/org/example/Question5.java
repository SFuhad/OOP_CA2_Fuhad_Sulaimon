package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *  Your Name: Fuhad Sulaimon
 *  Class Group: GD2A
 */
public class Question5 {    //Java Identifier Count (Map)

    public static Map<String, Object> readFile(String fileName) throws FileNotFoundException {
        File inputFile = new File(fileName);
        Scanner input = new Scanner(inputFile);

        Map<String, Integer> identifierCountMap = new HashMap<>();
        Map<String, List<String>> identifierLinesMap = new HashMap<>();

        Pattern identifier = Pattern.compile("\\b[A-Za-z_][A-Za-z0-9_]*\\b");

        int lineNo = 0;

        while(input.hasNextLine())
        {
            String line = input.nextLine();
            lineNo++;

            Matcher matcher = identifier.matcher(line);
            while(matcher.find())
            {
                String key = matcher.group();

                identifierCountMap.put(key, identifierCountMap.getOrDefault(key, 0) + 1);

                String lineWithKey = lineNo + ". " + line;
                identifierLinesMap.computeIfAbsent(key, k -> new ArrayList<>()).add(lineWithKey);
            }
        }
        input.close();

        Map<String, Object> result = new HashMap<>();
        result.put("countMap", identifierCountMap);
        result.put("linesMap", identifierLinesMap);
        return result;
    }

    public static void outputResult(Map<String, Integer> identifierCountMap, Map<String, List<String>> identifierLinesMap)
    {

        List<String> sortedIdebtifiers = new ArrayList<>(identifierCountMap.keySet());
        Collections.sort(sortedIdebtifiers);

        for(String identifier : sortedIdebtifiers)
        {
            System.out.println(identifier);
            System.out.println(identifierCountMap.get(identifier));
            for (String line : identifierLinesMap.get(identifier))
            {
                System.out.println(line);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws FileNotFoundException
    {
        String fileName = "src/main/java/org/example/Question2.java";

        Map<String, Object> result = readFile(fileName);
        Map<String, Integer> identifierCountMap = (Map<String, Integer>) result.get("countMap");
        Map<String, List<String>> identifierLinesMap = (Map<String, List<String>>) result.get("linesMap");

        outputResult(identifierCountMap, identifierLinesMap);
    }
}

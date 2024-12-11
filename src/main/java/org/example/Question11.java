package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 *  Your Name: Fuhad Sulaimon
 *  Class Group: GD2A
 */
public class Question11
{
    public static void main(String[] args) throws FileNotFoundException
    {
        try {
            File inputFile = new File("cities.txt");

            Scanner input = new Scanner(inputFile);

            Map<String, TreeSet<DistanceTo>> graph = new HashMap<>();
            String start = null;

            while (input.hasNextLine()) {
                String[] parts = input.nextLine().trim().split("\\s+");
                if (parts.length != 3)
                {
                    continue;
                }
                String cityFrom = parts[0];
                String cityTo = parts[1];
                int distance = Integer.parseInt(parts[2]);

                graph.putIfAbsent(cityFrom, new TreeSet<>());
                graph.putIfAbsent(cityTo, new TreeSet<>());

                graph.get(cityFrom).add(new DistanceTo(cityTo, distance));
                graph.get(cityTo).add(new DistanceTo(cityFrom, distance));

                if (start == null) {
                    start = cityFrom;
                }
            }
            input.close();


            Map<String, Integer> shortestDistances = dijkstra(graph, start);

            System.out.println("The shortest distance from " + start + ":");
            for (Map.Entry<String, Integer> entry : shortestDistances.entrySet())
            {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Error: File not found.");
        }
    }

    public static Map<String, Integer> dijkstra(Map<String, TreeSet<DistanceTo>> graph, String start)
    {
        PriorityQueue<DistanceTo> priorityQueue = new PriorityQueue<>();
        Map<String, Integer> shortestKnownDistance = new HashMap<>();

        priorityQueue.add(new DistanceTo(start, 0));

        while (!priorityQueue.isEmpty())
        {
            DistanceTo current = priorityQueue.poll();
            String currentCity = current.getTarget();
            int currentDistance = current.getDistance();

            if (shortestKnownDistance.containsKey(currentCity))
            {
                continue;
            }

            shortestKnownDistance.put(currentCity, currentDistance);

            if(graph.containsKey(currentCity))
            {
                for(DistanceTo neighbor : graph.get(currentCity))
                {
                    if (!shortestKnownDistance.containsKey(neighbor.getTarget()))
                    {
                        int newDistance = currentDistance + neighbor.getDistance();
                        priorityQueue.add(new DistanceTo(neighbor.getTarget(), newDistance));
                    }
                }
            }
        }
        return shortestKnownDistance;
    }
}

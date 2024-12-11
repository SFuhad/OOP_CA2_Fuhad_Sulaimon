package org.example;

import java.awt.*;
import java.util.ArrayList;

/**
 *  Your Name: Fuhad Sulaimon
 *  Class Group: GD2A
 */
public class Question1 {    // Interfaces
    public static void main(String[] args) {
        System.out.println("Question 1");

        // create container here...
        ContinerManager manager = new ContinerManager();

        Box box1 = new Box(1, 3, 5, 7);
        Cylinder cylinder1 = new Cylinder(2, 4, 6);
        Pyramid pyramid1 = new Pyramid(8,9,10);

        manager.add(box1);
        manager.add(cylinder1);
        manager.add(pyramid1);

        System.out.println("Total weight: " + manager.totalWeight());

        System.out.println("Total Rectangular Volume: " + manager.rectangularVolume() + "unit ^3");

        System.out.println("All Containers: " + manager.getAllContainers());

        manager.clearAll();
        System.out.println("Containers after clearing: " + manager.getAllContainers());
    }
}



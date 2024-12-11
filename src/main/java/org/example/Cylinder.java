package org.example;

public class Cylinder implements IMeasurableContainer
{
    private double height;
    private double diameter;
    private double weight;

    public Cylinder(double height, double diameter, double weight)
    {
        this.height = height;
        this.diameter = diameter;
        this.weight = weight;
    }

    public Cylinder()
    {
        this.height = 0.0;
        this.diameter = 0.0;
        this.weight = 0.0;
    }

    @Override
    public double weight()
    {
        return weight;
    }

    @Override
    public double rectagularVolume()
    {
        return diameter * diameter * height;
    }
}

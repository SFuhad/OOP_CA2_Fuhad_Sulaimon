package org.example;

public class Box implements IMeasurableContainer
{
    private double height;
    private double width;
    private double depth;
    private double weight;

    public Box(double height, double width, double depth, double weight)
    {
        this.height = height;
        this.width = width;
        this.depth = depth;
        this.weight = weight;
    }

    public Box()
    {
        this.height = 0.0;
        this.width = 0.0;
        this.depth = 0.0;
        this.weight = 0.0;
    }

    @Override
    public double weight()
    {
        return weight;
    }

    @Override
    public double rectagularVolume() {
        return depth * width * height;
    }
}

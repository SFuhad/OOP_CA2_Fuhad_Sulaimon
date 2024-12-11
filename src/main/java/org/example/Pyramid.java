package org.example;

public class Pyramid implements IMeasurableContainer
{
    private double length;
    private double sideLength;
    private double weight;

    public Pyramid(double length, double sideLength, double weight)
    {
        this.length = length;
        this.sideLength = sideLength;
        this.weight = weight;
    }

    public Pyramid()
    {
        this.length =  0.0;
        this.sideLength = 0.0;
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
        double height = Math.sqrt(Math.pow(sideLength, 2) - Math.pow((length/2), 2));
        return length * length * height;
    }
}

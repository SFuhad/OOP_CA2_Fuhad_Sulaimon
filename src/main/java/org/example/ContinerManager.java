package org.example;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ContinerManager
{
    private ArrayList<IMeasurableContainer> goods = new ArrayList<>();

    public void add(IMeasurableContainer container)
    {

        goods.add(container);
    }

    public double totalWeight()
    {
        double total = 0;
        for(IMeasurableContainer container : goods)
        {
            total += container.weight();
        }
        return total;
    }

    public double rectangularVolume()
    {
        double total = 0;

        for (IMeasurableContainer container : goods)
        {
            total += container.rectagularVolume();
        }
        return total;
    }

    public void clearAll()
    {
        goods.clear();
    }

    public List<IMeasurableContainer> getAllContainers()
    {
        return new ArrayList<>(goods);
    }


}

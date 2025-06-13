/* 
import java.util.*;

class Item {
    private String name;
    private int weight;

    public Item(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public Item(String name) {
        this.name = name;
        this.weight = 0;
    }

    public int getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }   

}

abstract class Box {
    public abstract  void addItem(Item item);
    public abstract  boolean islnBox(Item item);      
}

class BoxWithMaxWeight extends Box {
    private int maxWeight;
    private int currentWeight;
    private ArrayList<Item> items;


    public BoxWithMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
        this.items = new ArrayList<Item>();
        this.currentWeight = 0;
    }

    @Override
    public void addItem(Item item) {
        if(currentWeight + item.getWeight() <= maxWeight) {
            items.add(item);
            currentWeight += item.getWeight();
        } 
    }

    @Override
    public boolean islnBox(Item item) {
    for (Item i : items) {
        if (i.getName().equals(item.getName())) {
            return true;
        }
    }
    return false;
    }
}

public class INHERITANCE002 {
    public static void main(String[] args) {
        BoxWithMaxWeight box = new BoxWithMaxWeight(10);

        Item item1 = new Item("Saludo", 5);
        Item item2 = new Item("Prikka", 5);
        Item item3 = new Item("Kopi Luwak", 5);

        box.addItem(item1);
        box.addItem(item2);
        box.addItem(item3);

        System.out.println(box.islnBox(item1));
        System.out.println(box.islnBox(item2));
        System.out.println(box.islnBox(item3));

    }
}
*/

import java.util.*;

class Item {
    private String name;
    private int weight;

    public Item(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public Item(String name) {
        this.name = name;
        this.weight = 0;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }
}

abstract class Box {
    public abstract void addItem(Item item);
    public abstract boolean isInBox(Item item);
}

class BoxWithMaxWeight extends Box {
    private ArrayList<Item> items;
    private int maxWeight;
    private int currentWeight;

    public BoxWithMaxWeight(int maxWeight, int currentWeight) {
        this.items = new ArrayList<Item>();
        this.maxWeight = maxWeight;
        this.currentWeight = 0;
    }

    @Override
    public void addItem(Item item) {
        if (item.getWeight() + currentWeight <= maxWeight) {
            items.add(item);
            currentWeight += item.getWeight();
        }
    }

    @Override
    public boolean isInBox(Item item) {
        for (Item i : items) {
            if (i.getName().equals(item.getName())) {
                return true;
            }
        }
        return false;
    }

}

class INHERITANCE002 {
    public static void main(String[] args) {
        BoxWithMaxWeight box = new BoxWithMaxWeight(10, 0);
        Item item1 = new Item("Saludo", 5);
        Item item2 = new Item("Prikka", 5);
        Item item3 = new Item("Kopi Luwak", 5);

        box.addItem(item1);
        System.out.println(box.isInBox(item1)); // true

        box.addItem(item2);
        System.out.println(box.isInBox(item2)); // true
        
        box.addItem(item3);
        System.out.println(box.isInBox(item3)); // false, because the box is full
    }
}
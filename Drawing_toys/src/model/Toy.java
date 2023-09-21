package model;

/**
 * @author <a href="Larin";
 * Класс игрушка, представляющий собой модель игрушки в магазине
 */
public class Toy implements Comparable<Toy> {

    private int id;

    private String name;

    private int weight;


    public Toy(int id, String name, int weight) {
        this.id = id;
        this.name = name;
        this.weight = weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Игрушка: " + name +  " с порядковым номером " + id;
    }


    @Override
    public int compareTo(Toy o) {
        return this.weight - o.weight;
    }
}
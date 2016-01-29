package mule.models;

public enum Resource {

    FOOD(30, "Food"),
    ENERGY(25, "Energy"),
    SMITHORE(50, "Smithore"),
    FOODMULE(125, "Food-Mule"),
    ENERGYMULE(150, "Energy-Mule"),
    SMITHOREMULE(175, "Ore-Mule");

    private final int price;
    private String name;

    private Resource(int price, String name) {
        this.price = price;
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public String toString() {
        return name;
    }

}
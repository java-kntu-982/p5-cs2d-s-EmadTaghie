package ir.ac.kntu.cs2d.model.armory.gun;

import java.util.Objects;

public class Vest implements Cloneable {
    private int health;
    private int price;

    public Vest(){
        setHealth(80);
        setPrice(1000);
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vest vest = (Vest) o;
        return health == vest.health &&
                price == vest.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(health, price);
    }
}
